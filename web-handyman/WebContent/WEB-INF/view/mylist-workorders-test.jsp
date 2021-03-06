<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>

	<title>
			List Workorders
	</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
		
		<input type="button" value="Add Workorder"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
		/>
		
		
		<a href="/web-handyman">Home</a>
		<a href="/web-handyman/workorder/list">WorkOrders</a>
		<a href="/web-handyman/handyman/list">Handyman</a>
		<a href="/web-handyman/admin">Admin</a>
		
		<!-- Add our html table -->
		
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
			<c:forEach var="tempWorkorder" items="${workorders}">
					<!-- Construct an update link with workorder id -->
					
				 	<c:url var="updateLink" value="/workorder/showFormForUpdate">
						<c:param name="workorderId" value="${tempWorkorder.id}"/>
					</c:url>
					
					<!-- Construct delete link with customer id -->
					<c:url var="deleteLink" value="/workorder/delete">
						<c:param name="workorderId" value="${tempWorkorder.id}"/>
					</c:url> 
					
					<tr>
						<td>${tempWorkorder.workOrderName}</td>
						<td>${tempWorkorder.workDescription}</td>
						<td>${tempWorkorder.estimate}</td>
						<td>${tempWorkorder.location}</td>
						<td>${tempWorkorder.dateReceived}</td>
						<td>${tempWorkorder.isCompleated}</td>
						
						<td><a href="${updateLink}">Update</a>
					    | <a href="${deleteLink}"
					    onclick="if (!(confirm('Are you sure you want to delete this workorder ?'))) return false"
					    
					    >Delete</a></td> 
					</tr>
			
			
			</c:forEach>
			
			
			
		</table>
		
		</div>
	
	
	
	</div>


</body>



</html>