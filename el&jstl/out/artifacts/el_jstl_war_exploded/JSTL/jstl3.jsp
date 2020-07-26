<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 30759
  Date: 2020/7/14
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<%--foreach：相当于java代码的for语句
      1.完成重复操作
      for(int i=0;i<10;i++){
      }
           *属性：
                begin：开始
                end：结束
                var:相当于i
                step:相当于步长
                varStatus:循环状态对象
                       index:容器中元素的索引，从0开始
                       count:循环次数
      2.遍历
      List(User) LIST;
      for(Uset user:list){
      }
      *属性：
      items；容器对象 list
      var：容器中元素零时变量 user
--%>
<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
    ${i}<h3>${s.index}</h3><h4>${s.count}</h4><br>
</c:forEach>
<hr>
<%
    List list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    request.setAttribute("list",list);
%>
<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index} ${s.count} ${str}<br>
</c:forEach>
</body>
</html>
