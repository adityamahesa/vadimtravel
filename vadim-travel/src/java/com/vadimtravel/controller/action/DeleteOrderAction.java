/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.PostOrderDAO;
import com.vadimtravel.model.dao.mysql.PostOrderDAOImpl;
import com.vadimtravel.util.MySQL;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class DeleteOrderAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        String getId = request.getParameter("id");
        int id = Integer.valueOf(getId);

        MySQL mySQL = new MySQL();
        PostOrderDAO postDAO = new PostOrderDAOImpl(mySQL.getConn());
        try{
            postDAO.deleteDetailOrder(id);
            postDAO.deleteOrder(id);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            mySQL.closeConn();
        }
        return "controller?action=office";
    }
}
