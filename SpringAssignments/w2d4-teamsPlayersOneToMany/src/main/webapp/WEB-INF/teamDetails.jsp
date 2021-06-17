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
    <h1>Here are the team details: ${teamtoshow.name}</h1>
    <p>City: ${teamtoshow.city}</p>
    <p>PLayers list: ${teamtoshow.players}</p>


    <h3>This Teams Roster</h3>
    <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Full Name</th>
            <th scope="col">Age</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items='${ teamtoshow.players }' var='player'>
                <tr>
                    <th scope="row">${player.id}</th>
                    <td>${player.first_name} ${player.last_name}</td>
                    <td>${player.age}</td>
                    
                </tr>
            </c:forEach>
          
        </tbody>
      </table>
    
</body>
</html>