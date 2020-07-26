package cn.AndiOS.FILTER;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证过滤器
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0强制转换
        HttpServletRequest request =(HttpServletRequest) req;
        //1.获取请求资源请求路径
        String URI = request.getRequestURI();
        //排除css/js/图片/验证码等资源
        if(URI.contains("/login.jsp")||URI.contains("/loginServlet")||URI.contains("/checkCode"))

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
