<%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/16
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward标签</title>
</head>
<body>
//forward标签的作用是请求转发！forward标签的作用与RequestDispatcher#forward()方法相同。

<% request.setAttribute("key","valve");%>
<jsp:forward page="forward标签要跳转的页面.jsp"/>




</body>
</html>
