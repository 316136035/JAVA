<%Response.Charset = "GB2312"
  set c1=server.createobject("adodb.connection")
  p1="provider=microsoft.jet.oledb.4.0;"
  path1="data source="&server.mappath("data.mdb")
  c1.open p1&path1
  set rs=server.createobject("adodb.recordset")
  sql="select * from info"
  rs.open sql,c1,1,3
  rs.pagesize=5
  rs.absolutepage=cint(request("pagenumber"))
  response.write "<table border=0 width=420>"
  order=0
  while not rs.eof and order<rs.pagesize%>

	<tr>
		<td width=20><%=trim(rs("id"))%></td><td><%=trim(rs("a"))%></td><td><%=trim(rs("b"))%></td><td><font color=#cccccc><%=rs("c")%></font></td>
	</tr>

<%
    order=order+1
    rs.movenext
    wend
    response.write "</table>"
    rs.close
    c1.close
%> 
