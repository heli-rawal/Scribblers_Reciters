
<%@page import="com.dao.AuthorUrlDao"%>
<%@page import="com.bean.AuthorUrlBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AuthorUrl Edit Page</title>
</head>
<body>

<form action="AuthorUrlUpdateServlet" name="authorUrlPage" id="authorUrlPage" method="post">
<input type="hidden" name="id" id="id" value="${authorUrl.id}">


<table>
<% AuthorUrlBean authorUrlBean = (AuthorUrlBean)request.getAttribute("authorUrlBean"); %>

<table>

<tr>
<th>url : </th>
<td><input type="text" name="url" id="url" value="${authorUrlBean.url}"> ${url} </td>
</tr>
<tr>

<tr>
<th>author id : </th>
<td><input type="text" name="authorId" id="authorId" value="${authorUrlBean.authorId}"> ${authorId} </td>
</tr>
<tr>


<td>
<input type="submit" name="call" id="call" value="UPDATE"> 
<input type="reset" name="clear" id="clear" value="CLEAR">
</td>
</tr>

</table>
</form>


</body>
</html>