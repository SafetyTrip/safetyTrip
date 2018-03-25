$(document).ready(function() {
	$('.safety-tr').click(function() {
		var sno = $(this).find('.sno').val();
		location.href = 'safety?sno=' + sno;
	});
});