/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class GoAboutAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        return "about.jsp";
    }

}
