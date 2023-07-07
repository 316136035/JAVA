<%--这个代表是一个jxp的文件--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>A01index.jsp</title>
  </head>
  <body>
<%--这种注解会打印的前台--%>
    <%--这种是java代码不会打印的前台--%>
  <% String str="我是jsp!!!"; %>
    <%--这种是使用jsp使用java代码打印的前台--%>
  <%=str %>
<%--jsp路径可以通过服务器运行后的Using CATALINA_BASE:路径中查看
    当第一次请求jsp文件时，会把jsp文件编译成java文件在编译成.class文件，
    当第二次请求jsp文件时，就会直接运行class文件
--%>

 <%! String str1="我是jsp!!!"; %>  <%--声明对应“真身”中的属性和方法类方法！--%>
<%-- ：Tomcat在生成“真身”时，就会忽略它，因为Tomcat认识它，知道它是注释。所以在“真身”中就没有它，也不会发现到客户端。也就是说，客户端永远看不到它！
--%>

  </body>
</html>
