<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 30759
  Date: 2020/7/13
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>
            <%
                User user =new User();
                user.setName("张三");
                user.setAge(23);
                user.setBirthday(new Date());

                request.setAttribute("u",user);
            %>
<h3>el表达式获取对象中的值</h3>
${requestScope.u}
<%--
通过的是对象的属性来获取
   *setter或getter方法,去掉set或get，将剩余部分首字母变小写
   *setName-->Name-->name
--%>

${requestScope.u.name}
${u.birStr}
</body>
</html>
