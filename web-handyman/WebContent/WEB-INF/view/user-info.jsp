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
<br>
	
	<div id="container">
		<div id="content">
		
		<!-- Add new Button -->
		
		<input type="button" value="Add User"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
		/>
		
		
		<a href="/web-handyman">Home</a>
		<a href="/web-handyman/workorder/list">WorkOrders</a>
		<a href="/web-handyman/handyman/list">Handyman</a>
		<a href="/web-handyman/admin">Admin</a>
		
		<h4>You logged in as: <c:out value="${pageContext.request.remoteUser}"/></h4>
		<h4> Name from session: ${sessionScope.userLogged.userName}</h4>
		<h4> Handyman from session: ${sessionScope.handymanLogged.firstName}
					${sessionScope.handymanLogged.lastName}</h4>

		
		<!-- Add our html table -->
		
		<table>
			<tr>
				<th>User Name</th>
				<th>Password</th>
				<th>Email</th>
				<th>Action</th>
				
		
			</tr>
			<!-- Loop over and print our customers -->
			
					<!-- Construct an update link with customer id -->
					
				 	<c:url var="updateLink" value="/user/showFormForUpdate">
						<c:param name="userId" value="${user.id}"/>
					</c:url>
					
					<!-- Construct delete link with customer id -->
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${user.id}"/>
					</c:url> 
					
					<tr>
						<td>${user.userName}</td>
						<td>${user.userPassword}</td>
						<td>${user.email}</td>
						
						<td><a href="${updateLink}">Update</a>
					    | <a href="${deleteLink}"
					    onclick="if (!(confirm('Are you sure you want to delete this user ?'))) return false"
					    
					    >Delete</a></td> 
					</tr>
			
			
			
		</table>
		
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
			
					<!-- Construct an update link with handyman id -->
					
				 	<c:url var="updateLink" value="/handyman/showFormForUpdate">
						<c:param name="handymanId" value="${handyman.id}"/>
					</c:url>
					
					<!-- Construct delete link with customer id -->
					<c:url var="deleteLink" value="/handyman/delete">
						<c:param name="handymanId" value="${handyman.id}"/>
					</c:url> 
					
					<tr>
						<td>${handyman.id}</td>
						<td>${handyman.firstName}</td>
						<td>${handyman.lastName}</td>
						<td>${handyman.phoneNumber}</td>
						<td>${handyman.rate}</td>
						<td>${handyman.insurance}</td>
						<td>${handyman.active}</td>
						
						<td><a href="${updateLink}">Update</a>
					    | <a href="${deleteLink}"
					    onclick="if (!(confirm('Are you sure you want to delete this Handyman ?'))) return false"
					    
					    >Delete</a></td> 
					</tr>
			
			
			
			
			
		</table>
		
		<br>
		<h4>Active work orders: </h4>
		<br>
		
		<table>
			<tr>
				<th>Work Order Name</th>
				<th>Description</th>
				<th>Estimate</th>
				<th>Location</th>
				<th>Date received</th>
				<th>Completed</th>
				<th>Action</th>
				
		
			</tr>
			<!-- Loop over and print our customers -->
			<c:forEach var="listOfWorkorders" items="${listOfWorkorders}">
					<!-- Construct an update link with workorder id -->
					
				 	<c:url var="updateLink" value="/workorder/showFormForUpdate">
						<c:param name="workorderId" value="${listOfWorkorders.id}"/>
					</c:url>
					
					<!-- Construct delete link with customer id -->
					<c:url var="deleteLink" value="/workorder/delete">
						<c:param name="workorderId" value="${listOfWorkorders.id}"/>
					</c:url> 
					
					<tr>
						<td>${listOfWorkorders.workOrderName}</td>
						<td>${listOfWorkorders.workDescription}</td>
						<td>${listOfWorkorders.estimate}</td>
						<td>${listOfWorkorders.location}</td>
						<td>${listOfWorkorders.dateReceived}</td>
						<td>${listOfWorkorders.isCompleated}</td>
						
						<td><a href="${updateLink}">Update</a>
					    | <a href="${deleteLink}"
					    onclick="if (!(confirm('Are you sure you want to delete this workorder ?'))) return false"
					    
					    >Delete</a></td> 
					</tr>
			
			
			</c:forEach>
			
			
			
		</table>
	
		<br>
		<br>
		
		
		</div>
	
	
	
	</div>


</body>



</html>