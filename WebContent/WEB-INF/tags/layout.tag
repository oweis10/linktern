<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="name">
	<%= session.getAttribute("name") %>
</c:set>
<c:set var="role">
	<%= session.getAttribute("role") %>
</c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>LinkTern</title>

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
</head>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<body id="page-top" onload="initMap()">
  
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="${contextPath}/home">LinkTern</a>
                <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1">
                            <a href="${contextPath}/home" class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger">Home</a>
                        </li>
						<c:choose>
                        <c:when test="${role == 'Student' }">
                        <li class="nav-item">
							    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${contextPath}/studenttasks">Tasks</a>
							</li>
						</c:when>
                        </c:choose>
                             <c:choose>
                        <c:when test="${role == 'School Mentor' }">
                        <li class="nav-item">
							    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${contextPath}/schoolmentorstudents">Students</a>
							</li>
                        <li class="nav-item">
							    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${contextPath}/schoolmentortasks">Tasks</a>
							</li>
						</c:when>
                        </c:choose>
                        
                            <c:choose>
                        <c:when test="${role == 'Work Mentor' }">
                        	<li class="nav-item">
							    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${contextPath}/workmentorstudents">Students</a>
							</li>
                        	<li class="nav-item">
							    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${contextPath}/workmentortasks">Tasks</a>
							</li>
						</c:when>
                        </c:choose>
                        <!-- (String)session.getAttribute('userRole') -->
                       <c:choose>
                       		<c:when test="${role == 'Admin' }">
                       		
							<li class="nav-item">
							    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${contextPath}/placements">Placement</a>
							</li>
							<li class="nav-item dropdown">
							    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							        Users
							    </a>
							    <div class="dropdown-menu" style="background-color: #2c3e50 !important;" aria-labelledby="navbarDropdown">
							       <a href="${contextPath}/students" class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger">Students</a>
							       <a href="${contextPath}/schoolmentors" class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger">School Mentors</a>
							       <a href="${contextPath}/workmentors" class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger">Work Mentors</a>
							    </div>
							</li>
                            </c:when>
                        </c:choose>
	                            
                    </ul>
                    <ul class="navbar-nav">
					     <li class="nav-item dropdown">
					         <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger dropdown-toggle" style="color: #1abc9c !important;" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					              ${name} <i class="fas fa-cog" style="margin-right:2px;"></i>
					         </a>
					         <div class="dropdown-menu" style="background-color: #2c3e50 !important;" aria-labelledby="navbarDropdown">
					             
					             <form class="form-inline">                 
					                 <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger text-lowercase" style="cursor: pointer;" href="${contextPath}/logout" title="Manage">
					                     Logout 
					                 </a>   
					             </form>
					         </div>
					     </li>
					</ul>
                </div>
            </div>
        </nav>
    <c:choose>
    	<c:when test="${requestScope['javax.servlet.forward.request_uri'] == '/Link-Tern/loginrequest' or  requestScope['javax.servlet.forward.request_uri'] == '/Link-Tern/home'}">
				<jsp:doBody/>
    	</c:when>
    	<c:when test="${requestScope['javax.servlet.forward.request_uri'] != '/Link-Tern/loginrequest' or  requestScope['javax.servlet.forward.request_uri'] != '/Link-Tern/home'}">
    		<div class="container" style="padding-top : 10rem; min-height: 30rem !Important;">
				<jsp:doBody/>
		    </div>
    	</c:when>
    </c:choose>
    
        <!-- Footer -->

        <footer class="footer text-center">
            <div class="container">
                <div class="row">

                    <!-- Footer Location -->
                    <div class="col-lg-4">
                        <h4 class="text-uppercase mb-4">Contact & Location</h4>
                        <p class="lead mb-0">
                            Amman - King Hussein Business Park
                            <br>LinkTern, +962 6 580 8787
                        </p>
                    </div>

                    <!-- Footer Social Icons -->
                    <div class="col-lg-4">
                        <h4 class="text-uppercase mb-4">Around the Web</h4>
                        <a class="btn btn-outline-light btn-social mx-1" target="#" href="https://www.facebook.com/khaled.oweis/">
                            <i class="fab fa-fw fa-facebook-f"></i>
                        </a>
                        <a class="btn btn-outline-light btn-social mx-1" target="#" href="">
                            <i class="fab fa-fw fa-twitter"></i>
                        </a>
                        <a class="btn btn-outline-light btn-social mx-1" target="#" href="#">
                            <i class="fab fa-fw fa-linkedin-in"></i>
                        </a>
                        <a class="btn btn-outline-light btn-social mx-1" target="#" href="https://www.instagram.com/lina.sabbahin/">
                            <i class="fab fa-fw fa-instagram"></i>
                        </a>
                    </div>

                    <!-- Footer About Text -->

                    <div class="col-lg-4" style="overflow:visible !important" id="map"></div>

                </div>
            </div>
        </footer>

        <!-- Copyright Section -->
        <section class="copyright py-4 text-center text-white">
            <div class="container">
                <small>Copyright &copy; Your Website 2019</small>
            </div>
        </section>
    <!-- Bootstrap core JavaScript -->
    <script>
    	<%@include file="/wwwroot/vendor/jquery/jquery.min.js" %>
    	<%@include file="/wwwroot/vendor/bootstrap/js/bootstrap.bundle.min.js" %>
    	<%@include file="/wwwroot/vendor/jquery-easing/jquery.easing.min.js" %>
    </script>


    <link  href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" rel="stylesheet" type="text/css"  >
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css.map" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" >
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
   
    
	
   
   <script>
   <%@include file="/wwwroot/js/popper.min.js" %>
   <%@include file="/wwwroot/js/modules/bs-custom-file-input.js" %>
   </script>
    <script src="https://kit.fontawesome.com/ec0f235872.js" crossorigin="anonymous"></script>
    <script>
    <%@include file="/wwwroot/js/freelancer.min.js" %>
    <%@include file="/wwwroot/temp/lib/jquery-validation/dist/jquery.validate.js" %>
    <%@include file="/wwwroot/temp/lib/jquery-validation-unobtrusive/jquery.validate.unobtrusive.js" %>
    </script>
	<script>
	    $(document).ready(function () {
	        $('.selectpicker').selectpicker();
	        $('.datepicker').datepicker();
	    })
	
	    
	</script>
    <script>
        var map;
        function initMap() {
            // The location of Uluru

            var uluru = { lat: 31.9724281, lng: 35.8325012 };

            // The map, centered at Uluru

            var map = new google.maps.Map(

                document.getElementById('map'), { zoom: 13, center: uluru });

            // The marker, positioned at Uluru

            var marker = new google.maps.Marker({ position: uluru, map: map });


        }
    </script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB4JJi1z7RC26-fAgUKQ5V3s_hWj_-vd1U&callback=initMap">
    </script>
    <script>
        $(document).ready(function () {
        	
            var dropdown = $('#obj');
            	
            dropdown.on('change', function () {
                var objective = dropdown.val();
                
                $.ajax({
                    type: 'GET',
                    url: 'http://localhost:8080/Link-Tern/getobjectiveurl/'+objective,
                    
                    contentType: 'application/json', // this
                    datatype: 'json',
                    success: function (data) {
                        $('#ifrm').attr('src', data)
                    }
                });
            });
        });

    </script>
    <script>
        $("#logoutbtn").click(function () {
            $("#logOut").submit();
            return false;
        });
    </script>


	<script>
	<%@include file="/wwwroot/temp/js/site.js" %>
	</script>

</body>
</html>