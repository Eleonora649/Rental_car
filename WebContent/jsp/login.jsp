<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	
	<%-- <c:if test="${currentUser == 'customer'}"> --%>
	
		<form method="post" action="">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Email address</label>
		    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Password</label>
		    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
		  </div>
		  
		  <button type="submit" class="btn btn-primary bottone">Submit</button>
		</form>
	
	<%-- </c:if> --%>
</div>