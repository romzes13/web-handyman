<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>

<html>

<head>

	<title>
			Save Workorder
	</title>
	
	<link rel="stylesheet" href="https://unpkg.com/flatpickr/dist/flatpickr.min.css">
	
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	
	
	
</head>
<body>
	
	
	

<!-- 	<script src="/js/my.js"></script> -->

	<div id="wrapper">
		<div id="header">
			<h2> HRM - Handyman Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3> Save Workrder</h3>
		
		<form:errors path="workorder.*"/>
		<form:errors path="user.*"/>
		
	<form:form action="saveWorkOrder" modelAttribute="workorder" method="POST">
	
		<!-- need to assotiate the data with workorder id -->
		<form:hidden path="id"/>
		
	
		<table>
			<tbody>
				<tr>
					<td><label>Work order name:</label></td>
					<td><form:input path="workOrderName"/></td>
				
				
				</tr>
			
				<tr>
					<td><label>Description:</label></td>
					<td><form:input path="workDescription"/></td>
				
				
				</tr>
				
				<tr>
					<td><label>Estimate:</label></td>
					<td><form:input path="estimate"/></td>
				
				
				</tr>
				
				<tr>
					<td><label>Location:</label></td>
					<td><form:input path="location"/></td>
				
				
				</tr>
				
				<tr><td><label>Date received:</label></td> <td>
					<form:input class="flatpickr"  path="dateReceived" type="text" placeholder="Select Date.."/>
				</td></tr>
				
				
				
<%-- 				<tr><td><label>Date received:</label></td> <td><form:input path="dateReceived"/></td></tr> --%>
				<tr><td><label>Date scheduled:</label></td> <td><form:input class="flatpickr" path="dateScheduled" 
				type="text" placeholder="Select Date.."/></td></tr>
				
				<tr><td><label>Date completed:</label></td> <td>
				<form:input class="flatpickr" path="dateCompleated" type="text" placeholder="Select Date.."/></td></tr>
				
				<tr><td>Workorder status:</td> <td>
				<form:radiobutton path="isCompleated" value="1" label="Completed (True)"/>
				
   				 </td><td>
				<form:radiobutton path="isCompleated" value="${false}" label="Not completed (False)"/>
   				 </td>
				</tr>
				
				
				
				<tr>
					<td><label>User name:</label></td>
					<td><form:input path="user.userName"/></td>
				
				
				</tr>
				
				<tr>
				
				<td><label>User:</label></td>
					<td><form:select path="user.id">
						<form:option value="${null}" label="null" />
						<form:options items="${users}" 
					 itemLabel="userName" itemValue="id"  
						/>
		
						</form:select>
					</td>	
				
				</tr>
			
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"></td>
				
				</tr>
			
			</tbody>
		
		</table>
	
	</form:form>
	
	<div style="clear; both;"></div>
	
		<p>
			<a href="${pageContext.request.contextPath}/workorder/list">Back to list</a>
		</p>
	
	
	
	</div>
<script src="https://unpkg.com/flatpickr"></script>
<script>
		
//jQuery

flatpickr(".flatpickr", {
enableTime: true,
altInput: true,
altFormat: "F j, Y h:i K"
});
		
	flatpickr(".selector", {}); // [Flatpickr, Flatpickr, ...]
	document.getElementById('dateReceived').flatpickr(config); // Flatpickr
	document.getElementById('dateScheduled').flatpickr(config); // Flatpickr
	document.getElementById('dateCompleated').flatpickr(config); // Flatpickr
	let calendar = new Flatpickr(element, config); // Flatpickr

	
	
	</script>

</body>
</html>