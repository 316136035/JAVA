<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/31
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A02jsp三种语法</title>
    <p>jsp页面内填写java代码</p>
    <%String str= "jsp页面内填写java代码";
        System.out.println("打印的控制台:"+str);

        %>

    <p>这种写法的属性会在servlet真身中填写</p>
    <%!String str= "真身";%><br>

    <p>打印到html页面</p>
    <%="打印到html页面:"+str%>

    <%--jsq的注释写法 --%>







</head>
<body>



</body>
</html>
