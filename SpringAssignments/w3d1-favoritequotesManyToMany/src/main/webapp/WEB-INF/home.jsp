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
    <h1>All the quotes</h1>
    ${allQuotes}
    <table class="table">
        <thead>
          <tr>
            <th scope="col">ID#</th>
            <th scope="col">Content</th>
            <th scope="col">Quoted By</th>
            <th scope="col">Rating</th>
            <th scope="col">Users who like the quote</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items='${ allQuotes }' var='q'>
                <tr>
                    <th scope="row">${q.id}</th>
                    <td><a href="/quotes/${q.id}/info">${q.content}</a></td>
                    <td>${q.quotedBy}</td>
                    <td>${q.rating}</td>
                    <td>${q.usersWhoLike}</td>
                </tr>
            </c:forEach>
         
        </tbody>
      </table>

      <hr>

    <form:form action="/quotes/create" method="post" modelAttribute="quote">
        <p>
            <form:label path="quotedBy">Quoted By:</form:label>
            <form:errors path="quotedBy"/>
            <form:input path="quotedBy"/>
        </p>
        <p>
            <form:label path="content">Content:</form:label>
            <form:errors path="content"/>
            <form:textarea path="content"/>
        </p>
        <p>
            <form:label path="rating">Rating:</form:label>
            <form:errors path="rating"/>     
            <form:input type="number" path="rating"/>
        </p>    
        <input type="submit" value="Submit"/>
    </form:form>    
</body>
</html>