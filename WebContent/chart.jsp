<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.google.gson.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<link rel="stylesheet" type="text/css" href="./cstyle.css">
<script type="text/javascript" src="./Chart.js"></script>
</head>
</head>
<body>

 <%
 JsonArray close = (JsonArray)request.getAttribute("close");
 JsonArray label = (JsonArray)request.getAttribute("label");
 
 //out.print(close);
 //out.print(label);
 %>
 
  <canvas id="myChart" height="4000px"></canvas>

 <script type="text/javascript">
 
	  var ctx = document.getElementById("myChart");
	  var myChart = new Chart(ctx, {
		  type: 'horizontalBar',
		    data: {
	      		//차트의 세로축
	      		labels: <%=label%>,
	      		datasets: [{
	        		label: '# 미세먼지', //차트의 그래프
	        		data: <%=close%>, //데이터
	        		backgroundColor:"#c6d4df" , //막대 그래프 색
	        		borderColor: "#000", //테두리 색
	        		borderWidth: 1
	      		}]
	    	},
		    options: {showXLabels: 3,
		    	    scales: {
		    	        xAxes: [{
		    	            gridLines: {
		    	                offsetGridLines: true
		    	            }
		    	        }]
		    	    },
			    	
			    	
		    	}
	 });
	  

 
 </script>
 
</body>
</html>
