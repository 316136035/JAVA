<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--导入core核心库--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" ></script>
<script src=${pageContext.request.contextPath}/static/lib/jquery-3.6.1.min.js></script>

<html>
<head>
    <title>A01_add—_cookie添加</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/A01_add_cookie添加_读取" method="post">


    <table>
        <tr>
            <td> 用户名
                <input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码
                <input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"></td>
        </tr>


    </table>


</form>

</body>
</html>
