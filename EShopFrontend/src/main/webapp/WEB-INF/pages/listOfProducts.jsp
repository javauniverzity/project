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
		</div>
		
		<c:forEach var="p" items="${products}">
			<a href="productDetail.html?productId=${p.id}">	
				<div class="product">
					<strong>${p.productname}</strong><br>
					<img alt="" src="img/${p.image}">
					${p.description}<br>
					cena: ${p.price} kc,-
					<a href="adToBasket.html?id=${p.id}">
						<div class="add">
							Pridat do kosiku						
						</div>
					</a>
				</div>
			</a>
		</c:forEach>
	</div>
</html>