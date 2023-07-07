<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/28
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎来到淘神价报价系统</title>
</head>

<frameset rows="100,*">
    <!--上部分-->
    <frame name="上面" src="/jsp/网站的LOGO.jsp">
    <!--下部分-->
    <frameset cols="240,*">
        <frame name="左下"src="/jsp/菜单.jsp" >
        <frame  name="右下" src="/jsp/员工管理.jsp">
    </frameset>
</frameset>

<p>欢迎来到淘神价报价系统</p>
</html>
