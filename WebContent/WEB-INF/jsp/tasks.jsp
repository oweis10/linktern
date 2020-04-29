<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="role">
	<%= session.getAttribute("role") %>
</c:set>

<t:layout>
<div class="text-right">
	    <a class = "btn btn-primary" href="createtask">Create Task</a>
	</div>
	<div class="bd-example table-responsive">
	    <table class="table">
	        <thead>
	            <tr>
	                <th class="text-left" scope="col">Task title</th>
	                <th class="text-left" scope="col">Task Description</th>
	                 <th class="text-left" scope="col">Objective name</th>
	                 <th class="text-left" scope="col">Task Status</th>
	            </tr>
	     

	        </thead>
	        <tbody>
	            <c:forEach items="${tasks}" var="task">
	            	<tr>
	                    <td class="text-left" scope="col">${task.getTask_title()}</td>
	                    <td class="text-left" scope="col">${task.getTask_description()}</td>	                    
	                    <td class="text-left" scope="col">${task.getObjective_name()}</td>
	                    <c:choose>
						    <c:when test="${task.getTask_status() == 1}">
						        <td class="text-left text-primary" scope="col">Pending</td>
						        <c:choose>
								    <c:when test="${role == 'Work Mentor'}">
								        <td><a class = "btn btn-primary" href="showtask/${task.getTask_id() }">Show</a></td>
								    </c:when>
								</c:choose>
						    </c:when>
						</c:choose>
						<c:choose>
						    <c:when test="${task.getTask_status() == 2}">
						        <td class="text-left text-primary" scope="col">Approved</td>
								        <td><a class = "btn btn-primary" href="showtask/${task.getTask_id() }">Show</a></td>
						    </c:when>
						</c:choose>
						<c:choose>
						    <c:when test="${task.getTask_status() == 3}">
						        <td class="text-left text-danger" scope="col">Rejected</td>
						    </c:when>
						</c:choose>
						<c:choose>
						    <c:when test="${role == 'Student'}">
						        <td><a class = "btn btn-primary" href="viewtask/${task.getTask_id() }">Edit Task</a></td>
						    </c:when>
						</c:choose>
						
						
					</tr>
	            </c:forEach>
	        </tbody>
	    </table>
 	</div>
</t:layout>