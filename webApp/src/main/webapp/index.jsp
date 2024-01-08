<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<% String username = (session.getAttribute("username") != null) ? "admin" : "";%>

<h1>Hello
    <%=username%>
</h1>
<%=(session.getAttribute("username")!=null)%>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>