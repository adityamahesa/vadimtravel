/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao.mysql;

import com.vadimtravel.model.dao.PreOrderDAO;
import com.vadimtravel.model.entity.TravelDetailOrder;
import com.vadimtravel.model.entity.TravelOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author adityamahesa
 */
public class PreOrderDAOImpl implements PreOrderDAO{
    private Connection conn;
    public PreOrderDAOImpl(Connection conn){
        this.conn = conn;
    }

    public void insertOrder(TravelOrder travelOrder) throws Exception {
        String sql = "INSERT INTO `travel_order` (`nama`,`alamat`,`id_travel_regional`,"+
                "`telp`,`tgl_transaksi`,`tgl_berangkat`,`jam_berangkat`) "+
                "VALUES (?,?,?,?,DATE(CURRENT_DATE),?,?);";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setString(1, travelOrder.getNama());
        st.setString(2, travelOrder.getAlamat());
        st.setString(3, travelOrder.getTravelRegional().getIdTravelRegional());
        st.setString(4, travelOrder.getTelp());
        st.setDate(5, travelOrder.getTglBerangkat());
        st.setTime(6, travelOrder.getJamBerangkat());
        st.executeUpdate();
        st.close();
    }

    public void insertDetailOrder(TravelDetailOrder travelDetailOrder) throws Exception {
        String sql = "INSERT INTO `travel_detail_order` (`id_travel_order`,`id_travel_tujuan`)"+
                " VALUES (LAST_INSERT_ID(),?)";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setString(1, travelDetailOrder.getTravelTujuan().getIdTravelTujuan());
        st.executeUpdate();
        st.close();
    }
}
