package com.restaurant.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {
	public SecurityFilter() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init in Filter");
	}

	public void destroy() {
		System.out.println("Destroy in filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		Enumeration<String> parameters = httpRequest.getParameterNames();
		String parameter;
		while(parameters.hasMoreElements())
		{
			parameter = parameters.nextElement();
			String paramValues[] = httpRequest.getParameterValues(parameter);
			System.out.println("Parameter values of "+parameter);
			for(String pValue: paramValues)
			{
				pValue = pValue.trim().toLowerCase();
				if(pValue.contains("script") || pValue.contains(">") || pValue.contains("<") )
				{
					System.out.println("Forbidden request");
					httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid request,"
							+ " Dont try to manipulate the request");
					httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
				}
			}
			System.out.println(String.join(" ", paramValues));
		}
		
		
		System.out.println("End of doFilter");
		chain.doFilter(request, response);
	}
}
