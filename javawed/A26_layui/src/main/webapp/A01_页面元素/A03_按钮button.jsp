<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A03_按钮button</title>
</head>
<body>
<h1>按钮 - 页面元素</h1>

<button type="button" class="layui-btn">一个标准的按钮</button><br>
<a href="*" class="layui-btn">一个可跳转的按钮</a><br>

<button type="button" class="layui-btn layui-btn-primary">重置按钮</button><br>
<button type="button" class="layui-btn">默认</button><br>
<button type="button" class="layui-btn layui-btn-normal">百搭按钮</button><br>
<button type="button" class="layui-btn layui-btn-warm">暖色按钮</button><br>
<button type="button" class="layui-btn layui-btn-danger">警告按钮</button><br>
<button type="button" class="layui-btn layui-btn-disabled">禁用按钮</button><br>
<button type="button" class="layui-btn layui-btn-primary layui-border-green">主色按钮</button><br>
<button type="button" class="layui-btn layui-btn-primary layui-border-blue">百搭按钮</button><br>
<button type="button" class="layui-btn layui-btn-primary layui-border-orange">暖色按钮</button><br>
<button type="button" class="layui-btn layui-btn-primary layui-border-red">警告按钮</button><br>
<button type="button" class="layui-btn layui-btn-primary layui-border-black">深色按钮</button><br>


<button type="button" class="layui-btn layui-btn-lg">大型按钮</button><br>
<button type="button" class="layui-btn">默认按钮</button><br>
<button type="button" class="layui-btn layui-btn-sm">小型按钮</button><br>
<button type="button" class="layui-btn layui-btn-xs">迷你按钮</button><br>
<button type="button" class="layui-btn layui-btn-lg layui-btn-normal">大型百搭按钮</button><br>
<button type="button" class="layui-btn layui-btn-warm">正常暖色按钮</button><br>
<button type="button" class="layui-btn layui-btn-sm layui-btn-danger">小型警告按钮</button><br>
<button type="button" class="layui-btn layui-btn-xs layui-btn-disabled">迷你禁用按钮</button><br>

<button type="button" class="layui-btn layui-btn-fluid">流体按钮（最大化适应）</button>

<h1>圆角按钮角</h1>
<button type="button" class="layui-btn layui-btn-radius layui-btn-primary">重置圆角按钮</button><br>
<button type="button" class="layui-btn layui-btn-radius">默认圆角</button><br>
<button type="button" class="layui-btn layui-btn-radius layui-btn-normal">百搭圆角按钮</button><br>
<button type="button" class="layui-btn layui-btn-radius layui-btn-warm">暖色圆角按钮</button><br>
<button type="button" class="layui-btn layui-btn-radius layui-btn-danger">警告圆角按钮</button><br>
<button type="button" class="layui-btn layui-btn-radius layui-btn-disabled">禁用圆角按钮</button><br>

<button type="button" class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal">大型百搭圆角按钮</button><br>
<button type="button" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger">小型警告圆角按钮</button><br>
<button type="button" class="layui-btn layui-btn-xs layui-btn-radius layui-btn-disabled">迷你禁用圆角按钮</button><br>

<h1>图标按钮</h1>
<button type="button" class="layui-btn">
    <i class="layui-icon layui-icon-down layui-font-12"></i>
</button>

<%--温馨提示：各种图标字体请移步文档左侧【页面元素 - 图标】阅览--%>
<button type="button" class="layui-btn layui-btn-sm layui-btn-primary">
         <i class="layui-icon layui-icon-left"></i>
</button>


<h1>按钮容器</h1>
<div class="layui-btn-container">
    <button type="button" class="layui-btn">按钮一</button>
    <button type="button" class="layui-btn">按钮二</button>
    <button type="button" class="layui-btn">按钮三</button>
</div>




</body>
</html>
