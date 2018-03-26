<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<div class="container" align="center">

<form id ="addUser" action="UsersAddServlet" method="post" >
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

<script type="text/javascript">	</script>
<script src ="js/addUser.js"></script>


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>

