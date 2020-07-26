<%--
  Created by IntelliJ IDEA.
  User: 30759
  Date: 2020/7/14
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>

        ${pageContext.request}<br>
<H4>动态获取虚拟目录</H4>
${pageContext.request.contextPath}
        <%
        response.sendRedirect(request.getContextPath());
        %>
</body>
</html>
