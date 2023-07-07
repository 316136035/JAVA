<% 
Response.ContentType="text/xml"
if request.querystring("username")="zt" and request.querystring("pwd")="111" then
response.write("<SUCCESS/>")
else
response.write("<ERROR/>")
end if 
%>  