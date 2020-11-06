package com.myspring.musicnerd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.myspring.musicnerd.filter.EncryptWrapper;


public class EncryptFilter implements Filter{
	public EncryptFilter() {}
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
        EncryptWrapper encW = new EncryptWrapper(req);
        encW.getParameter("pw");
	        
	    chain.doFilter(encW, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
    }
}
