/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe08ac_09a_personenverwaltung.controller;

import com.hemmerling.aufgabe08ac_09a_personenverwaltung.model.business.Action;
import com.hemmerling.aufgabe08ac_09a_personenverwaltung.model.business.PersonServiceImplementation;
import com.hemmerling.aufgabe08ac_09a_personenverwaltung.model.business.PersonService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private static final String ACTION = "action";
    private static final String CREATE = "create";
    private static final String CREATE2 = "create2";
    private static final String CREATE3 = "create3";
    private static final String CREATE4 = "create4";
    private static final String VIEW = "view";
    private static final String VIEW2 = "view2";
    private static final String VIEW3 = "view3";
    private static final String VIEW4 = "view4";
    private static final String DELETE = "delete";
    private static final String UPDATE = "update";
    private static final String SET = "set";

    private static final String STARTPAGE = "index.jsp";
    private static final String CREATEPAGE = "create.jsp";
    
    private static final String PERSONSERVICE = "personservice";

    private static final String MYAPP = "myapp";   

    private static Properties actionMap = new Properties();

    static {
        // "actionName", FQN = "Fully Qualified Name"
//        actionMap.setProperty(FrontController.UPDATE,
//                "com.hemmerling.aufgabe01f_personenverwaltung_v4.model.business.PersonSaveAction");
//        actionMap.setProperty(FrontController.CREATE,
//                "com.hemmerling.aufgabe01f_personenverwaltung_v4.model.business.PersonSaveAction");
//        actionMap.setProperty(FrontController.VIEW,
//                "com.hemmerling.aufgabe01f_personenverwaltung_v4.model.business.PersonViewAction");
//        actionMap.setProperty(FrontController.DELETE,
//                "com.hemmerling.aufgabe01f_personenverwaltung_v4.model.business.PersonDeleteAction");
//        actionMap.setProperty(FrontController.SET,
//                "com.hemmerling.aufgabe01f_personenverwaltung_v4.model.business.PersonSetAction");
//    
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        PersonService personService = PersonServiceImplementation.getInstance(); // Singleton
        session.setAttribute(PERSONSERVICE, personService);
        
        String todo = request.getParameter(ACTION);

        if (todo != null && !todo.trim().isEmpty()) {
            String className = actionMap.getProperty(todo);
            Action action = (Action) Class.forName(className).newInstance();
            action.execute(request, response);
        }
    }
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Properties prop = new Properties();
        String fileName = getServletContext().getInitParameter("myapp");
//        String fileName = "myapp.properties";
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(fileName);
 //       InputStream input = this.getClass().getClassLoader().getResourceAsStream("/"+fileName);
        try {
		prop.load(input);
                // get the property value and print it out
		actionMap.setProperty(FrontController.UPDATE, 
                                      prop.getProperty(FrontController.UPDATE));
                actionMap.setProperty(FrontController.CREATE,
                                      prop.getProperty(FrontController.CREATE));
                actionMap.setProperty(FrontController.CREATE2,
                                      prop.getProperty(FrontController.CREATE2));
                actionMap.setProperty(FrontController.CREATE3,
                                      prop.getProperty(FrontController.CREATE3));
                actionMap.setProperty(FrontController.CREATE4,
                                      prop.getProperty(FrontController.CREATE4));
                actionMap.setProperty(FrontController.VIEW,
                                      prop.getProperty(FrontController.VIEW));
                actionMap.setProperty(FrontController.VIEW,
                                      prop.getProperty(FrontController.VIEW));
                actionMap.setProperty(FrontController.VIEW2,
                                      prop.getProperty(FrontController.VIEW2));
                actionMap.setProperty(FrontController.VIEW3,
                                      prop.getProperty(FrontController.VIEW3));
                actionMap.setProperty(FrontController.VIEW4,
                                      prop.getProperty(FrontController.VIEW4));
                actionMap.setProperty(FrontController.DELETE,
                                      prop.getProperty(FrontController.DELETE));
                actionMap.setProperty(FrontController.SET,
                                      prop.getProperty(FrontController.SET));

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
