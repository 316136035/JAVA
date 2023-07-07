<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="EL表达式操作对象.EL表达式对象" %>

<%--Created by IntelliJ IDEA.--%>
<%--User: bing--%>
<%--Date: 2021/3/16--%>
<%--Time: 22:47--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" %>
<html>
<head>
    <title>EL表达式操作对象</title>
    <% String str = "我是中国人!!";
        HashMap<Object, Object> Map = new HashMap<>();
        Map.put("key1", "valve1");
        Map.put("key2", "valve2");
        Map.put("key3", "valve3");
        ArrayList<Object> List = new ArrayList<>();
        List.add("100");
        List.add("200");
        List.add("300");
        EL表达式对象 user = new EL表达式对象();
        user.setName("周先生");
        user.setAge(19);
        pageContext.setAttribute("str", str);
        pageContext.setAttribute("Hash", Map);
        pageContext.setAttribute("List", List);
        pageContext.setAttribute("user", user);
    %>
    <%=Map.get("key1")%>

    <%--通过EL表达式获取pageContext域对象中的数据--%>
    <%--获取字符串--%>
    <p>${str}</p>
    <p>获取HashMap</p>
    <p>${Hash.get("key1")}</p>
    <p>${Hash.get("key2")}</p>
    <p>${Hash.get("key3")}</p>
    <p>获取集合</p>
    <p>${List.toString()}</p>
    <p>${List[0]}</p>
    <p>${List[1]}</p>
    <p>${List[3]}</p>
    <p>${List.size()}</p>
    <p>获取对象</p>
    <p>${user.name}</p>
    <p>${user.age}</p>
    <p>${user.toString()}</p>


</head>
<body>


</body>
</html>
