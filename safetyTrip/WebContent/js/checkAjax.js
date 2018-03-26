function checkAjax(sendType, sendData) {
	console.log(sendData);
	$.ajax({
		type : "get",
		url : "UsersCkeckServlet",
		data : {

			sendType : sendType,
			sendData : sendData
		},
		dataType : "text",
		success : function(data) {
			alert(data);
			return data;
		}
	});
}
$("#idcheck").click("submit",function() {
	value = checkAjax("userid", $("#userid").val());
});

$("#idcheck2").click("submit",function(){
	b = checkAjax("email", $("#email").val());
});

$("#idcheck3").click("submit",function() {
	c = checkAjax("uname", $("#uname").val());
});
