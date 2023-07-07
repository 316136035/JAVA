<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/18
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A05_Spring_MVC_Annotation</title>
</head>
<body>
<a href="/shen/Controller1">Controller1</a>
<a href="/shen/Controller2">Controller2</a>
<a href="/RestFul/insert?id=1,name='周先生'">insertGet</a>
<a href="/RestFul/delete">deleteDelete</a>
<a href="/RestFul/uplete">upletePost</a>
<a href="/RestFul/select/1/'周'">selectGet</a>
<a href="/ForwardRedirect/forward">请求重定向</a>
<a href="/ForwardRedirect/redirect">请求重定向</a>
<a href="/for/ward1?username=接受请求参数回显">接受请求参数回显</a>
<a href="/for/ward2?id=1&name=回显对象&age=18">接受请求参数回显对象</a>
<a href="/for/ward3?username=modelMap">modelMap</a>
<a href="/for/ward4">回显Json对象</a>


</body>
</html>
