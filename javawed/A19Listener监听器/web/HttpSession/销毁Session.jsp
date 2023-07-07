
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销毁Session</title>
</head>
<body>
<% pageContext.getSession().invalidate();%>

</body>
</html>
