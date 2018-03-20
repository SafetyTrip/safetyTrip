<%@page import="com.dto.CountryDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
		  <form action="search" method="get">
	         <input class="form-control col-md-8" name="word" type="text" placeholder="Search" aria-label="Search">
	       </form>
	   	</div>
   </div>
   
   <div class="row">
		<h3>COUNTRY</h3>
		<div class="row">
			<% 
				Object cObject = request.getAttribute("cList");
				if(cObject != null && cObject instanceof List<?>) {
					
					@SuppressWarnings("unchecked")
					List<CountryDTO> cList = (List<CountryDTO>) cObject;
					
					for(int i=0; i<cList.size(); i++) {
						CountryDTO cDTO = cList.get(i);
						
						if(cDTO == null)
							break;
			%>
			<div class="col-sm-3">
	          <div class="panel panel-default">
	            <div class="panel-heading">
	              <h3 class="panel-title">
	              	<%= cDTO.getCname()%> (<%= cDTO.getCename()%>)
	              </h3>
	            </div>
	            <div class="panel-body">
	              <img src="img/country/<%= cDTO.getCouno()%>.png" style="height: 100px;" />
	              <form action="country" method="get">
	              	<input type="hidden" name="no" value="<%= cDTO.getCouno()%>" />
	              	<input type="hidden" name="name" value="<%= cDTO.getCname()%>" />
	              </form>
	            </div>
	          </div>
	        </div>
			<%
					}
				}
			%>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('.panel').click(function() {
			$(this).find("form").submit();
		});
	});
</script>