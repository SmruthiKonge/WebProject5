<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<%@include file="/resources/header.jsp" %>
<title>Shopping Cart</title>
</head>

<body style="background-color:gray">
<center><h1>Shopping Cart</h1>
</center>
<%@include file="/resources/navbar.jsp" %>
 
	<div data-role="page">
		<div data-role="header" data-position="fixed">
	<center><h2>WelCome to Shopping Cart</h2></center>
<hr>
<table width="100%">
				<tr>
		<c:choose>
		<c:when test="${not empty loggedInUser}">
							<td>Welcome ${loggedInUser},</td>
							<td align="right"><a href="logout"> logout</a></td>
						</c:when>
				</tr>
				<tr>
					</c:choose>
					<c:if test="${loggedOut==true}">
						<td>${logoutMessage}</td>
					</c:if>
				</tr>
</table>
		</div>
		<div data-role="main" class="ui-content">
		<div id="admin">

				<c:if test="${isAdmin==true}">

					

				</c:if>
		
				<div id="categories">
					<c:if test="${isAdminClickedCategories==true}">
						<a href="categories">Add category</a>
					</c:if>
				</div>

				<div id="product">
					<c:if test="${isAdminClickedProducts==true}">
						<a href="product">Add Product</a>
					
					</c:if>
				</div>

				<div id="suppliers">
					<c:if test="${isAdminClickedSuppliers==true}">
						<a href="supplier">Add Supplier</a>
					</c:if>
				</div>
			</div>
		</div>			

		
</body>
</html>