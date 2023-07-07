<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日期和时间组件</title>
</head>
<body>
<div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->

    <label>年-月-日</label>
    <input type="text" class="layui-input" id="date">
    <label>时-分-秒</label>
    <input type="text" class="layui-input" id="time">
    <label>年-月-日-时-分-秒</label>
    <input type="text" class="layui-input" id="datetime">
    <label>年</label>
    <input type="text" class="layui-input" id="year">
    <label>月</label>
    <input type="text" class="layui-input" id="month">


<%--开始时间和结束时间--%>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">日期范围</label>
            <div class="layui-inline" id="test-range">
                <div class="layui-input-inline">
                    <input type="text" id="startDate" class="layui-input" placeholder="开始日期">
                </div>
                <div class="layui-form-mid">-</div>
                <div class="layui-input-inline">
                    <input type="text" id="endDate" class="layui-input" placeholder="结束日期">
                </div>
            </div>
        </div>
    </div>

    <label>自定义日期格式</label>
    <input type="text"  id="customize"><br>
    <label >时间初始值填充</label>
    <label type="text"  id="valve"></label>




</div>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //年-月-日选择器
        laydate.render({
            elem: '#date' //id选择器
            ,type: 'date' //时间类型
        });
        //时-分-秒选择器
        laydate.render({
            elem: '#time' //id选择器
            ,type: 'time'//时间类型
        });

        //年-月-日-时-分-秒
        laydate.render({
            elem: '#datetime'//id选择器
            ,type: 'datetime'//时间类型
        });


        //年选择器
        laydate.render({
            elem: '#year'//id选择器
            ,type: 'year'//时间类型
        });

        //年月选择器
        laydate.render({
            elem: '#month'//id选择器
            ,type: 'month'//时间类型
        });


        //开始时间和结束时间
        laydate.render({
            elem: '#test-range' //开始时间和结束时间所在 input 框的父选择器
            //设置开始日期、日期日期的 input 选择器
            ,range: ['#startDate', '#endDate'] //数组格式为 layui 2.6.6 开始新增


        });

        //自定义日期格式
        laydate.render({
            elem: '#customize'
            ,format: 'yyyy年MM月dd日 HH时mm分ss秒' //可任意组合
            ,type: 'datetime'   //时间类型
           // ,range: true //range - 开启左右面板范围选择

        });

        //时间初始值填充
        laydate.render({
             elem: '#valve'
            ,format: 'yyyy年MM月dd日 HH时mm分ss秒' //可任意组合
            ,value: new Date(1534766888000) //参数即为：2018-08-20 20:08:08 的毫秒数
            ,type: 'datetime'   //时间类型
           // ,show: true //默认显示时间选择框
        });


        //自定义事件(弹出时间选择框)
        laydate.render({
            elem: '#customize'
            ,trigger: 'click' //采用click弹出 默认值：focus（获取焦点事件）
        });



    });


</script>





</body>
</html>
