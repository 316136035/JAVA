<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页</title>
</head>
<body>

<div id="test1"></div>
<script>
    layui.use('laypage', function(){
        var laypage = layui.laypage;

        //执行一个laypage实例
        laypage.render({
            elem: 'test1' //选择器 注意，这里的 test1 是 ID，不用加 # 号
            ,count: 50 //数据总数，从服务端得到
        });
    });
</script>

</body>
</html>
