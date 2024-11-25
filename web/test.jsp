<%-- 
    Document   : test
    Created on : Nov 25, 2024, 9:52:31 AM
    Author     : zenzen1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:set var="a" value="c" />
        <c:out value="abc"/>
        <c:out value="${a}"/>
    </body>
</html>
