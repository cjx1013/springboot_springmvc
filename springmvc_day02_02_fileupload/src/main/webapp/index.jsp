<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/15
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>传统文件上传</h3>
    <form action="user/fileUpload1" method="post" enctype="multipart/form-data">
        上传文件：<input type="file" name="upload">
        <input type="submit" value="上传">
    </form>
    <br/>
    <h3>springmvc文件上传</h3>
    <form action="user/fileUpload2" method="post" enctype="multipart/form-data">
        上传文件：<input type="file" name="upload">
        <input type="submit" value="上传">
    </form>
    <br/>
    <h3>springmvc跨服务器文件上传</h3>
    <form action="user/fileUpload3" method="post" enctype="multipart/form-data">
        上传文件：<input type="file" name="upload">
        <input type="submit" value="上传">
    </form>
</body>
</html>
