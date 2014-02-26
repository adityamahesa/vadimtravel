/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.JabatanDAO;
import com.vadimtravel.model.dao.mysql.JabatanDAOImpl;
import com.vadimtravel.model.entity.Jabatan;
import com.vadimtravel.util.MySQL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class GoRegistrationAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        MySQL mySQL = new MySQL();

        List<Jabatan> listJabatan = new ArrayList<Jabatan>();
        JabatanDAO jabDAO = new JabatanDAOImpl(mySQL.getConn());

        try{
            listJabatan = jabDAO.getJabatan();
        }catch(Exception e){
            e.getMessage();
        }finally{
            mySQL.closeConn();
        }
        request.setAttribute("listJabatan", listJabatan);
        return "registrasi.jsp";
    }

}
