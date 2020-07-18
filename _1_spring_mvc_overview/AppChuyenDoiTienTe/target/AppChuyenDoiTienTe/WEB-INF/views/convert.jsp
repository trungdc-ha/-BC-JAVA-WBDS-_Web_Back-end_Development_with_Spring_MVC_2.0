<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 7/14/2020
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert" method="post">
    <label>Rate: </label> <br />
    <input type="text" name="rate" placeholder="rate" value="${rate}"/> <br/>
    <label>USD: </label> <br />
    <input type="text" name="usd" placeholder="USD" value="${usd}" /> <br/>
    <input type="submit" value="Converter">
    <h1>VND: ${result}</h1>
</form>
</body>
</html>
