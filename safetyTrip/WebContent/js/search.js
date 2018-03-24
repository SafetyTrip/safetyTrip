$(document).ready(function() {
	$('.panel').click(function() {
		$(this).find('form').submit();
	});
});