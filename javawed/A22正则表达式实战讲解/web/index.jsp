<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/21
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A22正则表达式实战讲解</title>

    <script src="./jquery/jquery-1.8.3.min.js"></script>
    <script>
        <!--这是一个主方法-->
        $(function () {
            //这个当输入框获得焦点时
            var blur= $("#username").focus(function () {
                $("span").html("请输入电话号码")
            });

            //这个当输入框失去焦点时
            var blur= $("#username").blur(function () {
                var val=  $("#username").val();
                //创建正则表达式
                var  reg= new RegExp("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");
                var regexp=reg.test(val);
                var re= regexp?"可用!":"不符合条件";
                $("span").html(re)
            })



        })


    </script>
</head>
<body>
<form>
    账号： <input type="text" id="username"><span></span><br>
    密码： <input type="text" name=""><br>
    <input type="button" value="提交">


</form>


</body>
</html>
