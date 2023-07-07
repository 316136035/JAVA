<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/28
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<!-- <html lang="zh-CN"> 向搜索引擎表示该页面是html语言，并且语言为中文网站，其"lang"的意思就是“language”，语言的意思，而“zh”即表示中文 -->
<head>
    <meta charset="utf-8">
    <!--声明文档兼容模式，表示使用IE浏览器的最新模式，告诉IE浏览器，无论是否用DTD声明文档标准，IE8/9都会以IE8引擎来渲染页面。-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登陆</title>
    <!-- 引入jQuery核心js文件 -->
    <script src="/jslibe/jquery.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="/jslibe/bootstrap.min.js"></script>



    <style type="text/css">
        body{
            background: url("/img/background.jpg") no-repeat center center fixed;
            /*兼容浏览器版本*/
            -webkit-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        } /*背景图*/

        .test {
            margin-top: 100px;
        }
    </style>
</head>
<body>

<div class="row" >
    <div class="col-md-4"></div>
    <div class="col-md-4"   style="background-color: #aaaaaa; opacity:0.8;margin-top: 250px;" >

        <h1 class="text-center"   style="padding-top:50px;  " >用户登录</h1>
        <form class="form-horizontal " role="form"  action="/userLoginServlet" method="post"  >
            <div class="form-group  ">
                <label for="username" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="username" id="username"      placeholder="请输入账号">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox">记住密码
                        </label>
                        <label class="col-sm-offset-1"  >
                            <input type="checkbox">自动登录
                        </label>
                        <a  class="col-sm-offset-1" href="https://www.**.com/">忘记密码</a>
                    </div>

                    <td>${errorMsg}</td>
                </div>

            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">登录</button>
                    <%--用于显示账号/密码错误的--%>
                    <font id="errorMsg" style="padding-top:50px;  " >${ errorMsg }</font>
                    <a type="submit" class="btn btn-default col-sm-offset-4 " href="register.jsp" >注册</a>

                </div>

            </div>
        </form>
    </div>
    <div class="col-md-4"></div>

</div>
</body>
</html>