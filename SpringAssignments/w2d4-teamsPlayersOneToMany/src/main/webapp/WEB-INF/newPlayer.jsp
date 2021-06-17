<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">

</head>
<body>
    <h1>Create a new player below</h1>
    

    <form:form action="/players/create" method="post" modelAttribute="player">
            <p>
                <form:label path="first_name">First Name</form:label>
                <form:input path="first_name"/>
                <form:errors class= "text-danger" path="first_name"/>
            </p>
            <p>
                <form:label path="last_name">Last Name</form:label>
                <form:input path="last_name"/>
                <form:errors class= "text-danger" path="last_name"/>
            </p>
            <p>
                <form:label path="age">Age</form:label>
                <form:input type="number" path="age"/>
                <form:errors class= "text-danger" path="age"/>
            </p>
            <p>
                <form:label path="team">Select Team</form:label>
                <form:select path="team" id="">
                    <c:forEach items='${allTeams}' var='t'>
                        <option value="${t.id}">${t.name}</option>
                    </c:forEach>
                    
                </form:select>
            </p>
            
            <input type="submit" value="Submit"/>
    </form:form>  
</body>
</html>