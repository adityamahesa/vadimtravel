/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.TravelTujuanDAO;
import com.vadimtravel.model.dao.mysql.TravelTujuanDAOImpl;
import com.vadimtravel.model.entity.TravelTujuan;
import com.vadimtravel.util.MySQL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class GoDaftarTujuan implements ActionInterface{

    public String execute(HttpServletRequest request) {
        MySQL mySQL = new MySQL();
        List<TravelTujuan> listTravelTujuan = new ArrayList<TravelTujuan>();
        TravelTujuanDAO tujuanDAO = new TravelTujuanDAOImpl(mySQL.getConn());
        try{
            listTravelTujuan = tujuanDAO.getTujuan();

        }catch(Exception e){
        }finally{
            mySQL.closeConn();
        }
        request.setAttribute("tujuan", listTravelTujuan);
        return "tujuan.jsp";
    }

}
