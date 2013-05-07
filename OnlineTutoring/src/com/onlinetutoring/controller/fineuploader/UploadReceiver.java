package com.onlinetutoring.controller.fineuploader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class UploadReceiver
 */
@WebServlet(description = "Test upload files", urlPatterns = { "/UploadReceiver" })
public class UploadReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Absolute path on your disk, change it!
	private static final String FILE_PATH = "G:/Temp";
    
	private static final File UPLOAD_DIR = new File(FILE_PATH + "/uploads");
    private static File TEMP_DIR = new File(FILE_PATH + "/uploadsTemp");

    private static String CONTENT_LENGTH = "Content-Length";
    private static int SUCCESS_RESPONSE_CODE = 200;

    final Logger log = LoggerFactory.getLogger(UploadReceiver.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadReceiver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		UPLOAD_DIR.mkdirs();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestParser requestParser = null;

        boolean isIframe = request.getHeader("X-Requested-With") == null || !request.getHeader("X-Requested-With").equals("XMLHttpRequest");

        try
        {
        	response.setContentType(isIframe ? "text/html" : "text/plain");
        	response.setStatus(SUCCESS_RESPONSE_CODE);

//            resp.addHeader("Access-Control-Allow-Origin", "http://192.168.130.118:8080");
//            resp.addHeader("Access-Control-Allow-Credentials", "true");
//            resp.addHeader("Access-Control-Allow-Origin", "*");

            if (ServletFileUpload.isMultipartContent(request))
            {
                MultipartUploadParser multipartUploadParser = new MultipartUploadParser(request, TEMP_DIR, getServletContext());
                requestParser = RequestParser.getInstance(request, multipartUploadParser);
                writeFileForMultipartRequest(requestParser);
                writeResponse(response.getWriter(), requestParser.generateError() ? "Generated error" : null, isIframe, false, requestParser);
            }
            else
            {
                requestParser = RequestParser.getInstance(request, null);
                writeFileForNonMultipartRequest(request, requestParser);
                writeResponse(response.getWriter(), requestParser.generateError() ? "Generated error" : null, isIframe, false, requestParser);
            }
        } catch (Exception e)
        {
            log.error("Problem handling upload request", e);
            if (e instanceof MergePartsException)
            {
                writeResponse(response.getWriter(), e.getMessage(), isIframe, true, requestParser);
            }
            else
            {
                writeResponse(response.getWriter(), e.getMessage(), isIframe, false, requestParser);
            }
        }
        finally {
        	System.out.println(log.toString());
        }
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getPathInfo().replaceAll("/", "");

        FileUtils.deleteDirectory(new File(UPLOAD_DIR, uuid));

        if (new File(UPLOAD_DIR, uuid).exists())
        {
            log.warn("couldn't find or delete " + uuid);
        }
        else
        {
            log.info("deleted " + uuid);
        }

        response.setStatus(SUCCESS_RESPONSE_CODE);
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(SUCCESS_RESPONSE_CODE);
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
//        resp.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Allow-Methods", "POST, DELETE");
		response.addHeader("Access-Control-Allow-Headers", "x-requested-with, cache-control, content-type");
	}

	private void writeFileForNonMultipartRequest(HttpServletRequest req, RequestParser requestParser) throws Exception
    {
        File dir = new File(UPLOAD_DIR, requestParser.getUuid());
        dir.mkdirs();

        String contentLengthHeader = req.getHeader(CONTENT_LENGTH);
        long expectedFileSize = Long.parseLong(contentLengthHeader);

        if (requestParser.getPartIndex() >= 0)
        {
            writeFile(req.getInputStream(), new File(dir, requestParser.getUuid() + "_" + String.format("%05d", requestParser.getPartIndex())), null);

            if (requestParser.getTotalParts()-1 == requestParser.getPartIndex())
            {
                File[] parts = getPartitionFiles(dir, requestParser.getUuid());
                File outputFile = new File(dir, requestParser.getFilename());
                for (File part : parts)
                {
                    mergeFiles(outputFile, part);
                }

                assertCombinedFileIsVaid(requestParser.getTotalFileSize(), outputFile, requestParser.getUuid());
                deletePartitionFiles(dir, requestParser.getUuid());
            }
        }
        else
        {
            writeFile(req.getInputStream(), new File(dir, requestParser.getFilename()), expectedFileSize);
        }
    }


    private void writeFileForMultipartRequest(RequestParser requestParser) throws Exception
    {
        File dir = new File(UPLOAD_DIR, requestParser.getUuid());
        dir.mkdirs();

        if (requestParser.getPartIndex() >= 0)
        {
            writeFile(requestParser.getUploadItem().getInputStream(), new File(dir, requestParser.getUuid() + "_" + String.format("%05d", requestParser.getPartIndex())), null);

            if (requestParser.getTotalParts()-1 == requestParser.getPartIndex())
            {
                File[] parts = getPartitionFiles(dir, requestParser.getUuid());
                File outputFile = new File(dir, requestParser.getOriginalFilename());
                for (File part : parts)
                {
                    mergeFiles(outputFile, part);
                }

                assertCombinedFileIsVaid(requestParser.getTotalFileSize(), outputFile, requestParser.getUuid());
                deletePartitionFiles(dir, requestParser.getUuid());
            }
        }
        else
        {
            writeFile(requestParser.getUploadItem().getInputStream(), new File(dir, requestParser.getFilename()), null);
        }
    }

    private void assertCombinedFileIsVaid(int totalFileSize, File outputFile, String uuid) throws MergePartsException
    {
        if (totalFileSize != outputFile.length())
        {
            deletePartitionFiles(UPLOAD_DIR, uuid);
            outputFile.delete();
            throw new MergePartsException("Incorrect combined file size!");
        }

    }


    private static class PartitionFilesFilter implements FilenameFilter
    {
        private String filename;
        PartitionFilesFilter(String filename)
        {
            this.filename = filename;
        }

        @Override
        public boolean accept(File file, String s)
        {
            return s.matches(Pattern.quote(filename) + "_\\d+");
        }
    }

    private static File[] getPartitionFiles(File directory, String filename)
    {
        File[] files = directory.listFiles(new PartitionFilesFilter(filename));
        Arrays.sort(files);
        return files;
    }

    private static void deletePartitionFiles(File directory, String filename)
    {
        File[] partFiles = getPartitionFiles(directory, filename);
        for (File partFile : partFiles)
        {
            partFile.delete();
        }
    }

    private File mergeFiles(File outputFile, File partFile) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(outputFile, true);

        try
        {
            FileInputStream fis = new FileInputStream(partFile);

            try
            {
                IOUtils.copy(fis, fos);
            }
            finally
            {
                IOUtils.closeQuietly(fis);
            }
        }
        finally
        {
            IOUtils.closeQuietly(fos);
        }

        return outputFile;
    }

    private File writeFile(InputStream in, File out, Long expectedFileSize) throws IOException
    {
        FileOutputStream fos = null;

        try
        {
            fos = new FileOutputStream(out);

            IOUtils.copy(in, fos);

            if (expectedFileSize != null)
            {
                Long bytesWrittenToDisk = out.length();
                if (!expectedFileSize.equals(bytesWrittenToDisk))
                {
                    log.warn("Expected file {} to be {} bytes; file on disk is {} bytes", new Object[] { out.getAbsolutePath(), expectedFileSize, 1 });
                    out.delete();
                    throw new IOException(String.format("Unexpected file size mismatch. Actual bytes %s. Expected bytes %s.", bytesWrittenToDisk, expectedFileSize));
                }
            }

            return out;
        }
        catch (Exception e)
        {
            throw new IOException(e);
        }
        finally
        {
            IOUtils.closeQuietly(fos);
        }
    }

    private void writeResponse(PrintWriter writer, String failureReason, boolean isIframe, boolean restartChunking, RequestParser requestParser)
    {
        if (failureReason == null)
        {
//            if (isIframe)
//            {
//                writer.print("{\"success\": true, \"uuid\": \"" + requestParser.getUuid() + "\"}<script src=\"http://192.168.130.118:8080/client/js/iframe.xss.response.js\"></script>");
//            }
//            else
//            {
                writer.print("{\"success\": true}");
//            }
        }
        else
        {
            if (restartChunking)
            {
                writer.print("{\"error\": \"" + failureReason + "\", \"reset\": true}");
            }
            else
            {
//                if (isIframe)
//                {
//                    writer.print("{\"error\": \"" + failureReason + "\", \"uuid\": \"" + requestParser.getUuid() + "\"}<script src=\"http://192.168.130.118:8080/client/js/iframe.xss.response.js\"></script>");
//                }
//                else
//                {

                    writer.print("{\"error\": \"" + failureReason + "\"}");
//                }
            }
        }
    }

    private class MergePartsException extends Exception
    {
        MergePartsException(String message)
        {
            super(message);
        }
    }
}
