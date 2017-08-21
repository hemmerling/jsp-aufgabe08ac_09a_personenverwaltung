<%--
    Document   : createperson
    Created on : 17.07.2017, 17:33:53
    Author     : Administrator
--%>

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
        <h1>Personenliste</h1>

        <%@ page import = "java.util.ResourceBundle" %>
        <% ResourceBundle resource = ResourceBundle.getBundle("myapp");
           String updateName=resource.getString("update");%>
<!--
           <%=updateName %>
  -->
        <%
//            out.println("<hr>");
//            String myappPath = (String) session.getAttribute("myapp");          
//            out.println("<hr>");
//            out.println(myappPath);
//            out.println("<hr>");
        %>
        <%
            PersonService personservice = (PersonService) session.getAttribute("personservice");
            List<String[]> persons = (ArrayList<String[]>) personservice.get();
            if (persons == null /* || items.isEmpty() */) {
        %>
        <% } else { %>
<!--        <ol>
            <% for (String[] person : persons) {%>
            <li><%= person[0]%>&nbsp;<%= person[1]%></li>
                <% } %>
        </ol>-->
        
            <% for (int ii=0; ii<persons.size();ii++) {%>          
            <li><%= ii%>&nbsp;<%= persons.get(ii)[0]%>&nbsp;<%= persons.get(ii)[1]%>&nbsp;
                <a href="FrontController?action=delete&id=<%= ii%>">Löschen</a>&nbsp;
                <a href="FrontController?action=update&id=<%= ii%>">Bearbeiten</a></li>
                <% } %>
        
        <% }%>
        <jsp:include page = "footer.jsp" />
    </body>
</html>
