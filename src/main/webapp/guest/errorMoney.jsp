<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Market</title>
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

<h2><p align="center">You don't have enough money!</p></h2>

</body>
</html>