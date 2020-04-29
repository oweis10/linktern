<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<t:layout>
	
	<br />
	<form:form action="createnewtask" method="post"
		modelAttribute="task">
		<div class="form-group">
			<div class="row">
				<div class="col-md-6 text-center">
				<h3 class="text-secondary">Create New Task</h3>
					<div class="row">
						<div class="col-md-4">
							<form:label class="form-control font-weight-bolder"
								path="task_title">Title</form:label>
						</div>
						<div class="col-md-8">
							<form:input path="task_title" placeholder="Enter Title"
								class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<form:label class="form-control font-weight-bolder"
								path="objective_id">Objectives</form:label>
						</div>
						<div class="col-md-8">
							<form:select class="form-control" id="obj" path="objective_id">
								<option disabled selected>Select Objective</option>
								<c:forEach items="${objectives }" var="objective">
									<option value="${objective.getId() }">${objective.getName()}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<form:label class="form-control font-weight-bolder"
								path="task_description">Description</form:label>
						</div>
						<div class="col-md-8">
							<form:textarea path="task_description" style="min-height: 14em;"
								placeholder="Enter Description" class="form-control" />
								<hr />
						</div>
						
					</div>
					
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-8 text-right">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</div>
				<div class="col-md-6 text-center">
					<h3 class="text-secondary">Task's Objective</h3>
					<iframe id="ifrm" src="resume.pdf"
						style="width: 30em; height: 25em;"></iframe>
				</div>
			</div>
		</div>
				
	</form:form>
	<script>
     $(document).ready(function () {
         $('.selectpicker').selectpicker();
     })

    
</script>
</t:layout>