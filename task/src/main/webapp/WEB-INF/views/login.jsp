<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://www.springframework.org/tags/form" prefix="springform"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   This is login page
   
  
  <springform:form  action="login" method="post" modelAttribute="login">
  
      <springform:input path="email"/>
      <springform:input path="password"/>
      <input type="submit" value="login"/>
  </springform:form>
 
</body>
</html>