package com.tutoring.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("interceptor");
		ActionContext context = arg0.getInvocationContext();
		Map<String, Object> session = context.getSession();
		
		String actionName = context.getName();
		System.out.println(actionName);
		
		if(actionName.equals("LoginAction")||actionName.equals("RegisterAction"))
			return arg0.invoke();
		
		if(session.get("email")!=null){
			return arg0.invoke();
		}
		
		return "sessionError";
		//return arg0.invoke();
	}

}
