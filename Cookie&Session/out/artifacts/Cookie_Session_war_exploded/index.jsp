<%--
  Created by IntelliJ IDEA.
  User: 30759
  Date: 2020/6/26
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%
    System.out.println("hello jsp");
    String contextPath = "Cookie";
    out.print(contextPath);
  %>
  <h1>hi.jsp</h1>
  <% response.getWriter().write("reponse");%>
  </body>
</html>
