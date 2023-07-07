<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/6
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>AJXA</title>

   <script type="text/javascript" src="lib/jquery-1.8.3.min.js"></script>
    <script>
      <!--这是一个主方法-->
      $(function () {
        //这个当输入框获得焦点时
        var blur= $("#username").focus(function () {
          $("span").html("请输入电话号码")

        });
          //这个当输入框失去焦点时
        var blur= $("#username").blur(function () {
          var usernameval=  $("#username").val();

          //发送ajax请求
          $.ajax({
              //设置请求的地址  url 和参数
              url : "AJAXServlet?username="+ usernameval,
              //设置get请求
              type : "get",
              //pose请求要设置date
              // date :{
              //     name:"123",
              //     vale:"123"
              // },
              //设置超时时间（单位毫秒）
              //timeout:1,
              //预期服务器返回数据类型
              // dataType:json,html,text,
              // success代表回调  date代表服务器返回的参数
              success: function (date){
                  $("span").html(date)
              }})


        })
      })

    </script>


  </head>
  <body>

    <form>
     账号： <input type="text" name="username" id="username"><span></span><br>
     密码： <input type="password" name="password"><br>
      <input type="submit" name="提交"><br>

    </form>







  </body>
</html>
