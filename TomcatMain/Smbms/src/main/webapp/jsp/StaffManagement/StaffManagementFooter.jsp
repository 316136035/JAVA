<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript"></script>
<script src=${pageContext.request.contextPath}/static/lib/jquery-3.6.1.min.js c></script>
<script src="${pageContext.request.contextPath}/js/StaffManagementFooter.js" charset=”utf-8″></script>
<link href="${pageContext.request.contextPath}/css/StaffManagement.css" type="text/css" rel="stylesheet">

<html>
<head>

</head>
<body>


  <table id="href">

    <tr target="_parent">

      <td><A href="javascript:to_page(${pageNo-1})">前一页</A></td>
      <td>第${pageNo}页</td>
      <td><A href="javascript:to_page(${pageNo+1})">后一页</A></td>

      <td>共${countpage}页</td>

      <td>总${count}条数据</td>

      <input type="hidden" value="1" id="pageNo" name="pageNo"/>
      <input type="hidden" value="5" id="pageSize" name="pageSize"/>


      </div>
      </sqan>
    </tr>


  </table>



</body>
</html>
