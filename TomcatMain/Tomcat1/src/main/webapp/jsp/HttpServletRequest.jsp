<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入core核心库--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript"></script>


<html>
<head>
    <title>A01_HttpServletRequest请求对象</title>
</head>
<body>

<div>A01_HttpServletRequest请求对象</div>
<table>

    <form action="${pageContext.request.contextPath}/A01_HttpServletRequest请求对象" method="post">
        <tr>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td><input type="password" name="password"></td>
        </tr>


        <tr>
            <td><input type="checkbox" name="che" value="宝马">宝马</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="che" value="奥迪">奥迪</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="che" value="本田">本田</td>
        </tr>

        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>


    </form>

    <form action="${pageContext.request.contextPath}/A01_HttpServletRequest请求对象">
        <tr>
            <td><input type="checkbox" name="che" value="宝马">宝马</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="che" value="奥迪">奥迪</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="che" value="本田">本田</td>
        </tr>
        <td><input type="submit" value="提交"></td>

<%--    </form>--%>
<%--从HttpServletRequest作用域取值"/>--%>
    <core:out value="${requestScope.get('key1')}"/>
    <core:out value="${requestScope.get('key2')}"/>
    <core:out value="${requestScope.get('key3')}"/>

</table>


</body>
</html>
