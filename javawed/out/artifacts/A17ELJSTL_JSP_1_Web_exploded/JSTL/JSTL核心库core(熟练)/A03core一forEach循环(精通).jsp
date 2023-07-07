<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/18
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入第3方标签库--%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--这个是格式化标签库--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>c一forEach循环(精通)</title>
</head>
<body>

<%--基本遍历:--%>
<%--下面例子中设置域变量i，初始值为1，结束值为10。即i的值从1遍历到10，包含10。--%>
<core:forEach begin="1" end="10" var="i">
    <%--打印变量值--%>
    <core:out value="${i}"></core:out>
</core:forEach>
</br>
<p>遍历数组:</p>
<%
//request作用域存放字符串数组
  String[] str={"a","b","c","d","e","f"};
//request作用域存放字符串数组
  request.setAttribute("strs",str);
%>

<core:forEach items="${strs}" var="str">
    <core:out value="${str}"/><br>
</core:forEach>

<p>遍历集合list</p>
<%List List=new ArrayList<>();
    List.add("id");
    List.add("name");
    List.add("money");
    //request作用域存放集合list<
    request.setAttribute("List",List);
%>
<core:forEach items="${List}" var="list">
    <core:out value="${list}"/><br>
</core:forEach>
<p>遍历集合MAP:</p>
<%HashMap<String,String> HashMap = new HashMap<>();
    HashMap.put("1","A");
    HashMap.put("2","B");
    HashMap.put("3","C");
    HashMap.put("4","D");
    HashMap.put("5","E");
    HashMap.put("6","F");
    // application作用域存放集合MAP
    application.setAttribute("maps",HashMap);
%>
<core:forEach items="${maps}" var="Map">
    <core:out value="${Map.key}"/>:<c:out value="${Map.value}"/><br>
</core:forEach>


</body>
</html>
