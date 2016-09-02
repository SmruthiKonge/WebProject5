
<html>
<head>
<%@include file="/resources/header.jsp" %>
<title>Shopping Cart</title>
</head>

<body style="background-color:#FF69B4">
<center><h1>Shopping Cart</h1>
</center>
 
<%@include file="/resources/navbar.jsp" %>
 
	<div>
	
<center><h2>WelCome to Shopping Cart</h2></center>
<hr>
			<table width="100%">
				<tr>
					<c:choose>
						<c:when test="${empty loggedInUser}">
							<td align="left">Existing user<a href="loginHere"> Login
									here</a></td>
							<td align="right">New user<a href="registerHere">
									Register here</a></td>
						</c:when>
						
					</c:choose>
				</tr>
			</table>
		</div>
</body>
</html>