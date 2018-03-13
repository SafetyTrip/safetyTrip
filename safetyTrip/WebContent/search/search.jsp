<%@page import="com.dto.CountryDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<form class="input-group mt-12 mt-md-12" action="search" method="get">
	            <input class="form-control" name="word" type="text" placeholder="Search" aria-label="Search">
	            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	          </form>
		</div>
	</div>	
</div>

<div class="container py-5">
	<div class="row">
		<p>COUNTRY</p>
	</div>
	<div class="row">
			<% 
				Object cObject = request.getAttribute("cList");
				if(cObject != null && cObject instanceof List<?>) {
					
					@SuppressWarnings("unchecked")
					List<CountryDTO> cList = (List<CountryDTO>) cObject;
					
					for(CountryDTO cDTO: cList) {
			%>
			<div class="col-md-3">
				<div class="card mb-4 box-shadow">
					<img class="card-img-top" src="img/country/<%= cDTO.getCouno()%>.png" />
					<div><%= cDTO.getCname()%></div>
					<div><%= cDTO.getCename()%></div>
				</div>
			</div>
			<%
					}
				}
			%>
	</div>
</div>