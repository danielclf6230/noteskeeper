<%-- 
    Document   : editnote
    Created on : Jun 2, 2023, 8:37:14 AM
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
        <form method="post" action="note">
            <h1>Simple Note Keeper</h1>
            <h2>View Note</h2>
            <label>Title: </label>
            <input type="test" name="newT">
            <br>
            <label>Contents: </label>
            <textarea name="newC" rows="8" cols="30" style="resize: none" placeholder="Contents go here"></textarea>
            <br>
            <input type="submit" value="save">
        </form>
    </body>
</html>
