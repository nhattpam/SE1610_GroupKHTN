<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
<title>index</title>
</head>
<body>
  <h1>Index</h1>
  <%
    String id = request.getAttribute("id").toString();
    String name = request.getAttribute("name").toString();
    String email = request.getAttribute("email").toString();
    String verified = request.getAttribute("verified").toString();
    String givenname = request.getAttribute("givenname").toString();
    String familyname = request.getAttribute("familyname").toString();
    out.print("Id: " + id);
    out.print("<br/>Name: " + name);
    out.print("<br/>Email: " + email);
    out.print("<br/>Verified-Email: " + verified);
    out.print("<br/>Given Name: " + givenname);
    out.print("<br/>Family: " + familyname);
  %>
</body>
</html>