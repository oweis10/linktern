<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:layout>
<h1 class="text-secondary">Edit User</h1>
<br/>

<form:form action="${contextPath}/updateuser" method="post" modelAttribute="user">
<form:hidden path="Id"/>
	<div class="form-group">
	

 	
 	    <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="FirstName">First Name</form:label>
	            
 	        </div>
 	        <div class="col-md-5">
	            <form:input path="FirstName" placeholder = "Enter First Name" class = "form-control" />
 	        </div>
 	        <div class="col-md-3">
	            
 	        </div>
 	    </div>

 	    <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="SecondName">Second Name</form:label>
	            
 	        </div>
 	        <div class="col-md-5">
	            <form:input path="SecondName" placeholder = "Enter Second Name" class = "form-control" />
 	        </div>
 	        <div class="col-md-3">
	            
 	        </div>
 	    </div>


 	    <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="LastName">Last Name</form:label>
	            
 	        </div>
 	        <div class="col-md-5">
	            <form:input path="LastName" placeholder = "Enter Last Name" class = "form-control" />
 	        </div>
 	        <div class="col-md-3">
	            
 	        </div>
 	    </div>
 	    
 	         <div class="row">
	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="Address">Address</form:label>
	        </div>
	        <div class="col-md-5">
	        	<form:input path="Address" placeholder = "Enter Address" class = "form-control"/>
	        </div>
	        <div class="col-md-3">
	            
	        </div>
	    </div>
	    
	    
	    
	   
	    
	    
	  <div class="row">
	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="MobileNumber">Phone Number</form:label>
	        </div>
	        <div class="col-md-5">
	        	<form:input path="MobileNumber" placeholder = "Enter Mobile Number" class = "form-control"/>
	        </div>
	        <div class="col-md-3">
	            
	        </div>
	    </div>
	    
	    
	    
 	    
 	     <div class="row">
	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="Company">Company Name</form:label>
	        </div>
	        <div class="col-md-5">
	        	<form:input path="Company" placeholder = "Enter Company Name" class = "form-control"/>
	        </div>
	        <div class="col-md-3">
	            
	        </div>
	    </div>
	    
	    
	        <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="RoleId">Roles</form:label>
 	        </div>
 	        <div class="col-md-5">
	            <form:select class="selectpicker form-control" multiple="false" path="RoleId">
 	                <option disabled>Select Roles</option>
	                <c:forEach items="${roles }" var="role">
	                	<c:choose>
	                		<c:when test="${selectedRole == role.getRole_id() }">
	                			<option selected value="${role.getRole_id()}">${role.getRole_name()}</option>
	                		</c:when>
	                		<c:otherwise>
	                			<option  value="${role.getRole_id()}">${role.getRole_name()}</option>
	                		</c:otherwise>
	                	</c:choose>
	                </c:forEach>
	            </form:select>
 	        </div>
 	        <div class="col-md-3">  
 	        </div>
 	    </div>
	    
	     <div class="row">
 	    	<div class="col-md-2">
 	    	</div>
 	    	<div class="col-md-5 text-right">
 	    	<button type="submit" class="btn btn-primary">Update</button>
 	    	</div>
 	    </div>
	    
	    
	 </div>
	    
</form:form>

</t:layout>