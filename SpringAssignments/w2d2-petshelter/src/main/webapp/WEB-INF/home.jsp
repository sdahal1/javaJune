<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
<body>
    <h1>Hello World. Lets put this wonderful pets into a home.</h1>
    <h3>All the pets: ${allPets}</h3>
    <table class="table table-dark">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Age</th>
            <th scope="col">Owner</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${allPets}" var="pet">
          <tr> 
            <td>${pet.id}</td>
            <td>${pet.name}</td>
            <td>${pet.age}</td>
            <td>${pet.getOwnerName()}</td>
            <td><a href="/pets/${pet.id}">View</a>|| <a href="/pets/${pet.id}/edit">Edit</a> || <a href="">Delete</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    <hr>
    <div>
        <h1>Create a new pet</h1>

        <form:form action="/pets/create" method="post" modelAttribute="pet">
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
    </div>


</body>
</html>