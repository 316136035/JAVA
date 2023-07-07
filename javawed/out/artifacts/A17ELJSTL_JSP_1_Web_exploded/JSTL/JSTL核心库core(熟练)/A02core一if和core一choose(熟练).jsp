<%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/18
  Time: 1:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入第3方标签库（core核心库）--%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--这个是fmt格式化标签库--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>c:if和c:choose(熟练)</title>
</head>
<body>
<p>if标签的test属性必须是一个boolean类型的值，如果test的值为true，那么执行if标签的内容，否则不执行。</p> <br>
<core:set var="str" value="str" />
<%--判断str不为空就执行下面代码--%>
<%--用EL表达式获取域对象参数并判断（在用jstl判断）--%>
<core:if test="${not empty str}">
   <core:out value="${str}" ></core:out>
    <core:out value="if标签的test属性必须是一个boolean类型的值，如果test的值为true，那么执行if标签的内容，否则不执行" ></core:out>
</core:if>

<%--choose标签对应Java中的if/else if/else结构when标签的test为true时，会执行这个when的内容。
当所有when标签的test都为false时，才会执行otherwise标签的内容--%>
<%--多重if <c:choose> c:when </c:choose>   %>  --%>
<core:set var="shu" scope="application" value="90"></core:set>
<core:choose>
    <%--当上面一个我很为ture 就不会执行下面的代码--%>
    <core:when test="${shu>100||shu<0}">分数错误${shu}</core:when>
    <core:when test="${shu>=90}">A级${shu}</core:when>
    <core:when test="${shu>=80}">B级${shu}</core:when>
    <core:when test="${shu>=70}">C级${shu}</core:when>
    <core:when test="${shu>=60}">D级${shu}</core:when>
    <%--以上条件不符合就会执行下面代码--%>
    <core:otherwise>E级</core:otherwise>
</core:choose>







</body>
</html>
