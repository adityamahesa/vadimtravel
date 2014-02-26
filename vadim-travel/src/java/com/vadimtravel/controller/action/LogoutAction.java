/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adityamahesa
 */
public class LogoutAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("jabatan");
        return "controller?action=officelogin";
    }
}
