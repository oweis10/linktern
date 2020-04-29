<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="role">
	<%= session.getAttribute("role") %>
</c:set>

<t:layout>
<div class="text-right">
		<c:choose>
	        <c:when test="${role == 'Admin' }">
	        	<a class = "btn btn-primary" href="setuser">Set User</a>
	        </c:when>
        </c:choose>
	    
	</div>
	<div class="bd-example table-responsive">
	    <table class="table">
	        <thead>
	            <tr>
	                <th class="text-left" scope="col">First name</th>
	                <th class="text-left" scope="col">Second name</th>
	                <th class="text-left" scope="col">Last name</th>
	                <th class="text-left" scope="col">Email</th>
	                 <th class="text-left" scope="col">Mobile Number</th>
	                <th class="text-left" scope="col">Address</th>
	                <th class="text-left" scope="col">Company</th>
	                <th class="text-left" scope="col">Role</th>
	                <th class="text-left" scope="col"></th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${users}" var="user">
	            	<tr>
	                    <td class="text-left" scope="col">${user.getFirstName()}</td>
	                    <td class="text-left" scope="col">${user.getSecondName()}</td>
	                    <td class="text-left" scope="col">${user.getLastName()}</td>
	                     <td class="text-left" scope="col">${user.getEmail()}</td>
	                     <td class="text-left" scope="col">${user.getMobileNumber()}</td>
	                    <td class="text-left" scope="col">${user.getAddress()}</td>
	                    <td class="text-left" scope="col">${user.getCompany()}</td>
	                    <td class="text-left" scope="col">${user.getRole()}</td>
	                    <c:choose>
	                    	<c:when test="${role == 'Admin' }">
	                    		<td><a class = "btn btn-primary" href="viewuser/${user.getId()}">Edit</a></td>
	                    	</c:when>
	                    </c:choose>
	                    <c:choose>
	                    	<c:when test="${role == 'Work Mentor' or role == 'School Mentor'}">
	                    		<td><a class = "btn btn-primary" href="timeline/${user.getId()}">TimeLine</a></td>
	                    	</c:when>
	                    </c:choose>
	                    
					</tr>
	            </c:forEach>
	        </tbody>
	    </table>
 	</div>
</t:layout>