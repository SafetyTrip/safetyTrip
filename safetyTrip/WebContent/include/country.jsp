<%@page import="java.util.List"%>
<%@page import="com.dto.SafetyDTO"%>
<%@page import="com.dto.CountryDTO"%>
<%@page import="com.dto.ReviewDTO"%>
<%@page import="com.dto.HotelDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	CountryDTO cDTO = (CountryDTO) request.getAttribute("cDTO");
	List<SafetyDTO> sList = (List<SafetyDTO>) request.getAttribute("sList");
	List<HotelDTO> hList = (List<HotelDTO>) request.getAttribute("hList");
	List<ReviewDTO> rList = (List<ReviewDTO>) request.getAttribute("rList");
%>

<div class="container">
	<div class="row">
		<h3><%= cDTO.getCname()%></h3>
	</div>
	<div class="row">
		<div class="col-md-6">
			<iframe height=400px width="100%" frameborder="0" style="border:0"
			  src="https://www.google.com/maps/embed/v1/search?key=AIzaSyDx8zY9GlEPzdFHI7Q4DlWgRD8t2K4mf9M&q=<%= cDTO.getCname()%>+관광+명소" allowfullscreen>
			</iframe>
			<div class="table-responsive">
				<h4>인근 호텔</h4>
	            <table class="table table-striped">
	              <thead>
	                <tr>
	                  <th>#</th>
	                  <th>Hotel</th>
	                  <th>Good</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<%
	              		if(hList != null) {
	              			for(int i=0; i<hList.size(); i++) {
	              	%>
	                <tr class="hotel-tr pointer">
	                  <td>
	                  	<%= i+1%>
	                  	<input type="hidden" class="hno" value="<%= hList.get(i).getHno()%>">
	                  </td>
	                  <td><%= hList.get(i).getHname()%></td>
	                  <td><%= hList.get(i).getGood()%></td>
	                </tr>
	                <%
	              			}
	              		}
	                %>
	              </tbody>
	            </table>
			</div>
		</div>
		<div class="col-md-6">
			<div class="table-responsive">
				<h4>안전 정보</h4>
	            <table class="table table-striped">
	              <thead>
	                <tr>
	                  <th>#</th>
	                  <th>Title</th>
	                  <th>Date</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<%
	              		if(sList != null) {
	              			for(int i=0; i<sList.size(); i++) {
	              	%>
	                <tr class="safety-tr pointer">
	                  <td>
	                  	<%= i+1%>
	                  	<input type="hidden" class="sno" value="<%= sList.get(i).getSno()%>">
	                  </td>
	                  <td><%= sList.get(i).getTitle()%></td>
	                  <td><%= sList.get(i).getCreateDate()%></td>
	                </tr>
	                <% 
	              			}
	              		}
	                %>
	              </tbody>
	            </table>
			</div>
		</div>
	</div>	
</div>