<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 30759
  Date: 2020/7/14
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--
c:if标签
    1.属性：
        test 必须的属性，接受boolean表达式
           *如果表达式为true，则显示为标签体内容，如果为false则不显示为标签体内容
           *一般情况下,test属性值会结合el表达式一起使用
   2.注意：c:if标签没有else情况，想要else，则可以再定义一个c：if标签
--%>
<c:if test="true">
    true
</c:if>
<%
//判断request域中一个list集合是否为空，如果不为空，则遍历集合
    List list = new ArrayList();
    list.add("aaa");
    request.setAttribute("list",list);
    request.setAttribute("number",3);
%>
<c:if test="${not empty list}">

</c:if>
<c:if test="${number %2!=0}">
    ${number}为基数
</c:if>

</body>
</html>
