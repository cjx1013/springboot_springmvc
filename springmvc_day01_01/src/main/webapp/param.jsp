<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/11
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--   <a href="param/paramTest?username=haha&password=123">请求参数绑定</a>--%>

<%--    请求对象以及内含引用对象绑定--%>
<%-- <form action="param/saveAccount" method="post">
     姓名：<input type="text" name="username"><br/>
     密码：<input type="text" name="password"><br/>
     金额：<input type="text" name="money"><br/>
     用户名：<input type="text" name="user.uname"><br/>
     年龄：<input type="text" name="user.age"><br/>
     <input type="submit" value="提交">
 </form>--%>

<%--    请求集合参数绑定--%>
<%-- <form action="param/saveAccount" method="post">
     姓名：<input type="text" name="username"><br/>
     密码：<input type="text" name="password"><br/>
     金额：<input type="text" name="money"><br/>
     用户名：<input type="text" name="list[0].uname"><br/>
     年龄：<input type="text" name="list[0].age"><br/>
     用户名：<input type="text" name="map['one'].uname"><br/>
     年龄：<input type="text" name="map['one'].age"><br/>
     <input type="submit" value="提交">
 </form>--%>

<%--    请求自定义类型转换绑定--%>
<%-- <form action="param/saveUser" method="post">
     用户名：<input type="text" name="uname"><br/>
     年龄：<input type="text" name="age"><br/>
     生日：<input type="text" name="date"><br/>
     <input type="submit" value="提交">
 </form>--%>
<%--        获取servlet原生API--%>
        <a href="param/testServlet">获取servlet原生API</a>
</body>
</html>
