<%@page import="com.jspiders.productapp.pojo.ProductPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
List<ProductPojo> pojos = (List<ProductPojo>) request.getAttribute("pojos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Product</title>
<style type="text/css">
form {
	margin-top: 20px
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	align-items: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 500px;
	text-align: center;
	margin-top: 100px;
}
</style>
</head>
<body>
	<fieldset>
		<legend>Select Product to remove</legend>

		<form action="./remove" method="post">
			<table>
				<tr>
					<td>Enter Product Id:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Remove"
						style="border-radius: 10px;"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	if (msg != null) {
	%>
	<h2 align="center"><%=msg%></h2>
	<%
	}
	%>
	<%
	if (pojos != null) {
	%>
	<form action="./home" method="Post">
		<table border="1px solid" style="border-collapse: collapse;">
			<tr>
				<th>Id</th>
				<th>Product Name</th>
				<th>Brands</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
			</tr>

			<%
			for (ProductPojo pojo2 : pojos) {
			%>
			<tr>
				<td><%=pojo2.getId()%></td>
				<td><%=pojo2.getName()%></td>
				<td><%=pojo2.getBrand()%></td>
				<td><%=pojo2.getPrice()%></td>
				<td><%=pojo2.getQuantity()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</form>
	<%
	}
	%>
</body>
</html>