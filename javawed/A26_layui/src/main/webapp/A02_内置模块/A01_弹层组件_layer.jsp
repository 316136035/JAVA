<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>弹层组件</title>
</head>
<body>


<button id="btn" type="button" class="layui-btn">询问框按钮</button>
<span id="span1"></span>

<script>

    layui.use(['layer'],function () {
        //获取弹层组件()
        var layer=layui.layer;
        //弹出提示框
        layer.msg("提示信息..");


       // 获取询问框按钮元素
       var btn =document.getElementById("btn");
        //绑定事件
        btn.onclick=function () {
            //弹出询问框
            layer.confirm("是否删除",function (ndex) {
                document.getElementById("span1").append("删除成功")
                layer.close(ndex)
            })
        };
        //



    });



</script>



</body>
</html>
