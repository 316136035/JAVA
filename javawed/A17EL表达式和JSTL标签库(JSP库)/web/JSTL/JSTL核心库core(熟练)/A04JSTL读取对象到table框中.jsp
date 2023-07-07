<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="JSTL就JSP的标签库.Txuser" %>
<%@ page import="java.util.concurrent.TimeUnit" %><%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2021/3/18
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入第3方标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--这个是格式化标签库--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
·

<html>
<head>
    <title>JSTL读取对象</title>
    <style type="text/css">
        #id {


        }


    </style>


</head>
<body>
<%
    List<Object> List = new ArrayList<>();
    Txuser T1 = new Txuser("先生", 10, 1);
    Txuser T2 = new Txuser("玩先生", 11, 1);
    Txuser T3 = new Txuser("周玩儿", 22, 2);
    Txuser T4 = new Txuser("玩生", 15, 1);
    Txuser T5 = new Txuser("周生", 32, 2);
    Txuser T6 = new Txuser("尔特", 14, 1);
    Txuser T7 = new Txuser("玩儿", 22, 2);
    Txuser T8 = new Txuser("予以", 22, 2);
    Txuser T9 = new Txuser("如图", 20, 1);
    Txuser T10 = new Txuser("人头", 15, 1);
    List.add(T1);
    List.add(T2);
    List.add(T3);
    List.add(T4);
    List.add(T5);
    List.add(T6);
    List.add(T7);
    pageContext.setAttribute("List", List);
%>
<p>varStatus:
    forEach标签还有一个属性：varStatus，这个属性用来指定接收“循环状态”的变量名
    ，例如：
    <forEach varStatus=”vs” …/>
    ， 这时就可以使用vs这个变量来获取 循环的状态了。
    step 代表循环一次跳过几个元素
    current当前这次迭代的（集合中的）项
    index当前这次迭代从 0 开始的迭代索引
    count当前这次迭代从 1 开始的迭代计数
    first用来表明当前这轮迭代是否为第一次迭代的标志
    last用来表明当前这轮迭代是否为最后一次迭代的标志
</p>


<table border="1" cellpadding="2" cellspacing="1">
    <tr>
        <td>序号</td>
        <td id="id">名字</td>
        <td id="name">年龄</td>
        <td id="xingbei">性别</td>
        <td>current</td>
        <td>begin</td>
        <td>end</td>
        <td>last</td>
        <td>first</td>
        <td>index</td>

    </tr>

    <c:forEach items="${List}" var="T" varStatus="vs">
        <tr>
                <%--vs.count用于序号排序--%>
            <td><c:out value="${vs.count}"></c:out></td>
            <td><c:out value="${T.name}"></c:out></td>
            <td><c:out value="${T.age}"></c:out></td>
            <td><c:out value="${T.xingbie}"></c:out></td>
                        <%--vs.count当前的toString方法--%>
            <td><c:out value="${vs.current}"></c:out></td>
            <td><c:out value="${vs.begin}"></c:out></td>
            <td><c:out value="${vs.end}"></c:out></td>
            <td><c:out value="${vs.last}"></c:out></td>
            <td><c:out value="${vs.first}}"></c:out></td>
            <td><c:out value="${vs.index}}"></c:out></td>
        </tr>


    </c:forEach>


</table>


</body>
</html>
