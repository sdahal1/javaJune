<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Edit pet</h1>
<form:form action="/pets/${pet.id}/update" method="post" modelAttribute="pet">
            <p>
                <form:label path="name">Name</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <p>
                <form:label path="age">age</form:label>
                <form:errors path="age"/>
                <form:input type="number" path="age"/>
            </p>
            <p>
                <form:label path="ownerName">Owner Name</form:label>
                <form:errors path="ownerName"/>
                <form:input path="ownerName"/>
            </p>  
            <input type="submit" value="Submit"/>
        </form:form>    
</body>
</html>