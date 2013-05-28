package com.tutoring.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.tutoring.biz.TopicBiz;


public class DownloadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TopicBiz topicBiz;
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}

	private String fileName=null;
	
	public InputStream getInputStream() throws Exception {   
        return new java.io.FileInputStream(ServletActionContext.getServletContext().getRealPath( "/download" )+"/"+fileName);   
    }
	
	public String execute() throws Exception{
		//System.out.println(fileName);
		File file = new File(ServletActionContext.getServletContext().getRealPath( "/download" )+"/"+fileName);
		if(file.exists())
		{
			return SUCCESS;
		}
		else
			return ERROR;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getDownloadFileName() {   
		  
        String downFileName=null;
  
        try {   
  
            downFileName = new String(topicBiz.getRealFileName(fileName).getBytes(), "ISO8859-1");   
  
        } catch (UnsupportedEncodingException e) {   
  
            e.printStackTrace();   
  
        }   
  
        return downFileName;
  
    }   
}
