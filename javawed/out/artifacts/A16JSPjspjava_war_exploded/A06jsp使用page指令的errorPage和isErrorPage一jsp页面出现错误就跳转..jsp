<%--当程序出现错误就跳转到errorPage="这个一个错误页面.jsp"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="这个一个错误页面.jsp" %>
<html>
<head>
    <title>page指令的errorPage和isErrorPage</title>
</head>
<body>
<% int i=10;
    int ii=0;
    ii = i / ii;


%>

</body>
</html>
