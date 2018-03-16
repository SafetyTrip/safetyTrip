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
					
					int max = 4;
					if(cList.size() < 4)
						max = cList.size();
						
					for(int i=0; i<max; i++) {
						CountryDTO cDTO = cList.get(i);
						
						if(cDTO == null)
							break;
			%>
			<div class="col-md-3">
				<div class="card mb-4 box-shadow country">
					<form action="country" method="get">
						<img class="card-img-top" src="img/country/<%= cDTO.getCouno()%>.png" />
						<div><%= cDTO.getCname()%></div>
						<div><%= cDTO.getCename()%></div>
						<input type="hidden" name="no" value="<%= cDTO.getCouno()%>" />
						<input type="hidden" name="name" value="<%= cDTO.getCname()%>" />
					</form>
				</div>
			</div>
			<%
					}
				}
			%>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('.country').click(function() {
			$(this).children("form").submit();
		});
	});
</script>