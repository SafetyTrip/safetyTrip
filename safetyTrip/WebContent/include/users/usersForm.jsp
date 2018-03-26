<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<div class="container" align="center">

<form id ="addUser" action="usersAdd" method="post" >
userid<input type="text" id ="userid" name= "userid"  >
<button type="button" id="idcheck" name="idcheck" value="0">중복확인</button><br>
passwd<input type="password" id="users_passwd" name= "passwd"  onkeyup="passwd_check" ><br>
passwd2<input type="password" id="passwd_check" name= "passwd2"  >
<span id="passwd_check_div"></span><br>
e-mail<input type="text" id="email" name= "email" >
<button type="button" id="idcheck2"  name="idcheck2" value="0">중복확인</button><br>
uname<input type="text" id ="uname" name="uname" >
<button type="button" id="idcheck3"name="idcheck3" value="0">중복확인</button><br>
name<input type="text" id ="name" name= "name" ><br>
passport<input type="text" id ="passport" name= "passport"><br>
sex<input type="radio" id ="sex" name= "sex" value="M">남 
<input type="radio" id ="sex" name="sex" value="F">여<br>
birth<input type="text" id ="birth" name= "birth" ><br>

<input type="text" name="post" id="sample6_postcode" placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="address1" id="sample6_address" placeholder="주소">-
<input type="text" name="address2" id="sample6_address2" placeholder="상세주소"><br><br>

<input type="submit" value="회원가입">
<input type="reset" value="취소">
</form>
</div>



