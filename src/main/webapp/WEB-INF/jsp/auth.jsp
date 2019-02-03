<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Логинер</title>
</head>
<body style='background:url(http://i.piccy.info/i9/a0cd8340a4c2e5f8a59d25f90bb7887a/1544398933/376884/1287748/fone.jpg)'>
<div>
    <h3>Enter login:</h3>
    <form action='/loginer/' method='POST'>
        <input type='text' name='login'/>
        <h3>Enter pass:</h3>
        <input type='text' name='pass'/></br>
        <input type='submit' value='Sign In Me'/>
    </form>
    <h4>You can use registration button :)</h4>
    <form action='/loginer/register'>
        <input type='submit' value='Registration'/>
    </form>
</div>
</body>
</html>
