<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Товар</title>
</head>
<body style='background:url(http://i.piccy.info/i9/a0cd8340a4c2e5f8a59d25f90bb7887a/1544398933/376884/1287748/fone.jpg)'>
<h1 align='center'>${items.name}</h1><a href='/loginer/main'><input type='submit' value='Return to main'/></a>
<div align='center'><img src='${items.pic}'/><br/>
    <h2>${items.name}</h2>
    <h3>${items.description}</h3>
    Price: ${items.price}
    id: ${items.id}
</div>
</body>
</html>