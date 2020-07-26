<%--
  Created by IntelliJ IDEA.
  User: 30759
  Date: 2020/7/12
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取域中对象</title>
</head>
<body>
<%
request.setAttribute("NAME","zhangsan");
session.setAttribute("age","23");

%>
<h3>el获取值</h3>
${requestScope.NAME}
${sessionScope.age}
</body>
</html>
