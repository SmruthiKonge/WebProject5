

<html>
<head>
<%@include file="/resources/header.jsp"%>
<title>Register User</title>
</head>
<body style="background-color: #FF69B4">
	<center>
		<h1>Shopping Cart</h1>
	</center>

	<%@include file="/resources/navbar.jsp"%>


	<center><h2>Please fill the details</h2></center>

	<div class="container">
  
  <form>
    <div class="form-group">
      <label for="email">UserID:</label>
      <input type="userid" class="form-control" id="userid" placeholder="Enter userid">
    </div>
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="username" class="form-control" id="username" placeholder="Enter Name">
    </div>
    <div class="form-group">
      <label for="mobile">Mobile:</label>
      <input type="mobile" class="form-control" id="mobile" placeholder="Enter Mobile">
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter Email">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter Password">
    </div>
    <div class="form-group">
      <label for="address">Address:</label>
      <input type="address" class="form-control" id="address" placeholder="Enter Address">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>


</body>
</html>