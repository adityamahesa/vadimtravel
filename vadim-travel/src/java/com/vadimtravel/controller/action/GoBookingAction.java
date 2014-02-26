/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.TravelRegionalDAO;
import com.vadimtravel.model.dao.TravelTujuanDAO;
import com.vadimtravel.model.dao.mysql.TravelRegionalDAOImpl;
import com.vadimtravel.model.dao.mysql.TravelTujuanDAOImpl;
import com.vadimtravel.model.entity.TravelRegional;
import com.vadimtravel.model.entity.TravelTujuan;
import com.vadimtravel.util.MySQL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class GoBookingAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        String getIdTujuan = request.getParameter("idtujuan");
        String getTujuan = request.getParameter("tujuan");
        MySQL mySQL = new MySQL();
        List<TravelTujuan> listTravelTujuan = new ArrayList<TravelTujuan>();
        TravelTujuanDAO tujuanDAO = new TravelTujuanDAOImpl(mySQL.getConn());
        List<TravelRegional> listTravelRegional = new ArrayList<TravelRegional>();
        TravelRegionalDAO regDAO = new TravelRegionalDAOImpl(mySQL.getConn());
        try{
            listTravelTujuan = tujuanDAO.getTujuan();
            listTravelRegional = regDAO.getTravelRegional();

        }catch(Exception e){
        }finally{
            mySQL.closeConn();
        }
        request.setAttribute("gettujuan", getTujuan);
        request.setAttribute("getidtujuan", getIdTujuan);
        request.setAttribute("tujuan", listTravelTujuan);
        request.setAttribute("regional", listTravelRegional);
        return "booking.jsp";
    }

}
