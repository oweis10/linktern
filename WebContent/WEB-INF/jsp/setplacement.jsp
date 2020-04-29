<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<t:layout>
<h1 class="text-secondary">Set New Placement</h1>
<br/>
<form:form action="setnewplacement" method="post" modelAttribute="placement">
	<div class="form-group">
	    <div class="row">
	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="Company_Name">Company Name</form:label>
	        </div>
	        <div class="col-md-5">
	        	<form:input path="Company_Name" placeholder = "Enter Company Name" class = "form-control"/>
	        </div>
	        <div class="col-md-3">
	            
	        </div>
	    </div>
 	    <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="student_id">Student</form:label>
 	        </div>
 	        <div class="col-md-5">
	        	<form:select class="form-control" path="student_id">
 	                <option disabled selected>Select Student</option>
	                <c:forEach items="${students }" var="student">
	                	<option value="${student.getId() }">${student.getFullName()}</option>
	                </c:forEach>
	            </form:select>
 	        </div>
 	        <div class="col-md-3">
	            
 	        </div>
 	    </div>
 	    <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="school_mentor_id">School Mentor</form:label>
	            
 	        </div>
 	        <div class="col-md-5">
	            <form:select class="form-control" path="school_mentor_id">
 	                <option disabled selected>Select School Mentor</option>
	                <c:forEach items="${schoolMentors }" var="school">
	                	<option value="${school.getId() }">${school.getFullName()}</option>
	                </c:forEach>
	            </form:select>
 	        </div>
 	        <div class="col-md-3">
	            
	        </div>
 	    </div>
 	    <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="work_mentor_id">Work Mentor</form:label>
	            
 	        </div>
 	        <div class="col-md-5">
	            <form:select class="form-control" path="work_mentor_id">
 	                <option disabled selected>Select Work Mentor</option>
	                <c:forEach items="${workMentors }" var="work">
	                	<option value="${work.getId() }">${work.getFullName()}</option>
	                </c:forEach>
	            </form:select>
 	        </div>
 	        <div class="col-md-3">
	            
 	        </div>
 	    </div>
 	    <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="start_date">Start Date</form:label>
	            
 	        </div>
 	        <div class="col-md-5">
	            <form:input path="start_date" placeholder = "Enter Start Date" class = "datepicker form-control" data_provide = "datepicker" data_date_autoclose = "true" data_date_format = "yyyy-mm-dd"/>
 	        </div>
 	        <div class="col-md-3">
	            
 	        </div>
 	    </div>
	    <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="end_date">End Date</form:label>
	            
 	        </div>
 	        <div class="col-md-5">
	        	<form:input path="end_date" placeholder = "Enter End Date" class = "datepicker form-control" data_provide = "datepicker" data_date_autoclose = "true" data_date_format = "yyyy-mm-dd"/>
 	        </div>
 	        <div class="col-md-3">
	            
 	        </div>
 	    </div>
 	    <div class="row">
 	        <div class="col-md-2">
	        	<form:label class = "form-control font-weight-bolder" path="objectives">Objectives</form:label>
 	        </div>
 	        <div class="col-md-5">
	            <form:select class="selectpicker form-control" multiple="true" path="objectives">
 	                <option disabled selected>Select Objectives</option>
	                <c:forEach items="${objectives }" var="objective">
	                	<option value="${objective.getId() }">${objective.getName()}</option>
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
 	    	<button type="submit" class="btn btn-primary">Submit</button>
 	    	</div>
 	    </div>
	</div>
	    
</form:form>
<script>
     $(document).ready(function () {
         $('.selectpicker').selectpicker();
         $('.datepicker').datepicker();
     })

    
</script>
</t:layout>