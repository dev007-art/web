package cn.AndiOS.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
案例：记住上一次访问时间：
           1.需求
               1.需求。访问一个servlet,如果是第一次，则提示:您好，欢迎首次访问
               2.如果不是第一次，则提示，欢迎回来，您上次访问时间为：显示时间字符串
           2.分析：
                 1.可以采用cookie来完成
                 2.在服务器中的Servlet判断是否有一个lastTime的cookie
                          1.有：不是第一次访问
                                1.响应数据：欢迎回来，您上一次访问时间为：显示字符串
                                2.写回cookie
                          2.没有：使第一次访问
                                1.响应数据：您好，欢迎首次访问
                                2.写回Cookie:lastTime=2020年6月20日11：44：22
 */
@WebServlet("/CookieText")
public class CookieText extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应消息体的数据格式和编码
        response.setContentType("text/html;charset=utf-8");
        //1.获取所有cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有cookie为lasttime
        //2.遍历cookie数组
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie:cookies) {
                //3.获取cookie名称
                String name =cookie.getName();
                //4.判断名称是否为：lastname
                if("lastTime".equals(name)){
                    //有该cookie，不是第一次访问
                    flag=true;//有lasttime的cookie

                    //响应数据
                    //获取cookie的value，时间
                    String value = cookie.getValue();
                    value=URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上一次访问时间为："+value+"<h1>");


                    //获取当前时间的字符串，重新设置cookie的值
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = simpleDateFormat.format(date);
                    System.out.println("编码前："+str_date);
                    //设置URL编码
                    str_date= URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后"+str_date);
                    //设置cookie的value
                    cookie.setValue(str_date);
                    //设置cookie的存活时间
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);


                    break;
                }
            }
        }
        if (cookies==null ||cookies.length==0||flag==false){
            //没有
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = simpleDateFormat.format(date);
            str_date =URLEncoder.encode(str_date,"utf-8");
            Cookie cookie = new Cookie("lastTime", str_date);
            //设置cookie的存活时间
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎您第一次访问<h1>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
