<%@page import="com.dao.AuthorUrlDao"%>
<%@page import="com.bean.AuthorUrlBean"%>

<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>authorUrl Insert Page</title>
</head>
<body>

<form action="AuthorUrlInsertServlet" name="authorUrlPage" id="authorUrlPage" method="post">
<table>

<tr>
<th>ADD url : </th>
<td><input type="text" name="url" id="url"> ${url} </td>
</tr>

<tr>
<th>ADD author description id : </th>
<td><input type="text" name="authorDescriptionId" id="authorDescriptionId"> ${authorDescriptionId} </td>
</tr>




<tr><td>
<input type="submit" name="call" id="call" value="ADD"> 
<input type="reset" name="clear" id="clear" value="CLEAR">
</td>
</tr>

</table>
</form>


</body>
</html>