<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/13
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!--常用的注解-->
    <a href="anno/testRequestParam?name=张三">RequestParam注解</a>

    <br/>

    <form action="anno/testRequestBody" method="post">
        用户名：<input type="text" name="username"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交">
    </form>
    <br/>

    <a href="anno/testPathVariable/10">PathVariable注解</a>
    <br/>

    <a href="anno/testRequestHeader">RequestHeader注解</a>
    <br/>

    <a href="anno/testCookieValue">CookieValue注解</a>
    <br/>

    <form action="anno/testModelAttribute" method="post">
        用户名：<input type="text" name="uname"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交">
    </form>
    <br/>

    <a href="anno/testSessionAttributes">testSessionAttributes</a>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <a href="anno/deleteSessionAttributes">deleteSessionAttributes</a>
    <br/>
</body>
</html>
