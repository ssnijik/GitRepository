package com.onlinetutoring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.onlinetutoring.pojo.Person;

/**
 * Servlet implementation class TestJson
 */
@WebServlet(description = "Test json to servlet", urlPatterns = { "/TestJson" })
public class TestJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJson() {
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
		Gson gson = new Gson();
		
		Person person = gson.fromJson(request.getReader(), Person.class);
		
		System.out.println(person.getEmail());
		System.out.println(person.getPassword());
		
		Person pa = new Person("aaa", "bbb", "e@mail.com", "nopass");
		
		System.out.println(gson.toJson(pa));
		PrintWriter out = response.getWriter();
		
		try {
			out.write(gson.toJson(pa));
		}
		finally {
			out.close();
		}
		
		
	}

}