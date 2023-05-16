<%@page import="java.util.List"%>
<%@page import="com.jspiders.productapp.pojo.ProductPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ProductPojo pojo1 = (ProductPojo) request.getAttribute("pojo");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<legend>Add Product Details</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td>Product Name :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Brand :</td>
					<td><input type="text" name="brand"></td>
				</tr>
				<tr>
					<td>Product Price :</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<td>Product Quantity :</td>
					<td><input type="text" name="quantity"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add"
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
</body>
</html>