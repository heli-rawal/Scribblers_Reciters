<jsp:include page="header.jsp"></jsp:include>
<%@page import="com.dao.SecurityQuestionDao"%>
<%@page import="com.bean.SecurityQuestionBean"%>
<%@page import="com.dao.UserTypeDao"%>
<%@page import="com.bean.UserTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.bean.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<link href="bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet" />
	<script src="bootstrap-3.3.6-dist/js/bootstrap.js" type="text/javascript">
	 </script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

<form action="UserInsertServlet" name="userPage" id="userPage" method="post">

 
<table class="table table-bordered" align="center" id="demo">

<tr>
<td align="center">Name : </td>
<td><input type="text" name="name" id="name"> ${name} </td>
</tr>


<tr>
<td align="center">Email : </td>
<td>
<input type="text" name="email" id="email"> ${email}
</td>
</tr>

<tr>
<td align="center">Password : </td>
<td>
<input type="password" name="password" id="password">${password} 
</td>
</tr>



<tr>
<td align="center">Security question  : </td>
<td>
<select name="securityQuestionId" id="securityQuestionId">
<option value="0">---- SELECT SECURITY QUESTION ----</option>
<% List<SecurityQuestionBean> securityQuestionList = new SecurityQuestionDao().select(); 

if(securityQuestionList!=null){
	
	for(int i =0;i<securityQuestionList.size();i++){
		SecurityQuestionBean securityQuestion = securityQuestionList.get(i);
%>
<option value="<%=securityQuestion.getSecurityQuestionId()%>"><%=securityQuestion.getSecurityQuestion()%></option>
<%}
	
} %>
</select>${securityQuestionId} 
</td>
</tr>
<tr>
<td align="center">Security answer  : </td>
<td>
<input type="text" name="securityAnswer" id="securityAnswer">${securityAnswer} 
</td>
</tr>
</td>
</tr>

<tr>
<td align="center">User Type  : </td>
<td>
<select name="userTypeId" id="userTypeId">
<option value="0">---- SELECT USER TYPE ----</option>
<% List<UserTypeBean> userTypeList= new UserTypeDao().select(); 

if(userTypeList!=null){
	
	for(int i =0;i<userTypeList.size();i++){
		UserTypeBean userType = userTypeList.get(i);
%>
<option value="<%=userType.getUserTypeId()%>"><%=userType.getUserType()%></option>
<%}
	
} %>
</select>${userTypeId} 
</td>
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
<jsp:include page="footer.jsp"></jsp:include>