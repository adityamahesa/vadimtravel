/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vadimtravel.controller.servlet;

import com.vadimtravel.controller.action.ActionInterface;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hendro
 */
public class ControllerServlet extends HttpServlet {

    Properties props = null;
    RequestDispatcher rds = null;

    @Override
    public void init(ServletConfig config)
            throws ServletException {
        try {
            props = new Properties();
            InputStream in = this.getClass().getClassLoader().
                    getResourceAsStream("conf.properties");
            props.load(in);
        } catch (Exception ex) {
            System.err.println("fail to read file");
        }

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String urlPath = request.getParameter("action");
        String reqHelperClassName = (String) props.get(urlPath);
        if (reqHelperClassName != null) {
            try {
                ActionInterface helper = (ActionInterface) Class.forName(reqHelperClassName).newInstance();
                String nextView = helper.execute(request);
                if (!nextView.contains("controller")) {
                    nextView = "/WEB-INF/page/" + nextView;
                }
                rds = request.getRequestDispatcher(nextView);
                rds.forward(request, response);
            } catch (Exception ex) {
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

