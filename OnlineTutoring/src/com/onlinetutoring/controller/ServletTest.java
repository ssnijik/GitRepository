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
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
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
//		response.setContentType("text/xml;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
        PrintWriter out = response.getWriter();  
        try {  
        	
//        	request.getInputStream();
            String email = request.getParameter("email");  
            String password = request.getParameter("password");
                   
            System.out.println(email + "  " + password);

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
