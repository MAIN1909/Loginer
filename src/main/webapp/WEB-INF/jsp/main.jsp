<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<html>--%>
<%--<head>--%>
<%--<title>Главная</title>--%>
<%--</head>--%>
<%--<body style='background:url(http://i.piccy.info/i9/a0cd8340a4c2e5f8a59d25f90bb7887a/1544398933/376884/1287748/fone.jpg)'>--%>
<%--<div>--%>
<%--<form action='/loginer/search'>--%>
<%--<input type='text' name='name'/>--%>
<%--<input type='submit' value='Search'/>--%>
<%--</form>--%>
<%--</div>--%>
<%--<div>--%>
<%--<form action='/loginer/add'>--%>
<%--<input type='submit' value='Create new item'/>--%>
<%--</form>--%>
<%--</div>--%>
<%--<h1 align='center'></h1>--%>

<%--<c:forEach items="${items}" var="i">--%>
<%--<div align='center'>--%>
<%--<a href='/loginer/item?id=${i.getId().toString()}'>--%>
<%--<img src='${i.pic}'/>--%>
<%--</a><br/>--%>
<%--<p>--%>
<%--<h2>${i.name}</h2></p>--%>
<%--<h3>${i.description}</h3>--%>
<%--Price: ${i.price}--%>
<%--id: ${i.id}--%>
<%--</div>--%>
<%--</c:forEach>--%>
<%--</body>--%>
<%--</html>--%>
<html lang="en">
<style>
    <%@include file='css.css' %>

</style>
<head>
    <meta charset="UTF-8">
    <title>Логинер</title>
    <link rel="stylesheet" href="css.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

</head>
<body>
<header>
    <div class="logo">
        <a href="index.html"><img class="img-logo"
                                  src="C:\Users\Lenovo\IdeaProjects\LoginerNew\src\main\webapp\WEB-INF\jsp\logo.jpg"
                                  alt="Logo"></a>
    </div>
    <nav>
        <div class="topnav" id="myTopnav">
            <a href="index.html">Главная</a>
            <a href="store.html">Каталог</a>
            <a href="auth.html">Авторизация</a>
            <a href="reg.html">Регистрация</a>
        </div>
    </nav>
</header>

<main>
    <div>
    <form action='/loginer/search'>
        <input type='text' name='name'/>
        <input type='submit' value='Search'/>
    </form>
    </div>
    <div>
    <form action='/loginer/add'>
        <input type='submit' value='Create new item'/>
    </form>
    </div>
    <div class="container">
        <c:forEach items="${items}" var="i">
            <div class="item">
        <a href='/loginer/item?id=${i.getId().toString()}'>
            <img src='${i.pic}'/>
        </a><br/>
        <p>
        <h2>${i.name}</h2></p>
        <h3>${i.description}</h3>
                <h3 typeof="bold">Price: ${i.price}</h3><br/>
                id: ${i.id}<br/>
                <button>Добавить в корзину</button>
            </div>
        </c:forEach>


    </div>
</main>

</body>
</html>
