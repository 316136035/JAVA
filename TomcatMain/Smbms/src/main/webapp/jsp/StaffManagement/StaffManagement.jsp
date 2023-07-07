<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/StaffManagement.css " type="text/css" rel="stylesheet">
<script type="text/javascript"></script>
<script src=${pageContext.request.contextPath}/static/lib/jquery-3.6.1.min.js></script>
<script src="${pageContext.request.contextPath}/js/StaffManagement.js" charset=”utf-8″></script>

<html>
<head>
    <TITLE>用户管理</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</HEAD>
<BODY>



<form name="form" method="post" action=${pageContext.request.contextPath}"/A01_UserServlet">
    <%--    包含领一个JSP页面--%>
    <jsp:include page="StaffManagementHread.jsp"></jsp:include>


        <td><input type="submit" value="查询" ></td>
        <td><input type="button" value="添加" onclick="adduser()"></td>
        <td><input type="button" value="修改" onclick="updateemp()"></td>
        <td><input type="button" value="删除" onclick="daluser()"></td>



    <table id="table表单">
        <tr class="tr">
            <td>操作</td>
            <td class="userCod">userCode</td>
            <td>userName</td>
            <td>userPassword</td>
            <td>gender</td>
            <td>birthday</td>
            <td>address</td>
            <td>userRole</td>
            <td>createdBy</td>
            <td>creationDate</td>
            <td>modifyBy</td>
            <td>modifyDate</td>
            <td>age</td>
            <td>userRoleName</td>
        </tr>


        <core:forEach items="${userlist}" var="user" varStatus="vs">

        </tr class="tr">
        <td><input  class="input"  type="checkbox"  checked="checked" id="${user.id}">....</td>
        <td> ${user.userCode}</td>
        <td> ${user.userName}</td>
        <td> ${user.userPassword}</td>
        <td> ${user.gender == 0?"女":"男" }</td>
        <td> ${user.birthday}</td>
        <td> ${user.phone}</td>
        <td> ${user.address}</td>
        <td> ${user.userRole}</td>
        <td> ${user.createdBy}</td>
        <td> ${user.creationDate}</td>
        <td> ${user.modifyBy}</td>
        <td> ${user.modifyDate}</td>
        <td> ${user.age}</td>
        <td> ${user.userRoleName}</td>


        <tr>

            </core:forEach>


    </table>
    <%--    包含领一个JSP页面--%>
    <jsp:include page="StaffManagementFooter.jsp"></jsp:include>


</form>


</BODY>


</HTML>