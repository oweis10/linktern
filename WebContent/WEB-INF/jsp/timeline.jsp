<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<c:set var="role">
	<%= session.getAttribute("role") %>
</c:set>
<c:set var="left" value="false"/>
<c:set var="counter" value="${1}" scope="page" />

<t:layout>
	
	<br />
	<div class="container py-2">
		<c:choose>
		   	<c:when test="${tasks.size() != 0  }">
		   		<c:forEach items="${tasks}" var="task">
		   			<div class="row no-gutters">
		   				<c:choose>
		   				<c:when test="${left == false }">
		                	<div class="col-sm py-2">
			                	 <c:choose>
	                             	<c:when test="${task.getTask_status() == 2 }">                          
		                                <div class="card border-success shadow">
		                                    <div class="card-body">
		                                        <div class="float-right text-success small">${taskDate }</div>
		                                        <h4 class="card-title text-success">${task.getTask_title() }</h4>
		                                        <h6 class="card-title text-success">Approved </h6>
		                                        <p class="card-text">${task.getTask_description() }</p>
		                                        <button class="btn btn-sm btn-outline-secondary" type="button" data-target="#t22_details_${counter}" data-toggle="collapse">Show Details ▼</button>
		                                        <div class="collapse border" id="t22_details_${counter}">
		                                            <div class="p-2 text-monospace">
		                                            	<div><a target="_blank" href="https://www.google.com"></a></div>
		                                            </div>
		                                        </div>
		                                    </div>
		                                </div>
		                                <c:set var="counter" value="${counter + 1}" scope="page"/>
	                                </c:when>  
	                              </c:choose>
	                            <c:choose>
	                            	<c:when test="${task.getTask_status() == 1 }">
	                            	
	                                <div class="card border-info shadow">
	                                    <div class="card-body">
	                                        <div class="float-right text-info small">${taskDate }</div>
		                                        <h4 class="card-title text-info">${task.getTask_title() }</h4>
		                                        <h6 class="card-title text-info">Pending</h6>
		                                        <p class="card-text">${task.getTask_description() }</p>
	                                        <button class="btn btn-sm btn-outline-secondary" type="button" data-target="#t22_details_${counter}" data-toggle="collapse">Show Details ▼</button>
	                                        <div class="collapse border" id="t22_details_${counter}">
	                                            <div class="p-2 text-monospace">
	                                                <div><a target="_blank" href="https://www.google.com"></a></div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                                <c:set var="counter" value="${counter + 1}" scope="page"/>
	                            	</c:when>
	                            </c:choose>
	                            <c:choose>
	                            
	                            	<c:when test="${task.getTask_status() == 3 }">
	                            	
	                                <div class="card border-danger shadow">
	                                    <div class="card-body">
	                                        <div class="float-right text-danger small">${taskDate }</div>
		                                        <h4 class="card-title text-danger">${task.getTask_title() }</h4>
		                                        <h6 class="card-title text-danger">Rejected</h6>
		                                        <p class="card-text">${task.getTask_description() }</p>
	                                        <button class="btn btn-sm btn-outline-secondary" type="button" data-target="#t22_details_${counter}" data-toggle="collapse">Show Details ▼</button>
	                                        <div class="collapse border" id="t22_details_${counter}">
	                                            <div class="p-2 text-monospace">
	                                                <div><a target="_blank" href="https://www.google.com"></a></div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                                <c:set var="counter" value="${counter + 1}" scope="page"/>
	                            </c:when>
	                        </c:choose>
		                	</div>
		                	<div class="col-sm-1 text-center flex-column d-none d-sm-flex">
	                            <div class="row h-50">
	                                <div class="col border-right">&nbsp;</div>
	                                <div class="col">&nbsp;</div>
	                            </div>
	                            <c:choose>
	                            	<c:when test="${task.getTask_status() == 2 }">
		                                <h5 class="m-2">
		                                    <span class="badge badge-pill bg-success">&nbsp;</span>
		                                </h5>
	                                </c:when>
	                            </c:choose>
	                            <c:choose>
	                            	<c:when test="${task.getTask_status() == 1 }">
		                                <h5 class="m-2">
		                                    <span class="badge badge-pill bg-info">&nbsp;</span>
		                                </h5>
	                                </c:when>
	                            </c:choose>
	                            <c:choose>
	                            	<c:when test="${task.getTask_status() == 3 }">
		                                <h5 class="m-2">
		                                    <span class="badge badge-pill bg-danger">&nbsp;</span>
		                                </h5>
	                                </c:when>
	                            </c:choose>
	                            <div class="row h-50">
	                                <div class="col border-right">&nbsp;</div>
	                                <div class="col">&nbsp;</div>
	                            </div>
                        	</div>
		                	<div class="col-sm"> <!--spacer--> </div>
                        	
                        	</c:when>
		   				</c:choose>
		   				<c:choose>
		   				<c:when test="${left == true }">
		   					<div class="col-sm"> <!--spacer--> </div>
		   					<div class="col-sm-1 text-center flex-column d-none d-sm-flex">
	                            <div class="row h-50">
	                                <div class="col border-right">&nbsp;</div>
	                                <div class="col">&nbsp;</div>
	                            </div>
	                            <c:choose>
	                            	<c:when test="${task.getTask_status() == 2 }">
		                                <h5 class="m-2">
		                                    <span class="badge badge-pill bg-success">&nbsp;</span>
		                                </h5>
	                                </c:when>
	                            </c:choose>
	                            <c:choose>
	                            	<c:when test="${task.getTask_status() == 1 }">
		                                <h5 class="m-2">
		                                    <span class="badge badge-pill bg-info">&nbsp;</span>
		                                </h5>
	                                </c:when>
	                            </c:choose>
	                            <c:choose>
	                            	<c:when test="${task.getTask_status() == 3 }">
		                                <h5 class="m-2">
		                                    <span class="badge badge-pill bg-danger">&nbsp;</span>
		                                </h5>
	                                </c:when>
	                            </c:choose>
	                            <div class="row h-50">
	                                <div class="col border-right">&nbsp;</div>
	                                <div class="col">&nbsp;</div>
	                            </div>
                        	</div>
                        	<div class="col-sm py-2">
			                	 <c:choose>
	                             	<c:when test="${task.getTask_status() == 2 }">                          
		                                <div class="card border-success shadow">
		                                    <div class="card-body">
		                                        <div class="float-right text-success small">${taskDate }</div>
		                                        <h4 class="card-title text-success">${task.getTask_title() }</h4>
		                                        <h6 class="card-title text-success">Approved</h6>
		                                        <p class="card-text">${task.getTask_description() }</p>
		                                        <button class="btn btn-sm btn-outline-secondary" type="button" data-target="#t22_details_${counter}" data-toggle="collapse">Show Details ▼</button>
		                                        <div class="collapse border" id="t22_details_${counter}">
		                                            <div class="p-2 text-monospace">
		                                            	<div><a target="_blank" href="https://www.google.com"></a></div>
		                                            </div>
		                                        </div>
		                                    </div>
		                                </div>
		                                <c:set var="counter" value="${counter + 1}" scope="page"/>
	                                </c:when>  
	                              </c:choose>
	                            <c:choose>
	                            	<c:when test="${task.getTask_status() == 1 }">
	                            	
	                                <div class="card border-info shadow">
	                                    <div class="card-body">
	                                        <div class="float-right text-info small">${taskDate }</div>
		                                        <h4 class="card-title text-info">${task.getTask_title() }</h4>
		                                        <h6 class="card-title text-info">Pending</h6>
		                                        <p class="card-text">${task.getTask_description() }</p>
	                                        <button class="btn btn-sm btn-outline-secondary" type="button" data-target="#t22_details_${counter}" data-toggle="collapse">Show Details ▼</button>
	                                        <div class="collapse border" id="t22_details_${counter}">
	                                            <div class="p-2 text-monospace">
	                                                <div><a target="_blank" href="https://www.google.com"></a></div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                                <c:set var="counter" value="${counter + 1}" scope="page"/>
	                            	</c:when>
	                            </c:choose>
	                            <c:choose>
	                            
	                            	<c:when test="${task.getTask_status() == 3 }">
	                            	
	                                <div class="card border-danger shadow">
	                                    <div class="card-body">
	                                        <div class="float-right text-danger small">${taskDate }</div>
		                                        <h4 class="card-title text-danger">${task.getTask_title() }</h4>
		                                        <h6 class="card-title text-danger">Rejected</h6>
		                                        <p class="card-text">${task.getTask_description() }</p>
	                                        <button class="btn btn-sm btn-outline-secondary" type="button" data-target="#t22_details_${counter}" data-toggle="collapse">Show Details ▼</button>
	                                        <div class="collapse border" id="t22_details_${counter}">
	                                            <div class="p-2 text-monospace">
	                                                <div><a target="_blank" href="https://www.google.com"></a></div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                                <c:set var="counter" value="${counter + 1}" scope="page"/>
	                            </c:when>
	                        </c:choose>
		                	</div>
		                	<c:set var="left" value="${ false} " scope="page"/>
		   				</c:when>
		   				</c:choose>
		   				<c:choose>
		   					<c:when test="${left eq 'false'}">
		   						<c:set var="left" value="${true }" scope="page"/>
		   					</c:when>
		   				</c:choose>
	                </div> 
		   		</c:forEach>
		   	
		   	</c:when>
		   	<c:when test="${tasks.size() == 0  }">
		   		<h2>There is no taks to view !</h2>
		   	</c:when>
	   	</c:choose>
   	</div>
</t:layout>