package com.tutoring.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URLFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		//System.out.println(httpServletRequest.getContextPath()+"/webs/Login.jsp");
		if(isIncludePages(httpServletRequest.getRequestURI())){
			System.out.println("include");
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/webs/urlError.htm");
		}
		chain.doFilter(request, response);
		return;
	}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	private boolean isIncludePages(String url){
		
		return url.endsWith(".jsp");
	} 

}
