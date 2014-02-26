/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.PostOrderDAO;
import com.vadimtravel.model.dao.StatusTravelDAO;
import com.vadimtravel.model.dao.TravelTujuanDAO;
import com.vadimtravel.model.dao.mysql.PostOrderDAOImpl;
import com.vadimtravel.model.dao.mysql.StatusTravelDAOImpl;
import com.vadimtravel.model.dao.mysql.TravelTujuanDAOImpl;
import com.vadimtravel.model.entity.LihatTransaksi;
import com.vadimtravel.model.entity.StatusTravel;
import com.vadimtravel.model.entity.TravelTujuan;
import com.vadimtravel.util.MySQL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adityamahesa
 */
public class GoEditOrderAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        int idTravelOrder = Integer.valueOf(request.getParameter("id"));

        MySQL mySQL = new MySQL();
        PostOrderDAO postDAO = new PostOrderDAOImpl(mySQL.getConn());
        LihatTransaksi lihatTransaksi = new LihatTransaksi();

        List<StatusTravel> listStatusTravel = new ArrayList<StatusTravel>();
        StatusTravelDAO statDAO = new StatusTravelDAOImpl(mySQL.getConn());

        List<TravelTujuan> listTravelTujuan = new ArrayList<TravelTujuan>();
        TravelTujuanDAO tjnDAO = new TravelTujuanDAOImpl(mySQL.getConn());

        try{
            lihatTransaksi = postDAO.getTransaksi(idTravelOrder);
            listStatusTravel = statDAO.getStatusTravel();
            listTravelTujuan = tjnDAO.getTujuan();
        }catch(Exception e){
            System.out.println(e);
        }
        request.setAttribute("order", lihatTransaksi);
        request.setAttribute("listTujuan", listTravelTujuan);
        request.setAttribute("listStatus", listStatusTravel);
        return "editorder.jsp";
    }

}
