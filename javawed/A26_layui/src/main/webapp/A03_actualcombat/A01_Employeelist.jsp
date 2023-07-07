<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js" type="text/javascript"
        charset="UTF-8"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
<div>
    <button id="addEmp" type="button" class="layui-btn layui-btn-fluid">添加员工</button>
</div>

<div class="layui-container">
    <table id="demo" lay-filter="delete"></table>


</div>


<script>
    //加载模块0
    layui.use(['table', 'jquery', 'layer'], function () {
        //获得table实例
        var table = layui.table;
        table.render({
            id: "#reload"     //用于刷新页面
            , elem: '#demo'  //获取元素(用于添加元素)
            , url: "${pageContext.request.contextPath}/ServerSelectEmp"
            , page: true //开启分页
            , limit: 20 //每页显示条数
            , limits: [20, 40, 60, 80] //选择每页显示条数
            //回调函数将其解析
            , parseData: function (res) {
                console.log("res=", res)//打印入参数据
                return {
                    "code": res.Code ==200 ? 0 : 500,  //设置状态码
                    "msg": "msg",//错误
                    "count": res.count,//数据库记录数
                    "data": res.emplist
                }
            },
            //请求参数的名字变更
            request: {
                pageName: "page"
                , limits: "limits"

            }

            , cols: [[ //表头
                {field: 'empid', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'empname', title: '用户名', width: 80}
                , {field: 'age', title: '年龄', width: 80, sort: true}
                , {
                    field: 'gender', title: '性别', width: 80,
                    /**自定义格式化显示*/
                    templet: function (e) {
                        // console.log(e); // 得到当前行数据
                        // console.log(this); // 得到表头当前列配置项
                        // console.log(e.LAY_INDEX); //得到序号。一般不常用
                        // console.log(e.LAY_COL); //得到表头当前列配置项，同 this
                        return e.gender == 0 ? "男" : "女";
                    }
                }
                , {
                    field: 'hireDate', title: '时间', width: 177,
                    /**自定义格式化显示*/
                    templet: function (e) {
                        // console.log(e); // 得到当前行数据
                        // console.log(this); // 得到表头当前列配置项
                        // console.log(e.LAY_INDEX); //得到序号。一般不常用
                        // console.log(e.LAY_COL); //得到表头当前列配置项，同 this
                        return layui.util.toDateString(e.hireDate, 'yyyy-MM-dd')//格式化时间
                    }
                }
                , {
                    field: 'rolename', title: '部门', width: 177,
                    /**自定义格式化显示*/
                    templet: function (e) {
                        // console.log(e); // 得到当前行数据
                        // console.log(this); // 得到表头当前列配置项
                        // console.log(e.LAY_INDEX); //得到序号。一般不常用
                        // console.log(e.LAY_COL); //得到表头当前列配置项，同 this
                        return  e.emprole.rolename
                    }
                }



                , {
                    title: '操作'
                    , width: 160
                    , align: "center"   //align:"center" 居中
                    /**自定义格式化显示*/
                    , templet: function () {
                        var html = "<button  type=\"button\" class=\"layui-btn layui-btn-sm layui-btn-danger \"  lay-event=\"delete\">删除</button>"
                        html += "<button type=\"button\" 	class=\"layui-btn layui-btn-sm layui-btn-warm\" lay-event=\"update\">修改</button>"
                        return html


                    }


                }


            ]]
        });

        //获取jquery实例
        var $ = layui.jquery;//jquery组件
        var layer = layui.layer;//弹层组件
        //通过ID选择器绑定一个点击事件
        $("#addEmp").click(function () {
            /**弹层组件**/
            layer.open({
                type: 2  //弹层组件的基本层类型
                , title: "添加员工" //title - 标题
                , area: ['500px', '450px']  //area - 宽高
                , shade: [0.3, '#ff3333']   //shade - 遮罩
                , content: "${pageContext.request.contextPath}/A03_actualcombat/A02_AddEmp.jsp" //加载jsp页面
                , success: function (layero, index) {
                    console.log(layero, index);
                }  //弹出弹层页面执行的方法
                , end: function () {
                   // layer.msg("弹出弹层页面关闭了")
                    //通过自定义id 刷新table.render()方法
                    table.reload('#reload')
                }
            });
        });
        //  table绑定事件lay-filter="delete"并在 按钮button要添加 lay-event=\"delete\ 事件"
        table.on('tool(delete)', function (obj) {
            //当前行的实例
            var emp = obj.data;
            console.log("当前行:", emp)//当前行
            var event = obj.event; //获取按钮中的lay-event=\"名字\"
            console.log(obj.event);//当前行
            /**判断是否为删除按钮*/
            if (event == "delete") {
                /**询问框*/
                layer.confirm(emp.empname, {icon: 3, title: '是否删除'}, function (index) {
                    $.getJSON(
                      "${pageContext.request.contextPath}/Servlet_Add_Delete_Update_Emp?Servlet_Add_Delete_Update_Emp=Delete"
                        , {'empid': obj.data.empid} //请求参数
                        , function (d) {
                            console.log("d=", d)
                            if (d.Code != 200) {layer.msg("错误............")}
                            if (d.Code == 200) {
                                obj.del() //删除当前行的元素（不用刷新整个页面）
                                //通过自定义id 刷新table.render()方法
                               // table.reload('#reload')
                            }
                        });
                    layer.close(index);

                });

            }

            /**判断是否为修改按钮*/
            if (event == "update") {
                layer.open(
                    {
                        type: 2  //弹层组件的基本层类型
                        , title: "修改页面" //title - 标题
                        , area: ['500px', '450px']  //area - 宽高
                        , shade: [0.3, '#ff3333']   //shade - 遮罩
                        //加载jsp页面
                        , content: "${pageContext.request.contextPath}/A03_actualcombat/A03_UpDateEmp.jsp?depid=" + emp.depid
                        //弹出弹层页面执行的方法
                        ,
                        success: function (layero, index) {

                            //获取jsp页面的html
                            var body = layer.getChildFrame('body', index);

                            console.log("layero=",layero)
                            console.log("index=",index)

                            body.find("input[name=id]").val(emp.empid);
                            body.find("input[name=name]").val(emp.empname);
                            body.find("input[name=age]").val(emp.age);
                            //回显单选框
                            body.find("input[type=radio][value=0]").attr('checked', emp.gender==0?true:false)
                            body.find("input[type=radio][value=1]").attr('checked', emp.gender==1?true:false)
                            body.find("input[name=date]").val(layui.util.toDateString(emp.hireDate, 'yyyy-MM-dd'));

                            //回显下拉选择框在A03_UpDateEmp.jsp页面
                        }
                        //弹出弹层页面销毁执行的方法
                        , end: function () {
                           // layer.msg("弹出弹层页面关闭了")
                            //通过自定义id 刷新table.render()方法
                            table.reload('#reload')


                        }
                    }
                )


            }

        })


    });

</script>

</body>


</html>
