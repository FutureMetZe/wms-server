package com.eshore.wms.config.sys;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecutriyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request2 = (HttpServletRequest)request;
		HttpServletResponse response2 = (HttpServletResponse)response;
        response2.setHeader("Access-Control-Allow-Origin",request2.getHeader("origin"));
        response2.setHeader("Access-Control-Allow-Origin","*");  //允许跨域访问的域
        response2.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE,PUT");  //允许使用的请求方法
        response2.setHeader("Access-Control-Expose-Headers","*");
        response2.setHeader("Access-Control-Allow-Headers", "x-requested-with,Cache-Control,Pragma,Content-Type,Authorization");  //允许使用的请求方法
        response2.setHeader("Access-Control-Allow-Credentials","true");//是否允许请求带有验证信息
      
        if(request2.getMethod().equals("OPTIONS")){
            response2.setStatus(HttpServletResponse.SC_OK);
            return;
        }else {
        	 chain.doFilter(request, response2);
        }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
