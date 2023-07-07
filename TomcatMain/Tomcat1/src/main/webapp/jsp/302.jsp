<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/1/4
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>请求重定向页面</h1>


    <div> 使用response对象的sendRedirect()方法能够将网页重定向到还有一个页面。</div>
        <div>  重定向支持将地址重定向到不同的主机上，这一点与转发不同.</div>
            <div> 在浏览器上将会得到跳转后的地址， 并又一次发送请求链接；</div>
                <div> 用户能够从浏览器的地址栏中看到跳转后的地址；</div>
                    <div>  重定向操作后，request中的属性将会所有失效，并開始一个新的request对象</div>


</body>
</html>
