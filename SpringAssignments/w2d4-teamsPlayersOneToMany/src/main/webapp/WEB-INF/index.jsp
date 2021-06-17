<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
<body>
    <h1>Hello Teams and Players</h1>


    <table class="table table-dark">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">City</th>
            <th scope="col">Roster(Players)</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items='${ allTeams }' var='team'>
                <tr>
                    <td>${team.id}</td>
                    <td><a href="/teams/${team.id}/info">${team.name}</a></td>
                    <td>${team.city}</td>
                    <td>
                        <ul>
                    <c:forEach items='${ team.players }' var='p'>
                        
                        <li>${p.first_name} ${p.last_name}</li>
                    </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
          
        </tbody>
      </table>

      <hr>
        <h3>Create a new team</h3>
        <form:form action="/teams/create" method="post" modelAttribute="team">
            <p>
                <form:label path="name">Name</form:label>
                <form:input path="name"/>
                <form:errors class= "text-danger" path="name"/>
            </p>
            <p>
                <form:label path="city">City</form:label>
                <form:input path="city"/>
                <form:errors class= "text-danger" path="city"/>
            </p>
            
            <input type="submit" value="Submit"/>
        </form:form>  
        <a href="/players/new">Create a new Player</a>  

    
</body>
</html>