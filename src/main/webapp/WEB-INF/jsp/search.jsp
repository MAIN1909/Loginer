<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body style='background:url(http://i.piccy.info/i9/a0cd8340a4c2e5f8a59d25f90bb7887a/1544398933/376884/1287748/fone.jpg)'>
<div>
    <form action='/loginer/search'>
        <input type='text' name='name'/>
        <input type='submit' value='Search'/>
    </form>
</div>
<div>
    <form action='/loginer/add'>
        <input type='submit' value='Create item'/>
    </form>
</div>
<div>
    <form action='/loginer/main'>
        <input type='submit' value='Return to main page'/>
    </form>
</div>
<h1 align='center'>Продам Обои</h1>
<c:forEach items="${items}" var="i">
    <div align='center'>
        <a href='/loginer/search?name=${i.getName().toString()}'>
            <img src='${i.pic}'/>
        </a><br/>
        <p>
        <h2>${i.name}</h2></p>
        <h3>${i.description}</h3>
        Price: ${i.price}
        id: ${i.id}
    </div>
</c:forEach>
</body>
</html>