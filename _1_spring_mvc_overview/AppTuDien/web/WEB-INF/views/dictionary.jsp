<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 7/1/2020
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictinonary" method="post">
    <label>Vietnamese dictionary</label> <br/>
    <input type="text" name="word" value="${word}">
    <input type="submit">
</form>
<div>
    <h1>Vietnamese Meaning: ${result}</h1>
</div>
</body>
</html>
