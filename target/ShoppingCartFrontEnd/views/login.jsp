

<html>
<head>
<%@include file="/resources/header.jsp" %>

<title>Shopping chart</title>
</head>
<body style="background-color:#FF69B4">
<center><h1>Shopping Cart</h1>
</center>
 
<%@include file="/resources/navbar.jsp" %>


	<center><h2>Please login with your credentials</h2></center>
	<br> ${message}
	<c:url var="action" value="/login"></c:url>

	<div class="container">
  
  <form>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>