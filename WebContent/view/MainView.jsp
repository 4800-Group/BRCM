<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Today's visit </title>
	</head>

	<body>
		<h1 style="color: black;" align="center"> <c:out value="Welcome ${requestScope.Name}!" /></h1>
        <h2 align="center">Choose activities:</h2>
        <form action="main" method="post" align="center" style="padding: 10px;">
            <input type="hidden" name="broncoid" value="${requestScope.broncoid}">  
            <div align="center">
                <select name="selection" >
                    <c:forEach items="${listCategory}" var="category">
                        <option value="${category.activityID}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div align="center" style="padding:10px;">
                    <td align="center"><input type="submit" id="submit" name="submit" value="Register"></td>
            </div>
            <table align="center">
  <c:forEach items="${activities}" var="item">
    <tr>
      <td><c:out value="${item}"/></td>
    </tr>
  </c:forEach>
</table>
        </form>
        
        <h1 style="color: red;"> <c:out value="${requestScope.ErrorLogin}" /></h1>
        
	</body>
	
</html>