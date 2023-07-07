
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>修改员工</title>

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
                        var selected = data[i].id==${emp.districtId == null ? "''" : emp.districtId}?"selected":"";

                        dh += "<option value='"+data[i].id+"'"+selected+">"+data[i].name+"</option>";
                    }
                    $("#district").html(dh);
                }
            });

        }

    </script>

</head>
<body>
<form action="/UpdateEmpServlet" method="post">

    <table>
        <tr>
            <td>当前页面:员工管理&gt;修改员工</td>
        </tr>

        <tr> <td> <input type="hidden" value="${emp.id}" name="id" } ></td></tr>

        <tr>
            <td>员工名称<input type="text" name="ename" value="${emp.ename}"></td>
            <td>员工年龄<input type="number" name="age" value="${emp.age}" ></td>
        </tr>

        <tr>

            <td>信息性别
                <input type="radio" name="sex" value="男" <core:if test="${emp.sex == 1}">checked</core:if>/>男
                <input type="radio" name="sex" value="女" <core:if test="${emp.sex == 0}">checked</core:if>/>女
            </td>

        <tr>
            <td>员工工资<INPUT type="number" name="sal" value="${emp.sal}"></td>
        </tr>

        <tr>

            <td> 员工生日<input  type="date" name="birthday" value="${emp.birthday}"></td>
        </tr>

        <tr>

            <td>入职日期 <input  name="edate" type="date" value="${emp.edate}"></td>
        </tr>
        <tr>

            <td>员工籍贯 <select  name="districtId" id="district"  >
            </select></td>
        </tr>

        <tr><td><input type="submit" value="修改"> </td></tr>


    </table>


</form>


</body>
</html>
