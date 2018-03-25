<%@page import="com.dto.SafetyDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	SafetyDTO sDTO = (SafetyDTO) request.getAttribute("sDTO");
%>

<div class="container">
	<div class="jumbotron">
        <h3><%= sDTO.getTitle()%></h3>
        <p><%= sDTO.getContent()%></p>
    </div>
	<div class="row">
		
	</div>
</div>