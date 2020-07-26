package cn.AndiOS.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
/*
获取user-agent请求头演示
 */
@WebServlet( "/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if(agent.contains("Edge")){
            //谷歌浏览器
            System.out.println("Edge");
        }else if(agent.contains("Chrome")){
            System.out.println("Chrome");
        }
        }
    }
