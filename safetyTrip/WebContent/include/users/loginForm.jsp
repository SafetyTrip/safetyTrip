<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
<script src ="js/login.js"></script>
<div class="container" align="center">
	<form id="login_js" action="LoginServlet" method="post" >
		아이디<input type="text" name="userid" id="userid"><br> 
		비밀번호<input type="password" name="passwd" id="passwd"><br> 
		<input type="submit" value="로그인"> 
		<input type="reset" value="취소">
	</form>
</div>

