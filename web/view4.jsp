<%--
    Document   : createperson
    Created on : 17.07.2017, 17:33:53
    Author     : Administrator
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%--
     Error:
     "The absolute uri: http://java.sun.com/jsp/jstl/core cannot be resolved in either web.xml
     or the jar files deployed with this application"

     Solution: Add library "JSTL 1.2.1" to your project
     at Netbeans "Project Properties / Libraries / Compile-time Libraries"
--%>

<%@page import="com.hemmerling.aufgabe08ac_09a_personenverwaltung.model.business.PersonService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personenliste [Web Components ( aufgabe08ac_09a_personenverwaltung )]</title>
    </head>
    <body>
        <jsp:include page = "header.jsp" />
        <h1>Personenliste 4</h1>
        <%--
            sessionScope.personservice.get()
        --%>
        <c:set var = "persons" scope = "session" value = "${personservice.get()}"/>
        <%--
            In a c:choose, the first when for which the test is true is the winner. 
        --%>
        <c:choose >
            <c:when test = "${persons == null}">
            </c:when>
            <c:when test = "${persons.size() == 0}">
            </c:when>
            <c:when test = "${persons.size() > 0}">
                <c:forEach begin="1" end="${persons.size()}" step="1" var="ii">
                <li>${ii-1}&nbsp;${persons.get(ii-1)[0]}&nbsp;
                    ${persons.get(ii-1)[1]}&nbsp;
                    <a href="FrontController?action=delete&id=${ii-1}">Löschen</a>&nbsp;
                    <a href="FrontController?action=update&id=${ii-1}">Bearbeiten</a></li>
                </c:forEach>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
        <jsp:include page = "footer.jsp" />
</body>
</html>
