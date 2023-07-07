<%Response.Charset = "GB2312"
set c1=server.createobject("adodb.connection")
p1="provider=microsoft.jet.oledb.4.0;"
path1="data source="&server.mappath("user.mdb")
c1.open p1&path1

set rs=server.createobject("adodb.recordset")
rs.open "select * from 聊天室 order by 发布时间 asc" ,c1,1,1
response.write "<table border=0>"
for i=1 to rs.recordcount%>

	<tr>
		<td>【<%=trim(rs("发布人"))%>】对【<%=trim(rs("接收人"))%>】说:<%=trim(rs("发送内容"))%>&nbsp;&nbsp;&nbsp;<font color=#cccccc><%=rs("发布时间")%></font></td>
	</tr>

<%rs.movenext
next
response.write "</table>"
rs.close
set rs=nothing
c1.close
set c1=nothing%>