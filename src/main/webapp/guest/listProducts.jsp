<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 7/22/2022
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Products</title>
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
<h3><p style="text-align:center"> List of all products</p></h3>
<br>

<table align="center"; width="300"; border="1";>
    <tr>
        <th>Product Id</th>
        <th>Name</th>
        <th>Price,$</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Java Language Specification</td>
        <td>20.0</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Professional Java Development with the Spring Framework</td>
        <td>30.0</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Clean Code</td>
        <td>40.0</td>
    </tr>
</table>

</body>
</html>
