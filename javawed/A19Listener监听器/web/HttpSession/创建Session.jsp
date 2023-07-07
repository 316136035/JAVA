<%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/20
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建Session</title>
</head>
<body>
<p>在线人数:
    <%pageContext.getSession().setAttribute("key1","valve1");%>
</p>

<a href="销毁Session.jsp">销毁Session</a>

</body>
</html>
