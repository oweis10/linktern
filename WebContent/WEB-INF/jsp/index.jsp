<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.linktern.Models.User" %>
<% User user = (User)session.getAttribute("user"); 
		String name = user.getFirstName();
	%>
 <c:set var="name">
    <%= user.getFirstName()%>
</c:set>

<t:layout>
  <header class="masthead bg-primary text-white text-center">
    <div class="container d-flex align-items-center flex-column">

        <!-- Masthead Avatar Image -->
        <img class="masthead-avatar mb-5" src="${pageContext.request.contextPath}/wwwroot/img/logo.png" alt="">

        <!-- Masthead Heading -->
        <h1 class="masthead-heading text-uppercase mb-0">LinkTern</h1>
        <!-- Icon Divider -->
        <div class="divider-custom divider-light">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-icon">
                <i class="fas fa-star"></i>
            </div>
            <div class="divider-custom-line"></div>
        </div>

        <!-- Masthead Subheading -->
        <p class="masthead-subheading font-weight-light mb-0">Training Program</p>

    </div>
</header>
<section class="bg-light page-section" id="team">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading text-uppercase">Our Amazing Team</h2>
                <h3 class="section-subheading text-muted">Teamwork divided the task and multiplies the success.</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="${pageContext.request.contextPath}/wwwroot/img/team/linkternlina.jpg" alt="">
                    <h4>Lina Sabbahin</h4>
                    <p class="text-muted">Database Administrator</p>
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item">
                            <a href="#">
                                <i class="fab fa-twitter"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a href="https://www.facebook.com/linasabbahin">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a href="#">
                                <i class="fab fa-linkedin-in"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="${pageContext.request.contextPath}/wwwroot/img/team/linkternkhaled.jpg" alt="">
                    <h4>Khaled Oweis</h4>
                    <p class="text-muted">Software Engineer</p>
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item">
                            <a href="#">
                                <i class="fab fa-twitter"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a href="https://www.facebook.com/khaled.oweis/">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a href="#">
                                <i class="fab fa-linkedin-in"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="${pageContext.request.contextPath}/wwwroot/img/team/linkternyogit.jpg" alt="">
                    <h4>Yogita Chittoria</h4>
                    <p class="text-muted">Team Leader</p>
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item">
                            <a href="#">
                                <i class="fab fa-twitter"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a href="https://www.facebook.com/yogita.chittoria.7">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a href="#">
                                <i class="fab fa-linkedin-in"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 mx-auto text-center">
<!--                 <p class="large text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos non quis ad perspiciatis, totam corporis ea, alias ut unde.</p> -->
            </div>
        </div>
    </div>
</section>
  
    
</t:layout>