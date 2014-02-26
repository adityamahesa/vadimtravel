/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.PostOrderDAO;
import com.vadimtravel.model.dao.mysql.PostOrderDAOImpl;
import com.vadimtravel.model.entity.StatusTravel;
import com.vadimtravel.model.entity.TravelDetailOrder;
import com.vadimtravel.model.entity.TravelOrder;
import com.vadimtravel.model.entity.TravelTujuan;
import com.vadimtravel.util.MySQL;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class ConfirmEditAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        int idTravelOrder = Integer.valueOf(request.getParameter("id"));
        Date tglBerangkat = Date.valueOf(request.getParameter("tgl_berangkat"));
        Time jamBerangkat = Time.valueOf(request.getParameter("jam_berangkat"));
        String idTravelTujuan = request.getParameter("tujuan");
        long charge = Long.valueOf(request.getParameter("charge"));
        String idStatusTravel = request.getParameter("status");

        MySQL mySQL = new MySQL();
        PostOrderDAO postDAO = new PostOrderDAOImpl(mySQL.getConn());

        TravelOrder travelOrder = new TravelOrder();
        travelOrder.setTglBerangkat(tglBerangkat);
        travelOrder.setJamBerangkat(jamBerangkat);

        TravelTujuan travelTujuan = new TravelTujuan();
        travelTujuan.setIdTravelTujuan(idTravelTujuan);

        StatusTravel statusTravel = new StatusTravel();
        statusTravel.setIdStatusTravel(idStatusTravel);

        TravelDetailOrder travelDetailOrder = new TravelDetailOrder();
        travelDetailOrder.setCharge(charge);
        travelDetailOrder.setStatusTravel(statusTravel);
        travelDetailOrder.setTravelTujuan(travelTujuan);

        try{
            postDAO.updateOrder(idTravelOrder, travelOrder);
            postDAO.updateDetailOrder(idTravelOrder, travelDetailOrder);
            request.setAttribute("msg", "<font color=\"green\">"+"EDIT TRANSAKSI SUKSES"+"</font>");
        }catch(Exception e){
            System.out.println(e);
            request.setAttribute("msg", e.getMessage());
        }finally{
            mySQL.closeConn();
        }
        return "controller?action=office";
    }

}
