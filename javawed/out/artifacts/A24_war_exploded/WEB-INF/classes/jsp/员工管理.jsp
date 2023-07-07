<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <TITLE>员工列表</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="/jslibe/jquery.min.js"></script>
    <script type="text/javascript" src="/layer/layer.js"></script>
    <link href="/css/员工管理.css" type="text/css" rel="stylesheet">

    <script>

            loadDistrict();

            function loadDistrict() {
            $.ajax({
                //设置请求的地址  url 和参数
                url: "/DistrictServle?pid=" + 4744,
                //设置get请求
                type: "get",
                //pose请求要设置date
                // date :{
                //     name:"123",
                //     vale:"123"
                // },
                //可以接收的格式类型
                dataType: "json",
                //date 代表服务器返回的参数
                success : function(data) {
                    var dh = "<option value=''>---请选择---</option>";
                    for(var i=0;i<data.length;i++){

                        var selected = data[i].id==${district == null ? "''" : district}?"selected":"";

                        dh += "<option value='"+data[i].id+"'"+selected+">"+data[i].name+"</option>";



                    }
                    $("#district").html(dh);
                }
            });

        }

            // 点击上一页或者下一页时，执行的方法，给隐藏域赋值，然后提交表单
            function to_page(num) {

                // 如果传入了数字
                if (num > 0) {
                    // 给隐藏域赋值
                    $("#page").val(num);
                    // 提交form表单
                    document.form.submit();
                } else {
                    num = 1;
                }


            }

            function addemp() {
                //跳转到添加员工.jsp
                location.href = "/jsp/添加员工.jsp";


            }

            function updateemp() {
                //调用checkboxsize()获取选中的checkbox的索引
                var number= checkboxSize()
                if ( number==1){

                    var empid= $("input[id='checkbox']:checked").val()
                    location.href="/SelectEmpServlet?id="+empid;

                }else {
                    alert( "请选择一个")
                }



            }

            // 获取选中的checkbox的索引
            function checkboxSize() {
                return $("input[type='checkbox']:checked").size()


            }





            // 删除
            function delemp(){
                // 调用获取选中长度的方法
                var len = checkboxSize();
                // 判断

                if(len == 1){
                    if (confirm("确定删除???")){
                        var id = $("input[id='checkbox']:checked").val();
                        location.href = "/DelEmpServlet?id="+id;

                    } else {
                       alert("取消")
                    }







                }else{
                    // 提示
                    layer.msg('请选择一个',{
                        offset:'100px'
                    });
                }
            }





    </script>


</HEAD>
<BODY>

<form name="form" method="post" action="/EmpListServlet">
    <table>

        <tr>

            <td>当前位置：员工管理 > 员工列表</td>



        </tr>

    </table>

    <table>
        <tr>
            <td><input type="text" name="name" value="${name}"></td>

            <td><select id="district" name="district">
                <option></option>

            </select>
            </td>

            <td><input type="submit" value="查询"></td>
            <td><input type="button" value="添加" onclick="addemp()"></td>
            <td><input type="button" value="修改" onclick="updateemp()"></td>
            <td><input type="submit" value="删除" onclick="delemp()"></td>

        </tr>
    </table>
    <table id="table表单">
        <tr>
            <td>操作</td>
            <td>序号</td>
            <td>员工名称</td>
            <td>员工年龄</td>
            <td>员工性别</td>
            <td>员工工资</td>
            <td>员工生日</td>
            <td>入职日期</td>
            <td>员工籍贯</td>
        </tr>



        <core:forEach items="${page.getBeanList()}" var="emp" varStatus="vs">
            <tr id="tr">
                <td><input type="checkbox" id="checkbox" value="${emp.id }"/></td>
                <td>${vs.count}</td>
                <td>${emp.ename}</td>
                <td>${emp.age}</td>
                <td>${emp.sex == 0?"女":"男" }</td>
                <td>${emp.sal}</td>
                <td>${emp.birthday}</td>
                <td>${emp.edate}</td>
                <td>${emp.getDistrict().name}</td>
                    <%--                <td>${emp.id}</td> --%>

                <td>   ${emp.districtId}</td>
            </tr>


        </core:forEach>


    </table>

    <table id="href">

        <tr target="_parent">

            <td><A href="javascript:to_page(${page.pageCode-1})">前一页</A></td>
            <td>第${ page.getPageCode()}页</td>
            <td><A href="javascript:to_page(${page.pageCode+1})">后一页</A></td>
            <td>共${ page.totaConunt}页</td>

            <input type="hidden" size="3" id="page" name="pageCode"/>
            <input type="hidden" value="5" id="pageSize" name="pageSize"/>
            </div>
            </sqan>
        </tr>


    </table>


</form>


</BODY>


<script type="text/javascript">
    // 监控查询按钮的表单提交
    $("form").submit(function (e) {

        // 每次表单提交时  修改当前页为1
        $("#page").val(1);

    });


</script>

</HTML>