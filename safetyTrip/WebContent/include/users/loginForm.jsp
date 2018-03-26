<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
  <div class="row">
    <div class="main">
	  <h3>Please Log In, or <a href="#">Sign Up</a></h3>
      <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6">
          <a href="#" class="btn btn-lg btn-primary btn-block">Facebook</a>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6">
          <a href="#" class="btn btn-lg btn-info btn-block">Google</a>
        </div>
      </div>
      <div class="login-or">
        <hr class="hr-or">
        <span class="span-or">or</span>
      </div>

      <form id="login_js" action="LoginServlet" method="post">
        <div class="form-group">
          <label for="userid">Userid</label>
          <input type="text" class="form-control" name="userid" id="userid">
        </div>
        <div class="form-group">
          <a class="pull-right" href="#">Forgot password?</a>
          <label for="passwd">Password</label>
          <input type="password" class="form-control" name="passwd" id="passwd">
        </div>
        <div class="checkbox pull-right">
          <label>
            <input type="checkbox">
            Remember me </label>
        </div>
        <button type="submit" class="btn btn btn-primary">
          Log In
        </button>
      </form>
    
    </div>
    
  </div>
</div>

