<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
    <h1>Settings</h1>
    <form:form action="/update" method="post" modelAttribute="configEmail">
        <form:label path="languages">Languages:</form:label>
        <form:select path="languages">
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese</form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese</form:option>
        </form:select>
        <br>
        <form:label path="page">Page Size:</form:label>
        <span>Show</span>
        <form:select path="page">
            <form:option value="5">5</form:option>
            <form:option value="10">10</form:option>
            <form:option value="15">15</form:option>
            <form:option value="25">25</form:option>
            <form:option value="50">50</form:option>
            <form:option value="100">100</form:option>
        </form:select>
        <span>emails per page</span>
        <br>
        <form:label path="filter">Spams filter: </form:label>
        <form:checkbox path="filter" />Enable spams filter
        <br>
        <form:label path="signature">Signature: </form:label>
        <form:textarea path="signature" cols="20" rows="5"></form:textarea>
        <br>
        <input type="submit" value="Update"/>
        <input type="button" value="Cancel"/>
    </form:form>
</body>
</html>
