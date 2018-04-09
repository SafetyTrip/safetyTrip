
<!-- Main navbar -->
    <%@page import="com.dto.UsersDTO"%>
<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="main">Safety Trip</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse navbar-right">
          <ul class="nav navbar-nav">
          <%
			UsersDTO dto = (UsersDTO)session.getAttribute("login");
			if(dto == null){
			
		  %>
            <li><a href="login">Sign-In</a></li>
            <li><a href="signup">Sign-Up</a></li>
          <%
			} else{
		  %>
		  	<li><a href="#">MyPage</a></li>
            <li><a href="LogOutServlet">Sign-Out</a></li>
		  <%
			} 
		  %>
            <li><a href="#">QnA</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
