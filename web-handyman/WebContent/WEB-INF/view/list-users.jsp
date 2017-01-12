<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>

	<title>
			List Users
	</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Handyman</h2>
		</div>
	
	</div>
	
	<div id="container">
		<div id="content">
		
		<!-- Add new Button -->
		
		<input type="button" value="Add User"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
		/>
		
		<!-- Add new Button to add new work order -->
		
		<input type="button" value="Add Workorder"
				onclick="window.location.href='listWorkOrder'; return false;"
				class="add-button"
		/>
		
		<!-- Add new Button to add new work order -->
		
		<input type="button" value="Add Workorder"
				onclick="window.location='listWorkOrder'; return false;"
				class="add-button"
		/>
		
		<a href="/web-handyman">Home</a>
		<a href="/web-handyman/workorder/list">WorkOrders</a>
		
		
		<!-- Add our html table -->
		
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
				
		
			</tr>
			<!-- Loop over and print our customers -->
			<c:forEach var="tempUser" items="${users}">
					<!-- Construct an update link with customer id -->
					
				 	<c:url var="updateLink" value="/handyman/showFormForUpdate">
						<c:param name="userId" value="${tempUser.id}"/>
					</c:url>
					
					<!-- Construct delete link with customer id -->
					<c:url var="deleteLink" value="/handyman/delete">
						<c:param name="userId" value="${tempUser.id}"/>
					</c:url> 
					
					<tr>
						<td>${tempUser.userName}</td>
						<td>${tempUser.userPassword}</td>
						<td>${tempUser.email}</td>
						
						<td><a href="${updateLink}">Update</a>
					    | <a href="${deleteLink}"
					    onclick="if (!(confirm('Are you sure you want to delete this user ?'))) return false"
					    
					    >Delete</a></td> 
					</tr>
			
			
			</c:forEach>
			
			
			
		</table>
		
		</div>
	
	
	
	</div>


</body>



</html>