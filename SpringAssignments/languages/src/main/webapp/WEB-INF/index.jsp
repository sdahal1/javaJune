<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
<body>
    <h1>Hello World</h1>
    <h3>${allLangs}</h3>
    <table class="table">
        <thead>
          <tr>
            <th scope="col">ID#</th>
            <th scope="col">Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Version</th>
            <th scope="col">Action</th>

          </tr>
        </thead>
        <tbody>
         <c:forEach items='${ allLangs }' var='lang'>   
          <tr>
            <th scope="row">${lang.id}</th>
            <td>${lang.name}</td>
            <td>${lang.creator}</td>
            <td>${lang.version}</td>
            <td><a href="">View</a> || <a href="">Edit</a></td>
          </tr>
         </c:forEach>
          
        </tbody>
      </table>
</body>
</html>