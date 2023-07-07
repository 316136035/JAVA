<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--（core核心库）--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--这个是格式化标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JS操作JSON对象(熟悉).jsp</title>

    <script type="text/javascript" src="jquery/jquery-1.8.3.min.js"  charset="utf-8"></script>

    <script>

        $(function () {
            //script创建集合
            var array = new Array();
            array[0] = "A";
            array[1] = "B";
            array[2] = "C";
            array[3] = "D";
            //script创建对象
            var  jd ={
                sku: 1,
                name:"手机",
                money:16.89,
                date: array
            }
            console.log(jd);

        });



    </script>


</head>
<body>



</body>
</html>
