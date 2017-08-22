<%--    
    Document   : process
    Created on : 14.08.2017, 13:53:51
    Author     : rhemmerling
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:useBean id="person3" scope="session" class="com.hemmerling.aufgabe08ac_09a_personenverwaltung.model.persistence.Person"></jsp:useBean>  
        <jsp:setProperty property="*" name="person3"/>  
        <jsp:forward page="FrontController">
            <jsp:param name="action" value="create3"/>
        </jsp:forward>
    </body>
</html>
