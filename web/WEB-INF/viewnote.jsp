<%-- 
    Document   : viewnote
    Created on : Jun 2, 2023, 8:37:02 AM
    Author     : danielchow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <div><b>Title: </b>${title}</div>
        <br>
        <div><b>Contents: </b></div>
        ${content}
        <br>
        <br>
        <a href="note?edit">Edit</a>
        
    </body>
</html>
