<%--
    Document   : createperson
    Created on : 17.07.2017, 17:33:53
    Author     : Administrator
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="com.hemmerling.aufgabe08c_personenverwaltung.model.business.PersonService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personenliste [Web Components ( aufgabe08c_personenverwaltung )]</title>
    </head>
    <body>
        <jsp:include page = "header.jsp" />
        <h1>Personenliste 4</h1>
        
        <%
            PersonService personService = (PersonService) session.getAttribute("personservice");
            List<String[]> persons = (ArrayList<String[]>) personService.get();                  
            if (persons == null /* || items.isEmpty() */) {
        %>
        <% } else { %>        
            <% for (int ii=0; ii<persons.size();ii++) {%>
            <li><%= ii%>&nbsp;${sessionScope.personservice.get().get(ii)[0]}&nbsp;
                              ${sessionScope.personservice.get().get(ii)[1]}&nbsp;
                <a href="FrontController?action=delete&id=<%= ii%>">Löschen</a>&nbsp;
                <a href="FrontController?action=update&id=<%= ii%>">Bearbeiten</a></li>
                <% } %>
        
        <% }%>
        <jsp:include page = "footer.jsp" />
    </body>
</html>
