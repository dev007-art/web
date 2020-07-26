<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 30759
  Date: 2020/6/28
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <%
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
                     value= URLDecoder.decode(value,"utf-8");
                     out.write("<h1>欢迎回来，您上一次访问时间为："+value+"<h1>");


                     //获取当前时间的字符串，重新设置cookie的值
                     Date date = new Date();
                     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                     String str_date = simpleDateFormat.format(date);
                     //设置URL编码
                     str_date= URLEncoder.encode(str_date,"utf-8");
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
             response.addCookie(cookie);n
             %>
            out.write("<h1>欢迎您第一次访问<h1>");
             <%
         }


     %>

</body>
</html>
