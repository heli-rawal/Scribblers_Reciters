<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.AuthorUrlBean"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AuthorUrl list</title>




</head>
<body>

<form action="" name="authorUrl" id="authorUrl">

<center>
<table border="1">

<%
List<AuthorUrlBean> authorUrlList = (ArrayList)request.getAttribute("authorUrlList");

if(authorUrlList!=null){
	
	
%>
<tr>

<th>ID</th>
<th>URL</th>
<th>AUTHOR ID</th>

<th>ACTION</th>

</tr>
<%
for(int i=0;i<authorUrlList.size();i++){
	AuthorUrlBean authorUrl= authorUrlList.get(i);

%>

<tr>

<td><%=authorUrl.getId()%></td>
<td><%=authorUrl.getUrl()%></td>
<td><%=authorUrl.getAuthorDescriptionId()%></td>


<td>
<a href="AuthorUrlEditServlet?id=<%=authorUrl.getId()%>">EDIT</a> &nbsp;&nbsp;&nbsp;
<a href="AuthorUrlDeleteServlet?id=<%=authorUrl.getId()%>">DELETE</a>
</td>
</tr>


<%} 
}
else{%>
<h2>Something Went Wrong..............</h2>
<% }

 %>
</table>
</center>
</form>

</body>
</html>