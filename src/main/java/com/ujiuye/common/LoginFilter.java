package com.ujiuye.common;

import com.ujiuye.sys.bean.Employee;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        HttpServletResponse response1 = (HttpServletResponse)response;
        Employee employee = (Employee)servletRequest.getSession().getAttribute("loginUser");

        String requestURI = servletRequest.getRequestURI();

        if (employee != null || requestURI.contains("getCode") || requestURI.contains("login") || requestURI.contains("images") || requestURI.contains("skin") || requestURI.contains("static") ){
            chain.doFilter(request,response);

        }else {
            response1.sendRedirect(servletRequest.getContextPath()+"/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
