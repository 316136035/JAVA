
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入第3方标签库--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--这个是格式化标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--这个是JSP写法:在域对象设置值&ndash;%&gt;--%>
<% request.setAttribute("key" ,"valve");%>

<%--<c:out value="aaa"/>value表示值 在页面输出内容,就是打印 这个是JSTL写法--%>
<core:out value="<c:out value=aa/>表示在页面输出内容,就是打印 这个是JSTL写法"/>

<%--JSTL写法:在域对象取值并打印--%><br>
<core:out  value="${key}"/>

<%--JSTL写法:在域对象取值,并打印--%>
<core:out value="${requestScope.key}"/><br>

<%--JSTL写法:在域对象取值,值是空的话就打印default后面的数据--%>
<core:out value="${requestScope.key1}" default="空"/><br>

<%--escapeXml表示是否忽略xml的标签，默认为ture，不建议设置false--%>
<core:out value="${requestScope.key1}" default="空"
<%--用JSTL在pageContext中添加值--%>
<core:set value="value" var="key"/>escapeXml="ture"/><br>


<%--用JSTL在pageContext中获取值--%>
<core:out value="${key}"/><br>

<%--scope可以指定设置存放的也对象(scope="request")(scope="application")(scope="session")(scope="page")--%>
<core:set value="valve2" var="key2" scope="application"/>
<core:out value="${key2}"/>







</body>
</html>
