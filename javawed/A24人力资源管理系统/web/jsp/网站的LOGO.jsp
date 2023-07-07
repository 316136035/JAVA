<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Admin Header</title>


</head>

<body>
<div id="all">
    <div id="welcome">欢迎来到淘神价系统</div>
    <div id="Exist">
        <ul>
            <li>欢迎您：${user.permission}</li>

            <%--<img src="/images/clock.gif" />--%>
            <%--       target="_parent"  指向父类         --%>
            <li><a href="/UserExistServlet" target="_parent">用户退出</a></li>
        </ul>


    </div>

</div>

</body>
</html>
