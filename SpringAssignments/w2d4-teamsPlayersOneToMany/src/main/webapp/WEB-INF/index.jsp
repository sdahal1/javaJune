<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
<body>
    <h1>Hello Teams and Players</h1>
    <h3>${allTeams}</h3>


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
                    <td>${team.name}</td>
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

    
</body>
</html>