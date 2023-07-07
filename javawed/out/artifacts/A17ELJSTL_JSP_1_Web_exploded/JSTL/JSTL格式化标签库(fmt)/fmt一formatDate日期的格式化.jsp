<%@ page import="java.util.Date" %>
Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/19
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入第3方标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--这个是格式化标签库--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>导入标签库需要使用taglib指令</title>
</head>
<body>
<%Date date = new Date();pageContext.setAttribute("date1",date);%>
<p>没有格式化的时候</p>
<c:out value="${date1}"></c:out><br>
<p>格式化后的</p>
<fmt:formatDate value="${date1}" pattern="yyyy-mm-dd hh:mm:ss" ></fmt:formatDate><br>
<p>日期格式化 (1): <fmt:formatDate type="time" value="${date1}" /></p>
<p>日期格式化 (2): <fmt:formatDate type="date" value="${date1}" /></p>
<p>日期格式化 (3): <fmt:formatDate type="both" value="${date1}" /></p>
<p>日期格式化 (4): <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${date1}" /></p>
<p>日期格式化 (5): <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${date1}" /></p>
<p>日期格式化 (6): <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${date1}" /></p>
<p>日期格式化 (7): <fmt:formatDate pattern="yyyy-MM-dd" value="${date1}" /></p>
<hr>
<p>格式化数字 (1): <fmt:formatNumber value="${num1}" type="currency"/></p>


</body>
</html>
