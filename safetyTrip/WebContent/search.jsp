<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="img/main/SafetyTrip.png">
	<!-- Title -->
    <title>SafetyTrip Main</title>
    <!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <!-- CSS -->
    <link href="css/main.css" rel="stylesheet">
    <link href="css/search.css" rel="stylesheet">
    <!-- jQuery file -->
    <script src="js/jquery-3.3.1.min.js"></script>
  </head>

  <body>
  	<jsp:include page="include/majorMain/mainNav.jsp" flush="true" />
	<jsp:include page="include/search.jsp" flush="true" />
	<jsp:include page="include/majorMain/mainFooter.jsp" flush="true" />
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="js/search.js"></script>
  </body>
</html>
