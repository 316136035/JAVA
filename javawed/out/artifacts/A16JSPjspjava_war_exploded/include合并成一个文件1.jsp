<%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/16
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include合并成一个文件1</title>

</head>
<body>
<%--在上面代码中，include合并成一个文件1中定义username变量
所以include合并成一个文件2不能处理请求，只有include合并成一个文件1才能处理请求！
当访问include合并成一个文件1时，一个文件1会包含一个文件2
所以两个会合并成一个文件后再编译成Java文件。
在合并之后，，所以include合并成一个文件1中也就不会出现错误了。--%>
<% String str="我是中国人";%>
<%@ include file="include合并成一个文件2.jsp"%>

</body>
</html>
