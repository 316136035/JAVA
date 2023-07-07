<%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/17
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>域隐藏对象(精通)</title>
</head>
<body>
<%
    pageContext.setAttribute("pageContextkey"," pageContextvalve");

%>


<%--//获取域对象参数中查找，如果找到就返回，找不到就返回空字符串。--%>
<%--获取request域对象参数--%>
${requestScope.get("request")}<br>
<%--获取sessio域对象参数--%>
${sessionScope.get("Session")}<br>
<%--获取ServletContext域对象参数--%>
${applicationScope.get("ServletContext")}<br>
<hr>
<%--获取request域对象参数--%>
${request}<br>
<%--获取sessio域对象参数--%>
${Session}<br>
<%--获取ServletContext域对象参数--%>
${ServletContext}<br>
<%--&lt;%&ndash;获取session  id &ndash;%&gt;  其他方法去看PageContext对象(了解).jsp--%>
${pageContext.session.id}

<hr>
<%--pageContext--pageScope当前页面有效--%>
${pageScope.get("pageContextkey")}






</body>
</html>
