/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.OperatorDAO;
import com.vadimtravel.model.dao.mysql.OperatorDAOImpl;
import com.vadimtravel.model.entity.Jabatan;
import com.vadimtravel.model.entity.Operator;
import com.vadimtravel.util.MySQL;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class ConfirmEditOperatorAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        int getId = Integer.valueOf(request.getParameter("id"));
        String getNama = request.getParameter("nama");
        String getUsername = request.getParameter("username");
        String getIdJabatan = request.getParameter("jabatan");

        MySQL mySQL = new MySQL();
        OperatorDAO opDAO = new OperatorDAOImpl(mySQL.getConn());

        Jabatan jabatan = new Jabatan();
        jabatan.setIdJabatan(getIdJabatan);

        Operator operator = new Operator();
        operator.setNama(getNama);
        operator.setUsername(getUsername);
        operator.setJabatan(jabatan);

        try{
            opDAO.update(getId, operator);
            request.setAttribute("msg", "<font color=\"green\">"+"EDIT OPERATOR SUKSES"+"</font>");
        }catch(Exception e){
            request.setAttribute("msg", e.getMessage());
        }finally{
            mySQL.closeConn();
        }
        return "controller?action=operator";
    }

}
