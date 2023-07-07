<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--导入core核心库--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" ></script>
<script src=${pageContext.request.contextPath}/static/lib/jquery-3.6.1.min.js></script>

<script>
    $(function () {
        $('div').click(function () {
            // 获取父类元素
            var html = $(this).parent()
            //发送ajax请求
            $.ajax({
                //设置请求的地址  url 和参数
                url: '${pageContext.request.contextPath}' + '/' + $(this).attr("value"),
                //设置get请求
                type: "get",
                //pose请求要设置date
                // date :{
                //     name:"123",
                //     vale:"123"
                // },
                //设置超时时间（单位毫秒）
                //timeout:1,
                //预期服务器返回数据类型
               // dataType: 'text',
                // success代表回调  date代表服务器返回的参数
                success: function (date) {
                    if (date != null) {
                        //在父类元素后面追加元素
                        html.after("<span>" +date + "<span>" + "<hr>")




}
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }
            })
        })

    })

    function gettext(Objetc) {
        //获取父元素
        var v = $(Objetc).parent().attr('')


    }


    //格式化时间
    function show() {
        var date = new Date();
        this.year = date.getFullYear();
        this.month = date.getMonth() + 1;
        this.date = date.getDate();
        this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
        this.milliSeconds = date.getMilliseconds();
        var currentTime = this.year + '-' + this.month + '-' + this.date + ' ' + this.hour + ':' + this.minute + ':' + this.second + '.' + this.milliSeconds;

        document.getElementById("time").innerHTML = currentTime;
    }

    //js定时器  不停的
 window.setInterval("show()", 1)

    function clear_session() {
      ${sessionScope.clear()}
    }





</script>

<html>
<head>
    <core:out value="${date}" default="空" escapeXml="ture"/>
    <title>淘神价主页</title>
</head>
<body>
<tb>淘神价主页</tb>

<input value="">

<table>
    <tr>
        <td>
            <div id="time"></div>
        </td>
    </tr>

    <tr>
        <td>
            <div value="A01_Servlet运行状态">A01_Servlet运行状态</div>
        </td>
    </tr>


    <tr>
        <td>
            <div value="A01_ServletConfig读取XML">A01_ServletConfig读取XML</div>
        </td>
    </tr>
    <tr>
        <td>
            <div value="A01_Servlet路径映射">A01_Servlet路径映射</div>
        </td>
    </tr>
    <tr>
        <td>
            <div value="A01_ServletContex存储">A01_ServletContex存储</div>
        </td>
    </tr>
    <tr>
        <td>
            <div value="A02_ServletContex读取">A02_ServletContex读取</div>
        </td>
    </tr>
    <tr>
        <td>
            <div value="A03_ServletContex获取xml配置的key和valve">A03_ServletContex获取xml配置的key和valve</div>
        </td>
    </tr>
    <tr>
        <td>
            <div value="A04_ServletContex获取properties文件">A04_ServletContex获取properties文件</div>
        </td>
    </tr>
    <tr>
        <td>
            <div value="A05_ServletContex的API">A05_ServletContex的API</div>
        </td>
    </tr>


    <tr>
        <td>
            <div value="A01_HttpServletResponse响应对象">A01_HttpServletResponse响应对象</div>
        </td>
    </tr>

    <tr>
        <td>
          <a href=${pageContext.request.contextPath}/A02_HttpServletResponse响应对象设置让客户端下载文件>A02_HttpServletResponse响应对象设置让客户端下载文件</a><br>
        </td>


    </tr>
    <tr>
        <td>
            <a href=${pageContext.request.contextPath}/A03_HttpServletResponse响应对象实现验证码>A03_HttpServletResponse响应对象实现验证码</a><br>

        </td>

    </tr>

    <tr>
        <td>
            <a href=${pageContext.request.contextPath}/jsp/HttpServletRequest.jsp>A01_HttpServletRequest请求对象</a><br>

        </td>

    </tr>

    <tr>
        <td>
            <a href=${pageContext.request.contextPath}/jsp/A01_cookie.jsp>A01_add_cookie</a><br>

        </td>

    </tr>

    <tr>
        <td>
            <a href=${pageContext.request.contextPath}/jsp/A01_Session.jsp>A01_Session会话</a><br>

        </td>

    </tr>

    <tr>
        <td>在线人数：${applicationScope.get("USERCOUNT")}</td>

    </tr>

    <tr>
        <td >
            <a href=${pageContext.request.contextPath}/jsp/invalidateSession.jsp>销毁回话 </a>
        </td>

    </tr>

    <tr>
        <td >
           请求次数:${applicationScope.get("Numberofrequests")}
        </td>

    </tr>


</table>



</body>
</html>
