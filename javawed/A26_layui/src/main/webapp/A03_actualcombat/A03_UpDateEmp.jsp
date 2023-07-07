<%--  引入layui--%>
<link href="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/css/layui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/lib/layui-v2.7.6/layui/layui.js" type="text/javascript"
        charset="UTF-8"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工页面</title>
</head>
<body>
<div>
    <form class="layui-form" action="">

        <div><input type="hidden" name="Servlet_Add_Delete_Update_Emp" value="Update"></div>


        <div class="layui-form-item">
            <label class="layui-form-label">ID</label>
            <div class="layui-input-block">
                <input type="text" name="id" required lay-verify=”int” readonly="readonly" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">名字</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入名字"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="age" required lay-verify="required" placeholder="请输入数字"
                       autocomplete="off" class="layui-input">
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">单选框</label>
                <div class="layui-input-block" id="radio">
                    <input type="radio" name="sex" value="0" title="男">
                    <input type="radio" name="sex" value="1" title="女">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">年-月-日</label>
                <div class="layui-input-block">
                    <input type="text" name="date" class="layui-input" lay-verify=”date” placeholder="年-月-日" id="date">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">选择框</label>
                <div class="layui-input-block">
                    <select name="deptid" lay-verify="required" id="select">


                    </select>
                </div>
            </div>


            <div class="layui-form-item">
                <div class="layui-input-block">
                    <%--                  设置 lay-submit lay-filter="UpdateEmp"为下面 form.on('submit(UpdateEmp)',使用  --%>
                    <button class="layui-btn" lay-submit lay-filter="Update">修改</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>

        </div>


    </form>


    <script>
        /**加载form表单，时间选择器，jquery模块,layer弹层组件**/
        layui.use(['form', 'laydate', 'jquery', 'layer'], function () {
                /**加载form表单实例*/
                var form = layui.form;
                /**加载layer弹层组件实例*/
                var layer = layui.layer;
                /**提交submit事件*/
                form.on('submit(Update)', function (data) {
                    // layer.msg(JSON.stringify(data.field));//当前容器的全部表单字段，名值对形式：{name: value}
                    $.post(
                        "${pageContext.request.contextPath}/Servlet_Add_Delete_Update_Emp" //请求地址
                        , data.field  //请求参数
                        , function (d) {
                            console.log("D=", d) //当前容器的全部表单字段，名值对形式：{name: value}  返回参数
                            if (d.Code != 200) {
                                layer.msg("添加时出错了.....");
                            }
                            if (d.Code == 200) {
                                //关闭弹层组件
                                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                                parent.layer.close(index); //再执行关闭
                            }
                        }, "json"
                    )

                    //获取form默认提交地址
                    return false;
                });
                /**加载时间选择器实例*/
                var laydate = layui.laydate;
                laydate.render({
                    elem: '#date'
                    , trigger: 'click'
                    , type: 'date' //默认，可不填
                });

                /**加载jquery实例*/
                var $ = layui.jquery;
                //发送ajax请求
                $.getJSON("${pageContext.request.contextPath}/ServerSelectEmp", function (d) {
                    console.log("d=", d)
                    if (d.Code != 200) {
                        layer.msg(d.msg + "错误")
                    }
                    if (d.Code == 200) {
                        /**获取A01_Employeelist.jsp页面传参*/
                        var p = window.location.search
                        var p = p.substring(p.lastIndexOf("=") + 1, p.length)
                        console.log(p)
                        var html = "<option value='请选择'></option>";
                        var emprolelist = d.emprolelist;
                        /**遍历json数据*/
                        for (var i = 0; i < emprolelist.length; i++) {
                            /**判断是否选中*/
                            if (p == emprolelist[i].deptid) {
                                html += "<option selected value=" + emprolelist[i].deptid + ">" + emprolelist[i].rolename + "</option>"

                            } else {
                                html += "<option  value=" + emprolelist[i].deptid + ">" + emprolelist[i].rolename + "</option>"

                            }


                        }
                        $("#select").html(html)
                        //刷新(选择框页面)
                      //form.render($("#select"));
                      form.render();


                    }

                })

            }
        );


    </script>
</div>

</body>
</html>
