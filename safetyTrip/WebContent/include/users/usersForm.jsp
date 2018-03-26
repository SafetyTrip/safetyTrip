<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<div class="container">

<form id="addUser" class="form-horizontal" action="usersAdd" method="post" >
	<div class="form-group">
		<label class="col-md-4 control-label" for="userid">아이디</label>  
		<div class="col-md-3">
		  <input id="userid" name="userid" type="text" placeholder="userid" class="form-control input-md">
		</div>
		<button type="button" id="idcheck" class="btn btn-default" name="idcheck" value="0">중복 확인</button>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="passwd">비밀번호</label>  
		<div class="col-md-3">
		  <input id="passwd" name="passwd" type="password" placeholder="password" class="form-control input-md">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="passwd_check">비밀번호 확인</label>  
		<div class="col-md-3">
		  <input id="passwd_check" name="passwd_check" type="password" placeholder="passwd_check" class="form-control input-md">
		</div>
		<div id="passwd_check_div"></div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="email">이메일</label>  
		<div class="col-md-3">
		  <input id="email" name="email" type="email" placeholder="email" class="form-control input-md">
		</div>
		<button type="button" id="idcheck2" class="btn btn-default" name="idcheck2" value="0">중복 확인</button>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="uname">닉네임</label>  
		<div class="col-md-3">
		  <input id="uname" name="uname" type="text" placeholder="uname" class="form-control input-md">
		</div>
		<button type="button" id="idcheck3" class="btn btn-default" name="idcheck3" value="0">중복 확인</button>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="name">실명</label>  
		<div class="col-md-3">
		  <input id="name" name="name" type="text" placeholder="name" class="form-control input-md">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="passport">여권 번호</label>  
		<div class="col-md-3">
		  <input id="passport" name="passport" type="text" placeholder="passport" class="form-control input-md">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="sex">성별</label>  
		<div class="col-md-3 radio">
		  <label>
		    <input type="radio" id ="sex" name= "sex" value="M">남
		  </label>
		  <label>
		    <input type="radio" id ="sex" name= "sex" value="F">여
		  </label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="birth">생년월일</label>  
		<div class="col-md-3">
		  <input id="birth" name="birth" type="text" placeholder="19901010" class="form-control input-md">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4 control-label" for="birth">주소</label>  
		<div class="col-md-3">
		  <input type="text" name="post" id="sample6_postcode" placeholder="우편번호" class="form-control input-md">
		</div>
		<input type="button" onclick="sample6_execDaumPostcode()" class="btn btn-default" value="우편번호 찾기">
	</div>
	<div class="form-group">
		<label class="col-md-4"></label>
		<div class="col-md-5">
		  <input type="text" name="address1" id="sample6_address" placeholder="주소" class="form-control input-md">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-4"></label>
		<div class="col-md-5">
		  <input type="text" name="address2" id="sample6_address2" placeholder="상세주소" class="form-control input-md">
		</div>
	</div>
	<div class="form-group" align="center">
		<input type="submit" value="회원가입" class="btn btn-default">
		<input type="reset" value="취소" class="btn btn-default">
	</div>
</form>
</div>



