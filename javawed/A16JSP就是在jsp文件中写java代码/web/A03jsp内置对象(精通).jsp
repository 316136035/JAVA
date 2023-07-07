<%--
  Created by IntelliJ IDEA.
  User: bing
  Date: 2020/10/19
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP内置对象(精通)</title>
</head>
<body>
<%--内置对象是在JSP页面中无需创建就可以直接使用的变量。在JSP中一共有9个这样的对象！它们分别是：--%>
<%--out（JspWriter）；
config（ServletConfig）；
page（当前JSP的真身类型）；
pageContext（PageContext）t范围； 当前页面之内有效；pageContext 对象是PageContext类型，它不只是域对象，而且还可以操作所有域对象，还可以获取其他隐藏对象。
exception（Throwable）
request（HttpServletRequest）范围；当前的请求内有效
response（HttpServletResponse）；
application（ServletContext）范围；当前这次服务器生命周期内有效；
Session     （HttpSession）。）范围；当前的会话内有效；
void setAttribute(String name, Object value)；
Object getAttrbiute(String name, Object value)；
void removeAttribute(String name, Object value)；--%>



<% out.print("这个一个jsp的输出流");
response.getWriter().println("out.print(\"*\")相当于HttpServletResponse");%> <br>

<%--request获取内容 ，当前请求有效--%>
<%=request.getAttribute("requestkey")%><br>

<%--session获取内容 会话内有效--%>
<%=session.getAttribute("sessionkey")%><br>

<%--application获取内容 application 就是ServletContext  服务器生命周期有效--%>
<%=application.getAttribute("ServletContextkey")%>

<%-- pageContext当前页面内有效 --%>
<%--pageContext 对象是PageContext类型，它不只是域对象，而且还可以操作所有域对象，还可以获取其他隐藏对象。--%>
<%--pageContext设置内容--%>
<%pageContext.setAttribute("PageContextkey","PageContextvalve");%>
<%--pageContext获取内容--%>
<%=pageContext.getAttribute("PageContextkey") %>
<br>

<%--pageContext.获取全部域的内容(pageContext.？？？？  代表是pageContext，request，session，application的作用范围)--%>
<%=pageContext.getAttribute("PageContextkey",pageContext.PAGE_SCOPE) %><br>
<%--request获取内容--%>
<%=pageContext.getAttribute("requestkey",pageContext.REQUEST_SCOPE)%><br>
<%--session获取内容--%>
<%=pageContext.getAttribute("sessionkey",pageContext.SESSION_SCOPE)%><br>
<%--application获取内容--%>
<%=pageContext.getAttribute("ServletContextkey",PageContext.APPLICATION_SCOPE)%><br>
<<br>>

<%--这个最简单的方法 用4个域对象中找--%>
<h1>这个最简单的方法 用4个域对象中找</h1>
<%--获取pageContext对象的值--%>
<%=pageContext.findAttribute("PageContextkey") %><br>
<%--request获取内容--%>
<%=pageContext.findAttribute("requestkey")%><br>
<%--session获取内容--%>
<%=pageContext.findAttribute("sessionkey")%><br>
<%--application获取内容--%>
<%=pageContext.findAttribute("ServletContextkey")%><br>









</body>
</html>
