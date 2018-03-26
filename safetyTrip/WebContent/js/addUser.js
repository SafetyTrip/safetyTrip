var idcheck = null;
var idcheck2 = null;
var idcheck3 = null;

$(document).ready(function(){
	$("#addUser").submit(function(){
	 if($("#userid").val()==""){
		 alert("아이디를 입력해주세요");
		 return false;
	 }						 
	 if($("#email").val()==""){
		 alert("이메일을 입력해주세요");
		 return false;
	 }
	 if($("#name").val()==""){
		 alert("이름을 입력해주세요");
		 return false;
	 }				 
	 if($("#passport").val()==""){
		 alert("여권번호을 입력해주세요");
		 return false;
	 }
	 if(!$(':input:radio[name=sex]:checked').val()){					 
		 alert("성별을 입력해주세요");
		 return false;
	 }
	 if($("#birth").val()==""){
		 alert("생년월일을 입력해주세요");
		 return false;
	 }
	 if($("#sample6_postcode").val()==""){
		 alert("주소를 입력해주세요");
		 return false;
	 }
	 if(idcheck != "아이디 사용 가능"){
		 alert("아이디 중복체크해주세요!!");
		 return false;
	 }
	 if(idcheck2 != "이메일 사용 가능"){
		 alert("이메일 중복체크해주세요!!");
		 return false;
	 }
	 if(idcheck3 != "닉네임 사용 가능"){
		 alert("닉네임 중복체크해주세요!!");
		 return false;
	 }
	 		alert("회원 등록 성공 ");
	});
	
	$("#idcheck").click("submit",function() {
		idcheck = checkAjax("userid", $("#userid").val());
	});

	$("#idcheck2").click("submit",function(){
		idcheck2= checkAjax("email", $("#email").val());
	});

	$("#idcheck3").click("submit",function() {
		idcheck3 = checkAjax("uname", $("#uname").val());
	});
});
 
$("#passwd_check").keyup(function() {
	if ($("#passwd").val() != $("#passwd_check").val()) {
		$("#passwd_check_div").text("암호불일치");
		console.log("암호불");
	} else {
		$("#passwd_check_div").text("암호 일치");
		console.log("암호  일치");
	}
});
 
 
 function checkAjax(sendType, sendData) {
	 var returnData = null;
		$.ajax({
			type : "get",
			url : "UsersCkeckServlet",
			data : {
				sendType : sendType,
				sendData : sendData
			},
			dataType : "text",
			async: false,
			success : function(data) {
				alert(data);
				returnData = data;
			}
		});
		
		return returnData;
	}


