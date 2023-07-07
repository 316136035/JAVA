<%--导入core核心库--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--导入js代码--%>
<script src="js/login.js"></script>
<!--href代表引入文本-type代表类型 - rel代表样式--->
<link href="css/land.css " type="text/css" rel="stylesheet">
<script type="text/javascript"></script>
<script src=${pageContext.request.contextPath}/static/lib/jquery-3.6.1.min.js></script>


<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<div class="row">
    <div class="col-md-4" style="background-color: #aaaaaa; opacity:0.8;margin-top: 250px;">
        <h1 class="text-center">用户登录</h1>
        <div class="text-center1">Welcome来到taoshenjia.vip</div>
        <form class="form-horizontal" role="form" method="post"
              action="${pageContext.request.contextPath}/A01_user的登陆Servlet" onsubmit=" return form()">
            <div>信息：${error}</div>
            <div class="form-group">
                <label class="col-sm-2">账号</label>
                <input type="text" class="form-control" id="userCode" name="userCode" placeholder="请输入账号">
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2">密码</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox">记住密码
                        </label>
                        <label class="col-sm-offset-1">
                            <input type="radio" id="checkbox" name="che">自动登录
                        </label>
                        <a class="col-sm-offset-1" href="">忘记密码</a>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" value="提交">
                    <a type="submit" class="btn btn-default col-sm-offset-4 " href="register.jsp">注册</a>
                </div>

            </div>
        </form>
    </div>
    <div class="col-md-4"></div>

</div>


</body>

</html>
