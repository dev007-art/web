package cn.AndiOS.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
获取referer请求头演示
 */
@WebServlet( "/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("referer");
        System.out.println(referer);

        //防盗链
        if (referer != null) {
            if (referer.contains("/Tomcat_servlet")) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("播放电影");
            } else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("不播放电影");
            }
        }
    }
}