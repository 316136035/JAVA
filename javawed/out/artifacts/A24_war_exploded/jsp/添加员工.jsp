
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>

    <script type="text/javascript" src="/jslibe/jquery.min.js"></script>
    <script>
        $(function (){
            loadDistrict();

        })

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
                        var selected = data[i].id==${emp.districtid == null ? "''" : emp.districtid}?"selected":"";
                        dh += "<option value='"+data[i].id+"'"+selected+">"+data[i].name+"</option>";
                    }
                    $("#district").html(dh);
                }
            });

        }


    </script>

</head>
<body>
<form action="/AddEmpServlet" method="post">

    <table>
        <tr>
            <td>当前页面:员工管理&gt;添加员工</td>
        </tr>

        <tr>
            <td>员工名称<input type="text" name="ename"></td>
            <td>员工年龄<input type="number" name="age"></td>
        </tr>

        <tr>
            <td>信息性别<input type="radio" name="sex" value="1" checked/>男
                <input type="radio" name="sex" value="0"/>女
            </td>
            <td>员工工资<INPUT type="number" name="sal" ></td>
        </tr>

        <tr>

            <td> 员工生日<input  type="date" name="birthday" ></td>
        </tr>

        <tr>

            <td>入职日期 <input  name="edate" type="date"></td>
        </tr>
        <tr>

            <td>员工籍贯 <select  name="districtId" id="district" >
            </select></td>
        </tr>

        <tr><td><input type="submit" value="保存"> </td></tr>


    </table>


</form>


</body>
</html>
