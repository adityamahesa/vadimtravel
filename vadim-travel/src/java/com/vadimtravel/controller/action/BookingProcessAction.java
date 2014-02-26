/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.PreOrderDAO;
import com.vadimtravel.model.dao.mysql.PreOrderDAOImpl;
import com.vadimtravel.model.entity.TravelDetailOrder;
import com.vadimtravel.model.entity.TravelOrder;
import com.vadimtravel.model.entity.TravelRegional;
import com.vadimtravel.model.entity.TravelTujuan;
import com.vadimtravel.util.MySQL;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class BookingProcessAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        String nama = request.getParameter("nama");
        String alamat = request.getParameter("alamat");
        String regional = request.getParameter("regional");
        String telp = request.getParameter("telp");
        String tujuan = request.getParameter("tujuan");
        String getTglBerangkat =  request.getParameter("tgl_berangkat");
        Date tglBerangkat = Date.valueOf(getTglBerangkat);
        String getJamBerangkat = request.getParameter("jam_berangkat");
        Time jamBerangkat = Time.valueOf(getJamBerangkat+":00");

        MySQL mySQL = new MySQL();
        PreOrderDAO preDAO = new PreOrderDAOImpl(mySQL.getConn());

        TravelOrder travelOrder = new TravelOrder();
        TravelDetailOrder travelDetailOrder = new TravelDetailOrder();

        travelOrder.setNama(nama);
        travelOrder.setAlamat(alamat);

        TravelRegional travelRegional = new TravelRegional();
        travelRegional.setIdTravelRegional(regional);
        travelOrder.setTravelRegional(travelRegional);

        travelOrder.setTelp(telp);

        TravelTujuan travelTujuan = new TravelTujuan();
        travelTujuan.setIdTravelTujuan(tujuan);
        travelDetailOrder.setTravelTujuan(travelTujuan);

        travelOrder.setTglBerangkat(tglBerangkat);
        travelOrder.setJamBerangkat(jamBerangkat);
        try{
            preDAO.insertOrder(travelOrder);
            preDAO.insertDetailOrder(travelDetailOrder);
            request.setAttribute("msg", "sukses");
        }catch(Exception e){
            request.setAttribute("msg", "belum");
            System.out.println(e);
        }finally{
            mySQL.closeConn();
        }
        return "home.jsp";
    }

}
