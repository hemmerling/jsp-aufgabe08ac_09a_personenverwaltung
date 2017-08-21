/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe08c_personenverwaltung.model.business;

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
public class PersonViewAction3 implements Action {

    private static final String VIEWPAGE3 = "view3.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(VIEWPAGE3);
        requestDispatcher.forward(request, response);
    }
}
