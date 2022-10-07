<%-- 
    Document   : Excel
    Created on : Oct 7, 2022, 12:58:11 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dtos.UsersDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px solid black">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role Id</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="o">
                <tr>
                    <td>${o.user_id}</td>
                    <td>${o.full_name}</td>
                    <td>${o.email}</td>
                    <td>${o.phone}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href ="<%=request.getContextPath()%>/TestController">Export</a>
    </body>
</html>
