<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Here is information about quote number: ${quoteToShow.id}</h1>
    <p>Quoted By: ${quoteToShow.quotedBy}</p>
    <p>Rating: ${quoteToShow.rating}</p>
    <p>Content: ${quoteToShow.content}</p>


    <h3>Users who like this quote:</h3>
    <ul>
        <c:forEach items='${ quoteToShow.usersWhoLike }' var='u'>
            <li>${u.name}</li>
        </c:forEach>

    </ul>


    <br>
    <h3>Add a User as one of the favoriters of this quote</h3>
    <form action="/addUserToQuote/${quoteToShow.id}" method="post">
        <select name="selected_user" id="">
            <c:forEach items='${ allUsers }' var='u'>
                <option value="${u.id}">${u.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Submit">
    </form>

</body>
</html>