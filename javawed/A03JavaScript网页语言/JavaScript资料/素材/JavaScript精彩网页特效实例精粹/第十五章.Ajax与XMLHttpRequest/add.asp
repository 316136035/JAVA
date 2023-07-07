<%
set c1=server.createobject("adodb.connection")
p1="provider=microsoft.jet.oledb.4.0;"
path1="data source="&server.mappath("user.mdb")
c1.open p1&path1
set rs=server.createobject("adodb.recordset")
rs.open "select * from 聊天室" ,c1,1,3
rs.addnew
rs("发布人")=trim(request.querystring("liuyan"))
rs("接收人")=trim(request.querystring("jieshou"))
rs("发送内容")=trim(request.querystring("content"))
rs("发布时间")=now()
rs.update
rs.close
set rs=nothing
c1.close
set c1=nothing%>