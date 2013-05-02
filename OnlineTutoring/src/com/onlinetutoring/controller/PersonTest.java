package com.onlinetutoring.controller;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class PersonTest
 */
@WebServlet(description = "Test ajax with servlet", urlPatterns = { "/PersonTest" })
public class PersonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonTest() {
        super();
        // TODO Auto-generated constructor stub
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
		response.setContentType("text/xml;charset=UTF-8");  
		
        PrintWriter out = response.getWriter();  
        try {  
        	
        	System.out.println("ok");
        	
        	//print request content
            ServletInputStream is = request.getInputStream();   
            ByteArrayOutputStream baos = null;   
            baos = new ByteArrayOutputStream();   
            int iLength = 1024;   
            int bytesRead = 0;   
            byte[] buff = new byte[iLength];   
            while (true)   
            {   
                bytesRead = is.read(buff);   
                if (bytesRead < 1)   
                break;   
                baos.write(buff, 0, bytesRead);   
            }   
            System.out.println(new String(baos.toByteArray(), "utf-8"));
            
            String type = request.getContentType();
            String email = request.getParameter("email");  
            String password = request.getParameter("password");
                   
            System.out.println(email + "  " + password);
            System.out.println(type);

            if(email.equals("163") && password.equals("111")) {  
                out.write("OK");  
            }  
            else {  
                out.write("NO");  
            }  
        } finally {   
            out.close();  
        }  
	}

}
