<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<html>
<body>
<h2>Hello World!</h2>
<img src="<spring:url value="/resources/images/demo.png"></spring:url>">
</body>
</html>
