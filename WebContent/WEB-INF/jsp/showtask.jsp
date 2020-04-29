<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="role">
	<%= session.getAttribute("role") %>
</c:set>
<t:layout>
	
	<br />
	
	<form:form action=""
		modelAttribute="task">
		<form:hidden path="task_id"/>
		<div class="form-group">
			<div class="row">
				<div class="col-md-6 text-center">
				<h3 class="text-secondary">View Task</h3>
					<div class="row">
						<div class="col-md-4">
							<form:label class="form-control font-weight-bolder"
								path="task_title">Title</form:label>
						</div>
						<div class="col-md-8">
							<form:input path="task_title" disabled="true" placeholder="Enter Title"
								class="form-control" />
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-4">
							<form:label class="form-control font-weight-bolder"
								path="task_description">Description</form:label>
						</div>
						<div class="col-md-8">
							<form:textarea disabled="true" path="task_description" style="min-height: 14em;"
								placeholder="Enter Description" class="form-control" />
								<hr />
						</div>
						
					</div>
					<div class="row" id="rejection" style="display: none;">
						<div class="col-md-4">
							<form:label class="form-control font-weight-bolder"
								path="rejection_note">Rejection Note</form:label>
						</div>
						<div class="col-md-6">
							<form:textarea id="note" path="rejection_note"  placeholder="Enter Your Note"
								class="form-control" />
						</div>
						<div class="col-md-2">
						<a href="#" onclick = "return Rejection(${task.getTask_id()})" class="btn btn-danger">Reject</a>
						
						</div>
					</div>
					<c:choose>
				        <c:when test="${role == 'Work Mentor' and task.getTask_status() == 1}">
					        <div class="row" id="actions">
						        <div class="col-md-4">
									
								</div>
					            <div class="col-md-8">
					                <div class="btn-group">
					                	<a class = "btn btn-primary" href="approvetask/${ task_id}" onclick = "return confirm('Are you sure?');">Approve</a></td>
					                    
					                    <a href="#" onclick="Reject()" class="btn btn-danger">Not okay !?</a>
					                </div>
					            </div>
					        </div>		          
						</c:when>
			        </c:choose>
				</div>
				<div class="col-md-6 text-center">
					<h3 class="text-secondary">Task's Objective</h3>
					<iframe id="ifrm" src="${selectedurl }"
						style="width: 30em; height: 25em;"></iframe>
				</div>
			</div>
			
		</div>
		
		
	</form:form>
	<c:choose>
		<c:when test="${ task.getTask_status() == 2}">
	
        
	<div class="row">
            <div class="col-md-10">
                <c:choose>
                	<c:when test="${comments.size() != 0  }">
                	
                    <hr />
                    <h4>Comments</h4>
                    <ul class="timeline">
                        <c:forEach items="${comments}" var="comment">
                        
                            <li>
                                <p class="pBlue">${comment.getUserName() }</p>
                                <a href="#" class="float-right">21 March, 2014</a>
                                <p>${comment.getContent() }</p>
                            </li>
                        </c:forEach>
                    </ul>
                    
                </c:when>
                </c:choose>
                    <hr />
                <div class="form-group">
                    <div class="col-sm-10">
                        <textarea class="form-control" placeholder = "Add Comment"name="addComment" id="addComment" rows="5"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-primary btn-circle text-uppercase" onclick="AddComment(${task.getTask_id()})">Comment</button>
                    </div>
                </div>
            </div>
        </div>
        </c:when>
	</c:choose>
	
	<script>
	function Reject() {
        $("#rejection").show();
        $("#actions").hide();
    }
    function Rejection(taskID) {
        var rejectionNote = $("#note")[0].value;
        var id = taskID;
        alert(id);
        alert(rejectionNote);
        $.ajax({
            url: 'http://localhost:8080/Link-Tern/rejecttask/',
            data: { taskId: id, note: rejectionNote },
            type: "GET",
            cache: false,
            success: function (data) {
            	window.location.href ='http://localhost:8080/Link-Tern/workmentortasks';
            }
        }).fail(
            function () {
                alert("Fail");
            });
    }
     $(document).ready(function () {
         $('.selectpicker').selectpicker();
     })
     
     
     function AddComment(taskID) {

        var id = taskID;
        alert(id);
        var cmnt = $("#addComment").val();
        alert(cmnt);
        $.ajax({
        	url: 'http://localhost:8080/Link-Tern/comment/',
            data: { taskId: id, comment: cmnt },
            type: "GET",
            cache: false,
            success: function (data) {
                //window.location.href = "/Tasks/ViewTask" + "?taskId="+ data;
                location.reload();
            }
        }).fail(
            function () {
                alert("Fail");
            });
        
    };

    
</script>
</t:layout>