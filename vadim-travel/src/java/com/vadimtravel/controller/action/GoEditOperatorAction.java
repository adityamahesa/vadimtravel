/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.JabatanDAO;
import com.vadimtravel.model.dao.OperatorDAO;
import com.vadimtravel.model.dao.mysql.JabatanDAOImpl;
import com.vadimtravel.model.dao.mysql.OperatorDAOImpl;
import com.vadimtravel.model.entity.Jabatan;
import com.vadimtravel.model.entity.Operator;
import com.vadimtravel.util.MySQL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class GoEditOperatorAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));

        MySQL mySQL = new MySQL();

        OperatorDAO opDAO = new OperatorDAOImpl(mySQL.getConn());
        Operator operator = new Operator();

        JabatanDAO jabDAO = new JabatanDAOImpl(mySQL.getConn());
        List<Jabatan> listJabatan = new ArrayList<Jabatan>();

        try{
            operator = opDAO.getOperator(id);
            listJabatan = jabDAO.getJabatan();
        }catch(Exception e){
            e.getMessage();
        }finally{
            mySQL.closeConn();
        }
        request.setAttribute("operator", operator);
        request.setAttribute("jabatan", listJabatan);
        return "editoperator.jsp";
    }

}
