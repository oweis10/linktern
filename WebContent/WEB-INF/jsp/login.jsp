<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="loginForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LinkTern - Login</title>
 <!-- Custom fonts for this theme -->
    <style type="text/css">
    	<%@include file="/wwwroot/vendor/fontawesome-free/css/all.min.css" %>
	</style>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    
    <style type="text/css">
    	<%@include file="/wwwroot/css/bootstrapnew.min.css" %>
	</style>
    
    <style type="text/css">
    	<%@include file="/wwwroot/temp/css/site.css" %>
	</style>
	
	<style type="text/css">
	<%@include file="/wwwroot/css/logIn.css" %>
	</style>
</head>

<body>
<div class="row no-gutter">
        <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
        <div class="col-md-8 col-lg-6">
            <div class="login d-flex align-items-center py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9 col-lg-8 mx-auto">
                        	<h5><font class="text-danger"> ${invalid} </font></h5>
                            <h3 class="login-heading mb-4 text-center">LinkTern</h3>
                            <loginForm:form action="${contextPath}/loginrequest" method="post" modelAttribute="user">
                                <div class="form-label-group">
                                    <loginForm:input placeholder="Enter email"  required = "true" path="Email" type="email" class="form-control"/>
                                    
                                    <span class="text-danger"></span>
                                </div>

                                <div class="form-label-group">
                                    <loginForm:input path="password" placeholder="Enter password" type="Password" class="form-control"/>
                                    <span class="text-danger">
                                    	<spring:hasBindErrors name="user">
											<c:forEach var="error" items="${errors.allErrors}">
												<b><spring:message message="${error}" /></b>
												<br />
											</c:forEach>
									    </spring:hasBindErrors>
                                    </span>
                                </div>
                                
                                <loginForm:errors class="text-danger" path="*"><span></span></loginForm:errors>

<!--                                 <div class="custom-control custom-checkbox mb-3"> -->
<!--                                     <input type="checkbox" class="custom-control-input"> -->
<!--                                     <label class="custom-control-label" for="customCheck1">Remember password</label> -->
<!--                                 </div> -->
                                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Sign in</button>
<!--                                 <div class="text-center"> -->
<!--                                     <a class="small" id="forgot-password" >Forgot password?</a> -->
<!--                                 </div> -->
                            </loginForm:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
     <!-- Bootstrap core JavaScript -->
    <script>
    	<%@include file="/wwwroot/vendor/jquery/jquery.min.js" %>
    	<%@include file="/wwwroot/vendor/bootstrap/js/bootstrap.bundle.min.js" %>
    	<%@include file="/wwwroot/vendor/jquery-easing/jquery.easing.min.js" %>
    </script>
<%--     <script href="<c:url value="/wwwroot/vendor/jquery/jquery.min.js" />"></script> --%>
<%--     <script href="<c:url value="/wwwroot/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script> --%>

<!--     Plugin JavaScript -->
<%--     <script href="<c:url value="/wwwroot/vendor/jquery-easing/jquery.easing.min.js" />"></script> --%>

    
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
   
   
   <script>
   <%@include file="/wwwroot/js/popper.min.js" %>
   <%@include file="/wwwroot/js/modules/bs-custom-file-input.js" %>
   </script>
    <script src="https://kit.fontawesome.com/ec0f235872.js"></script>
    <script>
    <%@include file="/wwwroot/js/freelancer.min.js" %>
    <%@include file="/wwwroot/temp/lib/jquery-validation/dist/jquery.validate.js" %>
    <%@include file="/wwwroot/temp/lib/jquery-validation-unobtrusive/jquery.validate.unobtrusive.js" %>
    </script>

    <script>
	<%@include file="/wwwroot/temp/js/site.js" %>
	</script>
</body>
</html>