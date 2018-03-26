<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/main/SafetyTrip.png">

	<!-- Title -->
    <title>SafetyTrip Main</title>

    <!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <!-- CSS -->
    <link href="css/main.css" rel="stylesheet">
    <!-- jQuery file -->
    <script src="js/jquery-3.3.1.min.js"></script>
  </head>

  <body>
	<jsp:include page ="include/majorMain/mainNav.jsp" flush ="true" />
	<jsp:include page ="include/users/usersForm.jsp" flush ="true" />
	<jsp:include page="include/majorMain/mainFooter.jsp" flush="true" /><br>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src ="js/daum-api.js"></script>
	<script src ="js/addUser.js"></script>
  </body>
  
</html>
