<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单</title>
</head>
<body>

form表单(依赖加载模块：form（请注意：如果不加载form模块，select、checkbox、radio等将无法显示，并且无法使用form相关功能）)
<form class="layui-form" action="www.jd.com" method="post">
    <%--表单项，块级元素，一个表单项标签内可放多个输入框  行区块结构--%>
    <div class="layui-form-item">
        <%-- 表单标签--%>
        <label class="layui-form-label">输入框</label>
        <%--长输入框--%>
        <div class="layui-input-block">
            <%--输入框
required：注册浏览器所规定的必填字段
lay-verify：注册form模块需要验证的类型
class="layui-input"：layui.css提供的通用CSS类"--%>
            <input type="text" name="title" required lay-verify="required" placeholder="请输入标题" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <%--表单项，块级元素，一个表单项标签内可放多个输入框--%>
    <div class="layui-form-item">
        <%-- 表单标签--%>
        <label class="layui-form-label">密码框</label>
        <%-- 短输入框--%>
        <div class="layui-input-inline">
            <%--输入框 选框必填lay-verify="required"--%>
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off"
                   class="layui-input">
        </div>
        <%--灰色标注性文字layui-form-mid ，左右会有间隔layui-word-aux--%>
        <div class="layui-form-mid layui-word-aux">辅助文字</div>
    </div>
    <%--表单项，块级元素，一个表单项标签内可放多个输入框--%>
    <div class="layui-form-item">
        <%-- 表单标签--%>
        <label class="layui-form-label">选择框</label>
        <%--  表单元素占一行，竖着，以例表的形式排列。--%>
        <div class="layui-input-block">
            <%--下拉选择框   选框必填lay-verify="required"
            selected 默认选中
            disabled 禁用效果
            --%>
            <select name="city" required lay-verify="required">
                <option value=""></option>
                <option value="0">北京</option>
                <option value="1">上海</option>
                <option value="2">广州</option>
                <option value="3" selected>深圳</option>
                <option value="4"  disabled>杭州</option>
            </select>
                <select name="quiz">
                    <option value="">请选择</option>
                    <optgroup label="城市记忆">
                        <option value="你工作的第一个城市">你工作的第一个城市？</option>
                    </optgroup>
                    <optgroup label="学生时代">
                        <option value="你的工号">你的工号？</option>
                        <option value="你最喜欢的老师">你最喜欢的老师？</option>
                    </optgroup>
                </select>
        </div>
    </div>
    <%--表单项，块级元素，一个表单项标签内可放多个输入框--%>
    <div class="layui-form-item">
        <%-- 表单标签--%>
        <label class="layui-form-label">复选框</label>
        <%--表单元素占一行，竖着，以例表的形式排列。--%>
        <div class="layui-input-block">
            <%--复选框
属性title可自定义文本（温馨提示：如果只想显示复选框，可以不用设置title）
属性checked可设定默认选中
属性lay-skin可设置复选框的风格
设置value="1"可自定义值，否则选中时返回的就是默认的on--%>
            <input type="checkbox" name="like[write]" title="写作">
            <input type="checkbox" name="like[read]" title="阅读" checked>
            <input type="checkbox" name="like[dai]" title="发呆">
        </div>
    </div>
    <%--表单项，块级元素，一个表单项标签内可放多个输入框--%>
    <div class="layui-form-item">
        <%-- 表单标签--%>
        <label class="layui-form-label">开关</label>
        <%--表单元素占一行，竖着，以例表的形式排列。--%>
        <div class="layui-input-block">
            <%--单选框
属性checked可设定默认开
属性disabled开启禁用
属性lay-text可自定义开关两种状态的文本
设置value="1"可自定义值，否则选中时返回的就是默认的on--%>

            <input type="checkbox" name="switch" lay-skin="switch">
        </div>
    </div>
    <%--表单项，块级元素，一个表单项标签内可放多个输入框--%>
    <div class="layui-form-item">
        <%-- 表单标签--%>
        <label class="layui-form-label">单选框</label>
        <%--表单元素占一行，竖着，以例表的形式排列。--%>
        <div class="layui-input-block">
            <%--单选框
属性title可自定义文本
属性disabled开启禁用
设置value="xxx"可自定义值，否则选中时返回的就是默认的on--%>
                <input type="radio" name="sex" value="nan" title="男">
                <input type="radio" name="sex" value="nv" title="女" checked>
                <input type="radio" name="sex" value="" title="中性" disabled>
        </div>
    </div>
    <%--表单项，块级元素，一个表单项标签内可放多个输入框layui-form-item
        文本域layui-form-text--%>
    <div class="layui-form-item layui-form-text">
        <%-- 表单标签--%>
        <label class="layui-form-label">文本域</label>
        <%-- 表单元素占一行，竖着，以例表的形式排列--%>
        <div class="layui-input-block">
            <%--文本区域--%>
            <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <%--表单项，块级元素，一个表单项标签内可放多个输入框--%>
    <div class="layui-form-item">
        <%-- 表单元素占一行，竖着，以例表的形式排列--%>
        <div class="layui-input-block">
            <%--按钮layui-btn lay-submit绑定触发提交的元素,可以不写参数,即为提交
             当对layui-form进行提交监听时.form.on('submit(lay-filiter的名字)', 回调函数callback());--%>
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <%--按钮layui-btn lay-submit  重置按钮 --%>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    //引入form表单模块
    layui.use(['form'], function () {
        var form = layui.form;

        //引入submit模块提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>


</body>
</html>
