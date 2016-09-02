<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<%@include file="/resources/header.jsp" %>

<title>Shopping cart</title>
</head>
<body style="background-color:gray">
<center><h1>Shopping Cart</h1>
</center>
 
<%@include file="/resources/navbar.jsp" %>


	<center><h2>Please login with your credentials</h2></center>
	<br> ${message}
	
	<div class="container">
${successMessage}  
  <form action="login" method="post" role="form">
    <div class="form-group">
      <label for="name">UserName:</label>
      <input type="username" class="form-control" name="name" id="name" placeholder="Enter Name">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="password" id="pwd" placeholder="Enter password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>