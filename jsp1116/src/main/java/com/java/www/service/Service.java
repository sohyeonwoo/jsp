package com.java.www.service;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {

	public void execute(HttpServletRequest request,HttpServletResponse response);
	
	
	
}
