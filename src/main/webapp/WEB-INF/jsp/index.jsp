<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<script src="/js/index.js"></script>
</head>
<body>
<form name="form1" type="submit" method="post" action="/login/check">
    user name:<input type="text" name="username"><br>
    password:<input type="password" name="password"><br>
    <input type="submit" value="login">
</form>

</body>

</html>