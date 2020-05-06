<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/14
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            $('#btn').click(function () {
                // alert("哈哈你好！");
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"hehe","password":"123","age":20}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data服务器端响应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <a href="user/testString">testString</a>
    <br/>

    <a href="user/testVoid">testVoid</a>
    <br/>

    <a href="user/testModelAndView">testModelAndView</a>
    <br/>

    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
    <br/>

    <input type="button" id="btn" value="发送ajax的请求">
</body>
</html>
