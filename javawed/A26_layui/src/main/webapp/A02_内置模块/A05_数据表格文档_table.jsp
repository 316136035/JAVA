<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <title>数据表格文档 </title>
</head>
<body>


<div>
    <div>
        <table id="table" lay-filter="test"></table>

    </div>


    <div id="test1"></div>

</div>


<script>
    /**加载table模块*/
    layui.use('table', function () {
        /**获取table模块实例*/
        var table = layui.table;
        table.render({
            //id选择器
            elem: '#table'
            //请求的服务器地址
            , url: ${pageContext.request.contextPath}"/JdlistServer"
            //开启分页
            , page: true
            //每页显示条数
            , limit: 2
            //选择每页显示条数
            ,limits:[2,4,6,8]
           , request:{
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit

            }
            //回调函数将其解析
            , parseData: function (res) {

                console.log("res=", res)//打印入参数据
                return {
                    "code": 0,  //设置状态码
                    "msg": "msg",//错误
                    "count": 7,//数据库记录数
                    "data": res
                }
            }
            //打印数据库的对象
            , cols: [[ //表头
                //field:对象参数名，title名称， width:宽度，sort:是否排序， fixed: 定位
                {field: 'id', title: 'ID', width: 140, sort: true, fixed: 'left'}
                , {field: 'name', title: '商品名称', width: 800, sort: true}
                , {field: 'money', title: '金额', width: 120,}
                , {field: 'enterprisemoney', title: '企业金额', width: 120}
                , {
                    field: 'gender', title: '是否自营', width: 120
                    , templet: function (d) {
                        console.log("d", d); // 得到当前行数据
                        console.log(this); // 得到表头当前列配置项
                        console.log(d.LAY_INDEX); //得到序号。一般不常用
                        console.log(d.LAY_COL); //得到表头当前列配置项，同 this
                        return d.gender == 0 ? "男" : "女"


                    }
                }

            ]]


        })


    })


</script>


</body>
</html>
