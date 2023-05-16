<%@page import="java.util.List"%>
<%@page import="com.jspiders.productapp.pojo.ProductPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<ProductPojo> pojos = (List<ProductPojo>) request.getAttribute("pojos");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form {
	margin: auto;
	justify-content: center;
	align-items: center;
	display: flex;
	margin-top: 10px;
}

tr th {
	height: 40px;
	width: 200px;
	align-items: center;
	background-color: #333;
	color: white;
}

button a {
	text-decoration: none;
	font-size: larger;
}
</style>
</head>
<body>
	<button
		style="margin-left: 720px; margin-top: 10px; border-radius: 10px; font-size: medium;">
		<a href="./add">Add</a>
	</button>
	<%
	if (msg != null) {
	%>
	<h2 align="center"><%=msg%></h2>
	<%
	}
	%>

	<form action="./home" method="post">
		<table border="1px solid" style="border-collapse: collapse;">
			<tr>
				<th>Id</th>
				<th>Product Name</th>
				<th>Brands</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
				<th>Action</th>
			</tr>
			<%
			if (pojos != null) {
			%>
			<%
			for (ProductPojo pojo2 : pojos) {
			%>
			<tr>
				<td><%=pojo2.getId()%></td>
				<td><%=pojo2.getName()%></td>
				<td><%=pojo2.getBrand()%></td>
				<td><%=pojo2.getPrice()%></td>
				<td><%=pojo2.getQuantity()%></td>
				<td>
					<button style="border-radius: 10px; margin-left: 10px">
						<a href="./remove">Remove</a>
					</button>
					<button style="border-radius: 10px; margin-left: 5px">
						<a href="./update">Edit</a>
					</button>
				</td>
			</tr>
			<%
			}
			}
			%>
		</table>
	</form>
</body>
</html>