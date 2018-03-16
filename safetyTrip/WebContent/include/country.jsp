<%@page import="com.dto.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	CountryDTO cDTO = (CountryDTO) request.getAttribute("cDTO");
%>

<div class="container">
	<div class="row">
		<p><%= cDTO.getCname()%></p>
	</div>
	<div class="row">
		<div class="col-md-6">
			<iframe height=400px width="100%" frameborder="0" style="border:0"
			  src="https://www.google.com/maps/embed/v1/search?key=AIzaSyDx8zY9GlEPzdFHI7Q4DlWgRD8t2K4mf9M&q=<%= cDTO.getCname()%>+관광+명소" allowfullscreen>
			</iframe>
			<div class="row">
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
			</div>
		</div>
	</div>	
</div>