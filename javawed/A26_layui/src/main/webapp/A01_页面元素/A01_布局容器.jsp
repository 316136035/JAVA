<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A01_布局容器</title>
</head>

<%--  固定宽度并居中的容器--%>
<div class="layui-container" style="height:100px;background-color: red; ">
    <%-- 定义行layui-row  定义列间距  --%>
    <div class="layui-row layui-col-space20">
        <%-- 定义列   预设了 12 种不同尺寸的边距--%>
        <div class="layui-col-md2" style="height:100px;background-color: green;">
            1/2
        </div>
        <div class="layui-col-md3" style="height:100px;background-color: gold;">
            1/3
        </div>
        <%-- 定义列  预设了 12 种不同尺寸的边距 向右偏移 4 个列宽度--%>
        <div class="layui-col-md3 layui-col-md-offset4" style="height:100px;background-color: magenta;">
            1/4
        </div>
    </div>


</div>
<%--   宽度不固定100%适应的容器--%>
<div class="layui-fluid" style="height:100px;background-color: pink;"></div>

<%--栅格嵌套：--%>
<%--定义行layui-row 列间距layui-col-space5 样式style=""--%>
<div class="layui-row layui-col-space5 " style="background-color: green;">
    <%-- 定义列   预设了 12 种不同尺寸的边距--%>
    <div class="layui-col-md5" style="background-color:greenyellow;">
        <%--定义行layui-row 列间距layui-col-space5 样式style=""--%>
        <div class="layui-row grid-demo">
            <%-- 当超过12自动换行--%>
            <div class="layui-col-md3">
                内部列3
            </div>
            <div class="layui-col-md9">
                内部列9
            </div>
            <div class="layui-col-md12">
                内部列12
            </div>
        </div>
    </div>
    <%-- 定义列   预设了 12 种不同尺寸的边距--%>
    <div class="layui-col-md7" style="background-color:darkmagenta;">
        <%--定义行layui-row 列间距layui-col-space5 样式style=""--%>
        <div class="layui-row grid-demo grid-demo-bg1">
            <%-- 当超过12自动换行--%>
            <div class="layui-col-md12">
                内部列12
            </div>
            <div class="layui-col-md9">
                内部列9
            </div>
            <div class="layui-col-md3">
                内部列3
            </div>
        </div>
    </div>
</div>

</body>
</html>
