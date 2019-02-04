<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Регистрация</title>
</head>
<body style='background:url(http://i.piccy.info/i9/a0cd8340a4c2e5f8a59d25f90bb7887a/1544398933/376884/1287748/fone.jpg)'>
<div>
    <h3>Enter login:</h3>
    <form action='/loginer/register' method='POST'>
        <input type='text' name='login'/></br>
        <h3>Enter pass:</h3>
        <input type='text' name='pass'/></br>
        <h3>Confirm pass:</h3>
        <input type='text' name='passConfirm'/></br>
        <input type='submit' value='Register'/>
    </form>
</div>
</body>
</html>
