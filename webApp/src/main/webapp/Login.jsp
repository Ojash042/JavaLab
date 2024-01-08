<%--
  Created by IntelliJ IDEA.
  User: ojash
  Date: 1/4/24
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login" method="post">
    <label for="username">Username</label>
    <input type="text" id="username" name="username"/>
    <label for="password">Password</label>
    <input type="password" id="password" name="password">
    <input type="submit" value="Submit">
</form>
</body>
</html>
