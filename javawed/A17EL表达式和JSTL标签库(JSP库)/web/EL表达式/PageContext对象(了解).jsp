
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageContext对象(了解</title>
</head>
<body>
${pageContext.request.queryString}<br>
${pageContext.request.requestURL}}<br>
${pageContext.request.contextPath}}<br>
${pageContext.request.method}}<br>
${pageContext.request.protocol}}<br>
${pageContext.request.remoteUser}}<br>
${pageContext.request.remoteAddr}}<br>
${pageContext.session.invalidate()}}<br>
${pageContext.session.id}}<br>
}

</body>
</html>
