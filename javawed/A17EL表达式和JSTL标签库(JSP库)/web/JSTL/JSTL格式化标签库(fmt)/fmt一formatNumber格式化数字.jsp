
<%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/19
  Time: 1:01
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
    <title>fmt:formatNumber格式化数字 </title>
</head>
<body>
<% double d=199.14;
pageContext.setAttribute("num1",d);
%>
<c:out value="${num1}"></c:out>
<p>格式化数字 (1): <fmt:formatNumber value="${num1}" type="currency"/><p>
<p>格式化数字 (2): <fmt:formatNumber type="number" maxIntegerDigits="3" value="${num1}" /></p>
<p>格式化数字 (3): <fmt:formatNumber type="number" maxFractionDigits="3" value="${num1}" /></p>
<p>格式化数字 (4): <fmt:formatNumber type="number" groupingUsed="false" value="${num1}" /></p>
<p>格式化数字 (5): <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${num1}" /></p>
<p>格式化数字 (6): <fmt:formatNumber type="percent" minFractionDigits="10" value="${num1}" /></p>
<p>格式化数字 (7): <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${num1}" /></p>
<p>格式化数字 (8): <fmt:formatNumber type="number" value="${num1}" pattern="0.00‰"/></p>
<p>格式化数字 (9): <fmt:formatNumber type="number" value="${num1}" pattern="0.00%"/></p>
<p>美元 :
    <fmt:setLocale value="en_US"/>
    <fmt:formatNumber value="${num1}" type="currency"/></p>
</body>

<hr>
<fmt:parseNumber var="i" type="number" value="${num1}" />
<p>数字解析 (1) : <c:out value="${i}" /></p>
<fmt:parseNumber var="i" integerOnly="true" type="number" value="${num1}" />
<p>数字解析 (2) : <c:out value="${i}" /></p>
</html>

</body>
</html>
