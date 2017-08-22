/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe08ac_09a_personenverwaltung.model.business;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hemmerling.aufgabe08ac_09a_personenverwaltung.model.persistence.Person;

/**
 *
 * @author Administrator
 */
public class PersonSaveAction2 implements Action {

    // Parameter
    private static final String VORNAME = "vorname";
    private static final String NACHNAME = "nachname";
    private static final String CREATEPAGE = "create.jsp";

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Person person = (Person) request.getSession().getAttribute("person2");
        String vorname = person.getVorname();
        String nachname = person.getNachname();
        if ((vorname != null && !vorname.trim().isEmpty())
                & (nachname != null && !nachname.trim().isEmpty())) {
            PersonServiceImplementation personService = PersonServiceImplementation.getInstance(); // Singleton
            personService.add(person);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CREATEPAGE);
        requestDispatcher.forward(request, response);
    }

}
