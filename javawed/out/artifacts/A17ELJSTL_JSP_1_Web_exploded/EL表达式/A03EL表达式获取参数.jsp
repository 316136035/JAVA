<%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/17
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式内置对象</title>
    <%
        Cookie cookie1 = new Cookie("cookie1", "valve1");
        Cookie cookie2 = new Cookie("cookie2", "valve2");
        Cookie cookie3 = new Cookie("cookie3", "valve3");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
    %>
</head>
<body>
<%--获取从连接中传过来的参数--%>
${param.username}
${param.get("username")}<br/>
<%--获取从连接中传过来的多个参数--%>
${paramValues.keySet()}<br/>
${paramValues.size()}<br/>
<%--获取请求头信息。--%>
${header.get("Host")}<br/>
${headerValues.keySet()}<br/>
<%--web.xml文件中的<context-param>初始化参数。--%>
${initParam.size()}<br/>
${initParam.get("key1")}<br/>
<br/>
<%--获取cookie。--%>
${cookie.get("cookie1").name}<br/>
${cookie.get("cookie2").value}<br/>


</body>
</html>
