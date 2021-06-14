<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
<body onload = "warnAboutCurry()">
    <h1>Order some BangKok Garden Special Thai Curry today which is: ${dateinfo}</h1>
    <form action="/submitOrder" method="post">
        <div class= "form-group">
            <label for="">Your Name:</label>
            <input class= "form-control" type="text" name="nombre" id="">
        </div>
        <div>
            <label for="">Select Spice Level</label>
            <select name="spiceL" id="">
                <option value="1">1 (mild)</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5 (extra hot)</option>
            </select>
        </div>
        <div>
            <label for="">Credit Card Number</label>
            <input type="text" name="ccNum" id="">
        </div>
        <input type="submit" value="Order this Curry!">
    </form>
    <script src="/js/grubstuff.js"></script>
</body>
</html>