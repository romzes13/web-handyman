<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>

<html>

<head>

	<title>
			Save Workorder
	</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	
	
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2> HRM - Handyman Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3> Save Workrder</h3>
	<form:form action="saveWorkOrder" modelAttribute="workorder" method="POST">
	
		<!-- need to assotiate thes data with workorder id -->
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



</body>
</html>