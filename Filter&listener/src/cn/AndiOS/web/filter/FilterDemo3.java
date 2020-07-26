package cn.AndiOS.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp")// 1.具体资源路径：/index.jsp 只有访问index.jsp资源时，才会被执行
//@WebFilter("/user/*")// 2.目录拦截：/user/* 访问/user下所有资源时，过滤器都会被执行
public class FilterDemo3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
