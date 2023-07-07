<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/21
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A23省市区联动菜单</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

    <script>
        loadaddres('shen');//当页面加载就调用loadajax()方法 请求shen的层级
        // 接受服务器返回的JSON数据
        function loadaddres(level) {
            //定义Pid(用于获取子id值)
            var pid;
            //判断传进来的level值是否是省
            if (level == 'shen') {
                pid = 4744;
            }
            //判断传进来的level值是否是市
            if (level == 'shi') {
                //level值是市的话就获取当前选中的id值作为区id的父id
                pid = ($(".shen").val());
                //删除html
                $(".shi").html("")
                $(".qu").html("")
                $(".zhen").html("")
            }
            //判断传进来的level值是否是区
            if (level == 'qu') {
                //level值是区的话就获取当前选中的id值作为镇id的父id
                pid = ($(".shi").val());
                $(".qu").html("")
                $(".zhen").html("")
            }
            if (level == 'zhen') {
                pid = ($(".qu").val());
                $(".zhen").html("")
            }


            //发送ajax请求
            $.ajax({
                //设置请求的地址  url 和参数
                url: "ServletText?pid=" + pid,
                //设置get请求
                type: "get",
                //pose请求要设置date
                // date :{
                //     name:"123",
                //     vale:"123"
                // },
                //可以接收的格式类型
                dataType: "json",
                //date 代表服务器返回的参数
                success: function (date) {
                    //浏览器控制台打印数据
                    console.log(date)

                    //定义一个html
                    var html = "";
                    //遍历服务器返回的JSON数据
                    for (let i = 0; i < date.length; i++) {
                        //拼接 html   （  value="' + date[i].id 作为Pid取值）
                        html += '"<option  value="' + date[i].id + '" level="' + date[i].level + '" >' + date[i].name + '</option>"'
                    }
                    //获取层级设置html
                    $("." + level).html(html)
                }
            })

        }


    </script>


</head>

<body>

<form>
<%--    onclick改变事件就调用这个方法--%>
    选择城省： <select class="shen" onclick="loadaddres('shi')">

</select>
    <%--    onclick改变事件就调用这个方法--%>
    选择市： <select class="shi" onclick="loadaddres('qu')">
</select>
    <%--    onclick改变事件就调用这个方法--%>
    选择区： <select class="qu" onclick="loadaddres('zhen')">
</select>
    选择镇： <select class="zhen">
</select>


</form>


</body>
</html>
