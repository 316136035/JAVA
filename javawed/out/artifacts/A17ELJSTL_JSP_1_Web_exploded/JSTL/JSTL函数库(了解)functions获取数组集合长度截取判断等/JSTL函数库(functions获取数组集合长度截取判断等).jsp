<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--Created by IntelliJ IDEA.--%>
  <%--User: bing--%>
  <%--Date: 2021/3/19--%>
  <%--Time: 1:28--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入第3方标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--这个是格式化标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<html>
<head>
    <title>JSTL函数库(了解)</title>
</head>
<body>
<%
    String[] strs = {"a", "b","c"};
    List list = new ArrayList();
    list.add("a");
    list.add("b");
    pageContext.setAttribute("arr", strs);
    pageContext.setAttribute("list", list);

%>
<p>获取String的长度</p>
<c:out value="${functions:length(arr)}"></c:out>
${functions:length(arr)}<br/><!--3-->
<p>获取集合的长度</p>
${functions:length(list)}<br/><!--1-->
<p>转大写</p>
${functions:toLowerCase("Hello") }<br/> <!-- hello -->
<p>转小写</p>
${functions:toUpperCase("Hello") }<br/> <!-- HELLO -->
<p>判断String 是否包含指定字符</p>
${functions:contains("abc", "a")}<br/><!-- true -->
<p>判断String 是否包含指定字符串 不管大小写</p>
${functions:containsIgnoreCase("abc", "Ab")}<br/><!-- true -->
<p>转成数组是否包含指定字符</p>
${functions:contains(arr, "a")}<br/><!-- true -->
<p>集合了吗是否包含指定字符 不管大小写</p>
${functions:containsIgnoreCase(list, "A")}<br/><!-- true -->
<p>是否已指定字符串结尾</p>
${functions:endsWith("Hello.java", ".java")}<br/><!-- true -->
<p>是否已指定字符串开头</p>
${functions:startsWith("Hello.java", "Hell")}<br/><!-- true -->
<p>查看指定字符串的索引位置</p>
${functions:indexOf("Hello-World", "-")}<br/><!-- 5 -->
<p>用指定字符分隔</p>
${functions:join(arr, ";")}<br/><!-- a;b;c -->
<p>替换指定字符</p>
${functions:replace("Hello-World", "-", "+")}<br/><!-- Hello+World -->
<p>替换指定字符</p>
${functions:join(functions:split("a;b;c;", ";"), "-")}<br/><!-- a-b-c -->
<p>截取字符串</p>
${functions:substring("0123456789", 6, 9)}<br/><!-- 678 -->
<p>截取字符串</p>
${functions:substring("0123456789", 5, -1)}<br/><!-- 56789 -->
<p>截取字符串指定字符的位置后面的全部</p>
${functions:substringAfter("Hello-World", "-")}<br/><!-- World -->
<p>截取字符串指定字符的位置前面的全部</p>
${functions:substringBefore("Hello-World", "-")}<br/><!-- Hello -->
<p>去前后的空格</p>
${functions:trim("     a b c     ")}<br/><!-- a b c -->
<p>忽略Html标签</p>
${functions:escapeXml("<html></html>")}<br/> <!-- <html></html> -->

</body>
</html>
