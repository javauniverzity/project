<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>


<head>
<link id="link" rel="stylesheet" href="css/stylesheet.css"
	type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
</head>
<body>	

	<form:form commandName="product" action="makeProduct.html">
		Jméno produktu <br/>
		<form:input path="productname"/> <br/>  
		Kategorie produktu<br/>
		<form:input path="category"/> <br/>  
 		Popis produktu<br/>
 		<form:textarea path="description"/> <br/>  
 		Cena produktu<br/>
 		<form:input path="price"/> <br/>  
 		Počet kusů na skladě<br/>
 		<form:input path="quantity"/> <br/>  
 		Obrázek produktu<br/>
 		<form:input path="image"/> <br/>  
		
		<form:button>Založit produkt</form:button>
	</form:form>

</body>
</html>