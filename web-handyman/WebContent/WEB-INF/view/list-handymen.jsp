<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>

	<title>
			List of Handymen
	</title>
	
	<!-- reference our style sheet -->
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/w3.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Handyman</h2>
		</div>
	
	</div>
	<div class="w3-bar w3-blue">
  <a href="/web-handyman" class="w3-bar-item w3-button">Home</a>
  <a href="/web-handyman/workorder/list" class="w3-bar-item w3-button">WorkOrders</a>
  <a href="/web-handyman/workorder/mylist" class="w3-bar-item w3-button">My workorders</a>
  <a href="/web-handyman/handyman/list" class="w3-bar-item w3-button">Handymen</a>
  <a href="/web-handyman/user/mypage" class="w3-bar-item w3-button">User info</a>
  <a href="/web-handyman/admin" class="w3-bar-item w3-button">Admin</a>
</div>
	
	<div id="container">
		<div id="content">
		
		<!-- Add new Button -->
		
		<input type="button" value="Add Handyman"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
		/>
		
		
		<a href="/web-handyman">Home</a>
		<a href="/web-handyman/workorder/list">WorkOrders</a>
		<a href="/web-handyman/handyman/list">Handymen</a>
		<a href="/web-handyman/admin">Admin</a>
		
		<!-- Add our html table -->
		
		<table>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone number</th>
				<th>Rate</th>
				<th>Insurance</th>
				<th>Active</th>
				<th>Action</th>
				
				
		
			</tr>
			<!-- Loop over and print our customers -->
			<c:forEach var="tempUser" items="${handymen}">
					<!-- Construct an update link with handyman id -->
					
				 	<c:url var="updateLink" value="/handyman/showFormForUpdate">
						<c:param name="handymanId" value="${tempUser.id}"/>
					</c:url>
					
					<!-- Construct delete link with customer id -->
					<c:url var="deleteLink" value="/handyman/delete">
						<c:param name="handymanId" value="${tempUser.id}"/>
					</c:url> 
					
					<tr>
						<td>${tempUser.id}</td>
						<td>${tempUser.firstName}</td>
						<td>${tempUser.lastName}</td>
						<td>${tempUser.phoneNumber}</td>
						<td>${tempUser.rate}</td>
						<td>${tempUser.insurance}</td>
						<td>${tempUser.active}</td>
						
						<td><a href="${updateLink}">Update</a>
					    | <a href="${deleteLink}"
					    onclick="if (!(confirm('Are you sure you want to delete this Handyman ?'))) return false"
					    
					    >Delete</a></td> 
					</tr>
			
			
			</c:forEach>
			
			
			
		</table>
		
		</div>
	
	
	
	</div>


</body>



</html>