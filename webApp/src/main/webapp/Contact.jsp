<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact</title>
</head>
<body>
<form method="post" action="add">
    <label for="name">Name</label>
    <input type="text" id="name" name="name"/>
    <label for="mail">Mail</label>
    <input type="email" id="mail" name="mail"/>
    <label for="phone">Phone</label>
    <input type="text" id="phone" name="phone"/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>