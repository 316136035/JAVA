<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/hread.css " type="text/css" rel="stylesheet">
<script src="../static/lib/jquery-3.6.1.min.js"></script>
<html>
<head>
    <title>页面头信息</title>
</head>
<body>
<div>taoshenjia.vip</div>
<div>
    <div class="Exist"> 欢迎您：${user_session.userCode}</div>
    <div class="Exist"> 欢迎您：${user_session.userName}</div>
    <div class="Exist" ><a  ${requestScope} href=${pageContext.request.contextPath}"/A02_ExistServlet" target="_parent">用户退出</a>
    <div >

    </div>
</div>


</div>
</body>
</html>
