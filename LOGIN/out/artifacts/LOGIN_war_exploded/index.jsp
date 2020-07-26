<%--
  Created by IntelliJ IDEA.
  User: 30759
  Date: 2020/6/17
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="css/style.css" />
  <link rel="stylesheet" href="css/iconfont.css" />
  <title>登录界面</title>
</head>
<body>
<form action="/ls" method="post">
  <div id="bigBox">
    <h1>LOGIN</h1>
    <div class="inputBox">
      <div class="inputText">
        <span class="iconfont icon-nickname"></span>
        <input type="text" placeholder="username" name="username"/>
      </div>
      <div class="inputText">
        <span class="iconfont icon-visible"></span>
        <input type="password" placeholder="password" name="password"/>
      </div>
    </div>
    <input class="loginButton" type="submit" value="Login" />
  </div>
  ${requestScope.login_msg}
</form>
</body>
</html>
