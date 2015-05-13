<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<div class="inner">
		<div class="sortMenu">
			radit dle:
			<form:form action="index.html" method="GET">	
				<select name="sortBy">
					<option value="price">ceny</option>
					<option value="productname">nazvu</option>
				</select>
				<select name="sortHow">
					<option value="asc">vzestupne</option>
					<option value="desc">sestupne</option>
				</select>
				<input type="submit">
			</form:form>
			<form action="index.html" method="get">
				<input type="text" name="searchProduct">
				<input type="submit" value="Hledej">
			</form>
		</div>
		
		<table>	
			<tr>
				<th>ID</th>
				<th>Nazev</th>
				<th>Popis</th>
				<th>Obr</th>
				<th>Cena</th>
				<th>Mnozstvi</th>
				<th></th>
			</tr>
			<c:forEach var="p" items="${products}">
				<tr>
					<td>${p.id}</td>
					<td>${p.productname}</td>
					<td>${p.description}</td>
					<td>${p.image}</td>
					<td>${p.price}</td>
					<td>${p.quantity}</td> 
					<td></td>				
				</tr>	
				<tr>
					<form:form commandName="${p.id}" action="edProduct?id=${p.id}">
						<td>
						</td>
						<td>
							<form:input path="productname"></form:input>
						</td>
						<td>
							<form:input path="description"></form:input>
						</td>
						<td>
							<form:input path="image"></form:input>
						</td>
						<td>
							<form:input path="price"></form:input>
						</td>
						<td>
							<form:input path="quantity"></form:input>
						</td>
						<td>
							<form:button>Edit</form:button>
						</td>
					</form:form>
				</tr>			
			</c:forEach>
		</table>
	</div>
</html>