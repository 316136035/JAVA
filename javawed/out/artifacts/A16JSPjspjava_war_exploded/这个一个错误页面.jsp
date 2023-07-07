
<%-- 给错误页面一个标识  errorPage="这个一个错误页面.jsp"--%>  <%--isELIgnored="true" 这个是打印错误页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="这个一个错误页面.jsp" isErrorPage="true" %>



<html>
<head>
    <title>这个一个错误页面</title>
</head>
<body>
<h1>这个一个错误页面</h1>
<%--这个方法是打印错误信息--%>
<%=exception.getMessage() %>
</body>
</html>
