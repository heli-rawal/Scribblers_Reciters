<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.dao.UserTypeDao"%>
<%@page import="com.bean.UserTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.bean.UserBean"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<form action="LoginServlet" name="loginPage" id="loginPage" method="post">

 
<table class="table table-bordered" align="center" id="demo">



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
<input type="submit" name="call" id="call" value="LOGIN" align="center"> 
<input type="reset" name="clear" id="clear" value="CLEAR" align="center">
</td>
</tr>

</table>
</form>


</body>

</html>
<jsp:include page="footer.jsp"></jsp:include>