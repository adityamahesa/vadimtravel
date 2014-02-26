/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.OperatorDAO;
import com.vadimtravel.model.dao.mysql.OperatorDAOImpl;
import com.vadimtravel.util.MySQL;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class DeleteOperatorAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));

        MySQL mySQL = new MySQL();
        OperatorDAO opDAO = new OperatorDAOImpl(mySQL.getConn());

        try{
            opDAO.delete(id);
            request.setAttribute("msg", "<font color=\"green\">"+"EDIT TRANSAKSI SUKSES"+"</font>");
        }catch(Exception e){
            request.setAttribute("msg", e.getMessage());
        }
        return "controller?action=operator";
    }

}
