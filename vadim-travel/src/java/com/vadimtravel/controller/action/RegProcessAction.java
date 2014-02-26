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
public class RegProcessAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        String getNama = request.getParameter("nama");
        String getUsername = request.getParameter("username");
        String getPassword = request.getParameter("password");
        String getIdJabatan = request.getParameter("jabatan");

        Jabatan jabatan = new Jabatan();
        jabatan.setIdJabatan(getIdJabatan);

        Operator operator = new Operator();
        operator.setNama(getNama);
        operator.setUsername(getUsername);
        operator.setPassword(getPassword);
        operator.setJabatan(jabatan);

        MySQL mySQL = new MySQL();
        OperatorDAO opDAO = new OperatorDAOImpl(mySQL.getConn());

        try{
            opDAO.insert(operator);
            request.setAttribute("msg", "<font color=\"green\">"+"REGISTRASI OPERATOR SUKSES"+"</font>");
        }catch(Exception e){
            request.setAttribute("msg", e.getMessage());
        }
        return "controller?action=operator";
    }

}
