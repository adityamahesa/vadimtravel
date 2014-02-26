/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.PostOrderDAO;
import com.vadimtravel.model.dao.mysql.PostOrderDAOImpl;
import com.vadimtravel.model.entity.LihatTransaksi;
import com.vadimtravel.util.MySQL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adityamahesa
 */
public class GoOfficeAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        String result = "";
        HttpSession session = request.getSession();
        if(session.getAttribute("jabatan") == null){
            result = "controller?action=officelogin";
        }else{
            result = "office.jsp";
        }
        MySQL mySQL = new MySQL();
        List<LihatTransaksi> listLihatTransaksi = new ArrayList<LihatTransaksi>();
        PostOrderDAO postDAO = new PostOrderDAOImpl(mySQL.getConn());
        try{
            listLihatTransaksi = postDAO.viewTransaksi();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            mySQL.closeConn();
        }
        System.out.println(listLihatTransaksi.size());
        request.setAttribute("list", listLihatTransaksi);
        return result;
    }

}
