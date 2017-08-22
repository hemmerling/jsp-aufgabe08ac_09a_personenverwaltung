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

/**
 *
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
public class PersonViewAction4 implements Action {

    private static final String VIEWPAGE4 = "view4.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(VIEWPAGE4);
        requestDispatcher.forward(request, response);
    }
}
