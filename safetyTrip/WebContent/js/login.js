$(document).ready(function() {
	$("#login_js").submit(function() {
		if ($("#userid").val() == "") {
			alert("아이디를 입력해주세요");
			return false;
		}
		if ($("#passwd").val() == "") {
			alert("비밀번호를 입력해주세요");
			return false;
		}
	});

});



