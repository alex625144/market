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
    <a href="${pageContext.request.contextPath}/guest?command=buy&list=user_id" style="font-size: 20px;">List Users by UserID</a>
    <a href="${pageContext.request.contextPath}/guest?command=buy&list=product_id" style="font-size: 20px;">List Users by ProductID</a>

</div>

<form align="center" method="post" action="${pageContext.request.contextPath}/guest?command=buy&list=0">
<br/>
    <div class="container">
        <%--@declare id="UserId"--%><%--@declare id="ProductId"--%>
        <h3><p>For buy product please enter your UserId (from 1-3) and ProductId (from 1-3)</p></h3>
        <label for="UserId"><b>UserID</b></label>
        <input type="text" placeholder="Enter UserId" name="userId" required>

            <p style="color:red;">${userIdNotValidateMessage}</p
        <br><br>
        <label for="ProductId"><b>ProductId</b></label>
        <input type="ProductId" placeholder="Enter ProductId" name="productId" required>

            <p style="color:red;">${productIdNotValidateMessage}</p
        <br><br>
        <button type="Buy">Buy</button>

    </div>
</form>

</body>
</html>