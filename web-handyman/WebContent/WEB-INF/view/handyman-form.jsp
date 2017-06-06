<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>

<html>

<head>

	<title>
			Save Handyman
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
		<h3> Save User</h3>
	<form:form action="saveHandyman" modelAttribute="handyman" method="POST">
	
		<!-- need to assotiate thes data with customer id -->
		<form:hidden path="id"/>
	
	
		<table>
			<tbody>
				<tr>
					<td><label>First Name:</label></td>
					<td><form:input path="firstName"/></td>
				
				
				</tr>
			
				<tr>
					<td><label>Last Name:</label></td>
					<td><form:input path="lastName"/></td>
				
				
				</tr>
				
				<tr>
					<td><label>Phone number:</label></td>
					<td><form:input path="phoneNumber"/></td>
				
				
				</tr>
				
				<tr>
					<td><label>Rate:</label></td>
					<td><form:input path="rate"/></td>
				
				
				</tr>
				
				<tr>
					<td><label>Insurance:</label></td>
					<td><form:input path="insurance"/></td>
				
				
				</tr>
				
				<tr>
					<td><label>Active:</label></td>
					<td><form:input path="active"/></td>
				
				
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
			<a href="${pageContext.request.contextPath}/user/list">Back to list</a>
		</p>
	
	
	
	</div>



</body>
</html>