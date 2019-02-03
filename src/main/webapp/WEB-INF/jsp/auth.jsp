<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--<html>--%>
<%--<head>--%>
<%--<title>Логинер</title>--%>
<%--</head>--%>
<%--<body style='background:url(http://i.piccy.info/i9/a0cd8340a4c2e5f8a59d25f90bb7887a/1544398933/376884/1287748/fone.jpg)'>--%>
<%--<div>--%>
<%--<form action='/loginer/' method='POST'>--%>
<%--<input type='text' name='login'/>--%>
<%--<input type="password" class="form-control" name="j_password" placeholder="Password" required value="1234">--%>
<%--<input type='submit' value='Sign In Me'/>--%>
<%--</form>--%>
<%--</div>--%>
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
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>--%>
</head>
<body>
<header>
    <div class="logo">
        <a href="main.jsp"><img class="img-logo"
                                src="C:\Users\Lenovo\IdeaProjects\LoginerNew\src\main\webapp\WEB-INF\jsp\logo.jpg"
                                alt="Logo"></a>
    </div>
    <nav>
        <div class="topnav" id="myTopnav">
            <a href="main.jsp">Главная</a>
            <a href="main.jsp">Каталог</a>
            <a href="auth.jsp">Авторизация</a>
            <a href="reg.html">Регистрация</a>
        </div>
    </nav>
</header>

<main>
    <div class="container-form">

        <form action='' method='POST'>
            <br>
            <h1>Авторизация</h1>
            <input type="text" placeholder="Логин" name='login'><br>
            <input type="password" placeholder="Пароль"><br>
            <input type="submit" value="Не дави на меня">
        </form>
    </div>
</main>

</body>
</html>