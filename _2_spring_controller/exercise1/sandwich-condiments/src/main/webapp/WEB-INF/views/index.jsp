<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 07/13/20
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
    <h1>Sandwich Condiments</h1>
    <form action="/save" method="post">
        <input type="checkbox" name="condiment" value="Lettuce"/>Lettuce
        <input type="checkbox" name="condiment" value="Tomato"/>Tomato
        <input type="checkbox" name="condiment" value="Mustard"/>Mustard
        <input type="checkbox" name="condiment" value="Sprouts"/>Sprouts
        <br>
        <input type="submit" value="Save"/>
    </form>
    <label>Condiments</label><br>
    <span>${result}</span>
</body>
</html>
