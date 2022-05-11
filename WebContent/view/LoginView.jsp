<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Authentication</title>

        <script>  
        function verifyFields() {  
           if(document.getElementById('username').value == "")
           {
        	   alert("Username not informed.");
        	   return false;
           }else if(document.getElementById('password').value == "") {
        	   alert("Password not informed.");
        	   return false;        	   
           } else {
        	   return true;
           }
        }  
        </script>		
		
	</head>

	<body>
	
	<form action="login" method="post">
		<table bgcolor="#ffffff" width="500" height="80" align="center">
				<tr>
				  <td><c:out value="Bronco ID: "></c:out></td>
				  <td><input type="text" id = "broncoid" name="broncoid"></td>
				</tr>
		</table>
		<table bgcolor="#ffffff" width="500" height="80" align="center" border="0">		
				<tr>
				  <td></td>
				  <!--<td align="right"><input type="submit" id="submit" name="submit" value="Submit"></td>-->
				  <td align="right"><input type="submit" id="submit" name="submit" value="Start visit"></td>
				  <td></td>
				  <td><input type="reset" name="clean" value="Clean"></td>
				  <td></td>
				</tr>  
		</table>
	</form>
	
	<h1 style="color: red;"> <c:out value="${requestScope.ErrorLogin}" /></h1>
	
	</body>
	
</html>