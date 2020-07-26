package cn.AndiOS.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0强制转换
        HttpServletRequest request =(HttpServletRequest) req;
        //1.获取请求资源请求路径
        String URI = request.getRequestURI();
        if(URI.contains("/index.jsp")||URI.contains("/ls")||URI.contains("/css/")||URI.contains("/img/")){
            //包含，放行
            chain.doFilter(req, resp);
        }else{
            //不包含,验证用户是否登录
            //3.从session获取user
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                //登录了，放行
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/index.jsp").forward(request,resp);
            }

        }
        

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
