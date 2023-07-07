<%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/21
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线人员实时统计</title>
</head>
<body>

<p>欢迎使用在线人员实时统计</p>
<p>在线人数:

   <p> JSP获取:<%= application.getAttribute("renshu")%></p>


<p>ET表达式获取:${applicationScope.get("renshu")}</p>


<p>请求次数:
  <p>   JSP获取: <%=application.getAttribute("cishu")%></p>
  <p> ET表达式获取:${applicationScope.get("cishu")}</p>
<a href="在线人员实时统计(销毁回话).jsp">销毁回话 </a>
</body>
</html>
