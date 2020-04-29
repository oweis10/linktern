<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:layout>
	<div class="text-right">
	    <a class = "btn btn-primary" href="setplacement">Set Placement</a>
	</div>
	<div class="bd-example table-responsive mt-2">
	    <table class="table">
	        <thead>
	            <tr>
	                <th class="text-left" scope="col">Student name</th>
	                <th class="text-left" scope="col">School mentor name</th>
	                <th class="text-left" scope="col">Work mentor name</th>
	                <th class="text-left" scope="col">Company name</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${placements}" var="placement">
	            	<tr>
	                    <td class="text-left" scope="col">${placement.student_name}</td>
	                    <td class="text-left" scope="col">${placement.school_mentor_name}</td>
	                    <td class="text-left" scope="col">${placement.work_mentor_name}</td>
	                    <td class="text-left" scope="col">${placement.getCompany_Name() }</td>
	                    <td><a class = "btn btn-primary" href="viewplacement/${placement.id }">Edit Placement</a></td>
					</tr>
	            </c:forEach>
	        </tbody>
	    </table>
 	</div>
</t:layout>