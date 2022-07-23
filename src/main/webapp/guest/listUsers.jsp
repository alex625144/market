<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 7/22/2022
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>List Users</title>
</head>
<style>
    h1 {
        text-align: center;
    }
    body {
        background-color: #85C1E9 ;
        margin-left: 10%;
        margin-right: 10%;
        border: 2px dotted black;
        padding: 10px 10px 10px 10px;
        font-family: sans-serif;
    }
</style>
<body>
<h1><%= "Welcome to the Market!" %>
</h1>
<br/>

<div style="text-align: center">
    <a href="${pageContext.request.contextPath}/" style="font-size: 20px;"></a>
    <a href="${pageContext.request.contextPath}/index.jsp" style="font-size: 20px;">Home</a>
    <a href="${pageContext.request.contextPath}/guest?command=listUsers" style="font-size: 20px;">List Users</a>
    <a href="${pageContext.request.contextPath}/guest?command=listProducts" style="font-size: 20px;">List Products</a>
</div>
<h3><p style="text-align:center"> List of all users</p></h3>
<br>
<table align="center"; width="300"; border="1";>
    <tr>
        <th>user Id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Amount of money</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Rod</td>
        <td>Johnson</td>
        <td>100.0</td>
    </tr>
    <tr>
        <td>2</td>
        <td>James</td>
        <td>Gosling</td>
        <td>100.0</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Robert</td>
        <td>Martin</td>
        <td>100.0</td>
    </tr>
</table>

</body>
</html>
