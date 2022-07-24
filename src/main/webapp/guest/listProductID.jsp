<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

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
    <a href="${pageContext.request.contextPath}/guest?command=buy&list=user_id" style="font-size: 20px;">List Users by UserID</a>
    <a href="${pageContext.request.contextPath}/guest?command=listProductID" style="font-size: 20px;">List Users by ProductID</a>

</div>


<table align="center"; border="1"; >
    <tr>
        <th>list users for product id = 1</th>
        <th>list users for product id = 2 </th>
        <th>list users for product id = 3 </th>
    </tr>

    <tr>
        <td width="100">${list1} </td>
        <td width="100">${list2} </td>
        <td width="100">${list3} </td>

    </tr>

</table>
</body>
</html>