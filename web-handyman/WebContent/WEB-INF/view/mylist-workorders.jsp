<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>

	<title>
			Admin page::
	</title>
	
	<!-- reference our style sheet -->
	

</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-bar w3-blue">
  <a href="/web-handyman" class="w3-bar-item w3-button">Home</a>
  <a href="/web-handyman/workorder/list" class="w3-bar-item w3-button">WorkOrders</a>
  <a href="/web-handyman/workorder/mylist" class="w3-bar-item w3-button">My workorders</a>
  <a href="/web-handyman/handyman/list" class="w3-bar-item w3-button">Handymen</a>
  <a href="/web-handyman/admin" class="w3-bar-item w3-button">Admin</a>
</div>
<br>

<h4>Admin's page</h4>
		<a href="/web-handyman">Home</a>
		<a href="/web-handyman/workorder/list">WorkOrders</a>
		<a href="/web-handyman/handyman/list">Handymen</a>
		<a href="/web-handyman/admin">Admin</a>
<h4>You logged in as: <c:out value="${pageContext.request.remoteUser}"/></h4>
<h4>Name: <c:out value="${userName}"/></h4>
<h4>Name: <c:out value="${getUserName}"/></h4>
<h4>Logout status: ${param.logout}</h4>

<%-- <c:url value="/login?logout" var="loginUrl"/> --%>

<form action="${pageContext.request.contextPath}/logout" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Log out" />
</form>



<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">       
	<c:if test="${param.error != null}">        
		<p>
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${param.logout != null}">       
		<p>
			You have been logged out.
		</p>
	</c:if>
	<p>
		<label for="username">Username</label>
		<input type="text" id="username" name="username"/>	
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password"/>	
	</p>
	<input type="hidden"                       
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn">Log in</button>
</form>

</body>



</html>