<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表格</title>
</head>
<body>
<%--
lay-even	无	用于开启 隔行 背景，可与其它属性一起使用
lay-skin="属性值"	line （行边框风格）
        row （列边框风格）
        nob （无边框风格）	若使用默认风格不设置该属性即可
lay-size="属性值"	sm （小尺寸）
          lg （大尺寸）	若使用默认尺寸不设置该属性即可--%>
<table  lay-even class="layui-table" lay-even lay-skin="row" lay-size="lg">
    <%--表格宽度--%>
    <colgroup>
        <col width="100">
        <col width="100">
        <col width="250">
    </colgroup>
    <%-- 表头--%>
    <thead>
    <%-- 行--%>
    <tr>
        <%-- 列--%>
        <th>昵称</th>
        <th>加入时间</th>
        <th>签名</th>
    </tr>
    </thead>
    <tr>
        <td>贤心</td>
        <td>2016-11-29</td>
        <td>人生就像是一场修行</td>
    </tr>
    <tr>
        <td>许闲心</td>
        <td>2016-11-28</td>
        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
    </tr>

</table>

<table class="layui-table" lay-skin="line">
    行边框表格（内部结构参见右侧目录“常规用法”）
    <%--表格宽度--%>
    <colgroup>
        <col width="100">
        <col width="100">
        <col width="250">
    </colgroup>
    <%-- 表头--%>
    <thead>
    <%-- 行--%>
    <tr>
        <%-- 列--%>
        <th>昵称</th>
        <th>加入时间</th>
        <th>签名</th>
    </tr>
    </thead>
    <tr>
        <td>贤心</td>
        <td>2016-11-29</td>
        <td>人生就像是一场修行</td>
    </tr>
    <tr>
        <td>许闲心</td>
        <td>2016-11-28</td>
        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
    </tr>

</table>

<table class="layui-table" lay-skin="row">
    列边框表格（内部结构参见右侧目录“常规用法”）
    <%--表格宽度--%>
    <colgroup>
        <col width="100">
        <col width="100">
        <col width="250">
    </colgroup>
    <%-- 表头--%>
    <thead>
    <%-- 行--%>
    <tr>
        <%-- 列--%>
        <th>昵称</th>
        <th>加入时间</th>
        <th>签名</th>
    </tr>
    </thead>
    <tr>
        <td>贤心</td>
        <td>2016-11-29</td>
        <td>人生就像是一场修行</td>
    </tr>
    <tr>
        <td>许闲心</td>
        <td>2016-11-28</td>
        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
    </tr>

</table>

<table class="layui-table" lay-even lay-skin="nob">
    无边框表格（内部结构参见右侧目录“常规用法”）
    <%--表格宽度--%>
    <colgroup>
        <col width="100">
        <col width="100">
        <col width="250">
    </colgroup>
    <%-- 表头--%>
    <thead>
    <%-- 行--%>
    <tr>
        <%-- 列--%>
        <th>昵称</th>
        <th>加入时间</th>
        <th>签名</th>
    </tr>
    </thead>
    <tr>
        <td>贤心</td>
        <td>2016-11-29</td>
        <td>人生就像是一场修行</td>
    </tr>
    <tr>
        <td>许闲心</td>
        <td>2016-11-28</td>
        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
    </tr>

</table>
<table class="layui-table" lay-size="sm">
    小尺寸表格（内部结构参见右侧目录“常规用法”）
    <%--表格宽度--%>
    <colgroup>
        <col width="100">
        <col width="100">
        <col width="250">
    </colgroup>
    <%-- 表头--%>
    <thead>
    <%-- 行--%>
    <tr>
        <%-- 列--%>
        <th>昵称</th>
        <th>加入时间</th>
        <th>签名</th>
    </tr>
    </thead>
    <tr>
        <td>贤心</td>
        <td>2016-11-29</td>
        <td>人生就像是一场修行</td>
    </tr>
    <tr>
        <td>许闲心</td>
        <td>2016-11-28</td>
        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
    </tr>

</table>

<table class="layui-table" lay-size="lg">
    大尺寸表格（内部结构参见右侧目录“常规用法”）
    <%--表格宽度--%>
    <colgroup>
        <col width="100">
        <col width="100">
        <col width="250">
    </colgroup>
    <%-- 表头--%>
    <thead>
    <%-- 行--%>
    <tr>
        <%-- 列--%>
        <th>昵称</th>
        <th>加入时间</th>
        <th>签名</th>
    </tr>
    </thead>
    <tr>
        <td>贤心</td>
        <td>2016-11-29</td>
        <td>人生就像是一场修行</td>
    </tr>
    <tr>
        <td>许闲心</td>
        <td>2016-11-28</td>
        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
    </tr>

</table>

</body>
</html>
