<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 07/13/20
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <script>
        function calculate(sign) {
            document.getElementById("sign").value = sign;
            document.getElementById("formNum").submit();
        }
    </script>
</head>
<body>
    <h1>Calculator</h1>
    <form id="formNum" action="/calculate" method="post">
        <input id="sign" type="hidden" name="sign" value="+"/>
        <input type="text" name="firstNum" value="${firstNum}" />
        <input type="text" name="secondNum" value="${secondNum}" />
        <br>
        <input type="button" value="Addition(+)" onclick="calculate('+')"/>
        <input type="button" value="Subtraction(-)" onclick="calculate('-')"/>
        <input type="button" value="Multiplication(x)" onclick="calculate('*')"/>
        <input type="button" value="Division(/)" onclick="calculate('/')"/>
    </form>
    <label>Result: </label><span>${result}</span>
</body>
</html>
