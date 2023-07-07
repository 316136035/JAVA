<%Response.Charset = "GB2312"
set c1=server.createobject("adodb.connection")
p1="provider=microsoft.jet.oledb.4.0;"
path1="data source="&server.mappath("info.mdb")
c1.open p1&path1

set rs=server.createobject("adodb.recordset")
rs.open "select * from info order by 发布时间 desc" ,c1,1,1
response.write "<table border=1 width=550 style='border-collapse: collapse' bordercolor='#ADCBEF'><tr bgcolor='#336633'><td width=30><font color='#ffffff'>ID</font></td><td height=20><font color='#ffffff'>信息标题</font></td><td width=150><font color='#ffffff'>发布时间</font></td><td width=60><font color='#ffffff'>发布人</font></td></tr>"
for i=1 to rs.recordcount%>

	<tr>
		<td><%=trim(rs("ID"))%></td>
		<td><%=trim(rs("信息标题"))%></td>
		<td><%=trim(rs("发布时间"))%></td>
		<td><%=trim(rs("发布人"))%></td>
	</tr>

<%rs.movenext
next
response.write "</table>"
rs.close
set rs=nothing
c1.close
set c1=nothing%>