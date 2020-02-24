<%@page import="com.dao.SecurityQuestionDao"%>
<%@page import="com.bean.SecurityQuestionBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.AuthorDescriptionDao"%>
<%@page import="com.bean.AuthorDescriptionBean"%>

<!DOCTYPE html>
<html>
<head>
<link href="bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet" />
	<script src="bootstrap-3.3.6-dist/js/bootstrap.js" type="text/javascript">
	 </script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Author Description Insert Page</title>
</head>
<body>

<form action="AuthorDescriptionInsertServlet" name="userPage" id="userPage" method="post">
<h1 align="center"><b><i><u> Form</u></i></b></h1>
 
<table class="table table-bordered" align="center" id="demo">

<tr>
<td align="center">User id : </td>
<td><input type="text" name="userId" id="userId"> ${userId} </td>
</tr>


<tr>
<td align="center">Bio : </td>
<td>
<textarea rows=50 cols=80 name="bio" id="bio"> ${bio}
</textarea>
</td>
</tr>

<tr>
<td align="center">list of books : </td>
<td>
<textarea rows=50 cols=80 name="listOfBooks" id="listOfBooks"> ${listOfBooks}
</textarea> 
</td>
</tr>



<tr>
<td align="center">Url id : </td>
<td><input type="text" name="urlId" id="urlId"> ${userId} </td>
</tr>

<tr>
<td align="center">category id : </td>
<td><input type="text" name="categoryId" id="categoryId"> ${categoryId} </td>
</tr>

<tr>
		<td>Profile picture :</td>
		<td><input type="file" name="profilePicture" id="profilePicture"> ${profilePicture}</td>
	</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" name="call" id="call" value="ADD" align="center"> 
<input type="reset" name="clear" id="clear" value="CLEAR" align="center">
</td>
</tr>

</table>
</form>

</body>
</html>