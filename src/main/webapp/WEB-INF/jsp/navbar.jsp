<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
	<script>
		window.userRole = '${userModel.role}';
	</script>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
               
                <a class="navbar-brand" href="${pageContext.request.contextPath}/welcome">Online Food Ordering</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                 <security:authorize access="hasAuthority('ROLE_USER')">
                   <li id="listMenu">
                        <a href="${pageContext.request.contextPath}/viewMenu">View Menu</a>
                    </li>
                    <li id="about" >
                        <a href="${pageContext.request.contextPath}/about">About Us</a>
                    </li>

                    <li id="contact">
                        <a href="${pageContext.request.contextPath}/contact">Contact Us</a>
                    </li>
                    </security:authorize>
                    <security:authorize access="hasAuthority('ROLE_ADMIN')">
	                    <li id="menuMgt">
	                        <a href="${pageContext.request.contextPath}/admin/menuManagement">Menu Management</a>
	                    </li>
	                    <li id="empMgt">
	                        <a href="${pageContext.request.contextPath}/admin/employeeManagement">Employee Management</a>
	                    </li>		
	                    <li id="reportMgt">
	                        <a href="${pageContext.request.contextPath}/admin/reportManagement">Report Management</a>
	                    </li>			
					</security:authorize>
                </ul>
			    
			    <ul class="nav navbar-nav navbar-right">
			    	<security:authorize access="isAnonymous()">
	                    <li id="signup">
	                        <a href="${pageContext.request.contextPath}/membership">Sign Up</a>
	                    </li>
						<li id="login">
	                        <a href="${pageContext.request.contextPath}/login">Login</a>
	                    </li> 			    	
			    	</security:authorize>
			    </ul>	
			    	<li id="logout">
		                        <a href="${pageContext.request.contextPath}/logout">Logout</a>
		            </li>                    			    	
						  	
						                  
			    </ul>                
                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
