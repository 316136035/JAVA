<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript"></script>
<script src=${pageContext.request.contextPath}/static/lib/jquery-3.6.1.min.js c></script>
<script src="../js/UserUpdate.js" charset=”utf-8″></script>




<html>
<head>
    <title>密码修改页面</title>
</head>
<body>

<form action=${pageContext.request.contextPath}/A03_UserUpdateServlet method="post"  id="UserUpdateform">

<%--    <div>#{message}</div>--%>
<%--    隐藏域--%>
    <div ><input type="hidden" name="method" value="savepwd"> </div>
    <div> 旧密码： <input type="text" id="oldpassword" name="password"><span></span></div>
    <div> 新密码：<input type="password" id="newpassword" name="password1"><span></span></div>
    <div> 确认密码： <input type="password" id="rnewpassword" name="password1"><span></span></div>
    <div> <input type="submit"   value="保存" ></div>


</form>


</body>
</html>
