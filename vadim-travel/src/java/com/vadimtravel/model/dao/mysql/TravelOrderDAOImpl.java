/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao.mysql;

import com.vadimtravel.model.dao.TravelOrderDAO;
import com.vadimtravel.model.entity.TravelOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public class TravelOrderDAOImpl implements TravelOrderDAO{
    private Connection conn;
    public TravelOrderDAOImpl(Connection conn){
        this.conn = conn;
    }

    public TravelOrder getTravelOrder(int idTravelOrder) throws Exception {
        String sql = "SELECT * FROM `travel_order` WHERE `id_travel_order`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        TravelOrder travelOrder = null;
        st.setInt(1, idTravelOrder);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            travelOrder = new TravelOrder();
            travelOrder.setIdTravelOrder(rs.getInt(1));
            travelOrder.setNama(rs.getString(2));
            travelOrder.setAlamat(rs.getString(3));
            travelOrder.setTravelRegional(new TravelRegionalDAOImpl(this.conn).
                    getTravelRegional(rs.getString(4)));
            travelOrder.setTelp(rs.getString(5));
            travelOrder.setTglTransaksi(rs.getDate(6));
            travelOrder.setTglBerangkat(rs.getDate(7));
            travelOrder.setJamBerangkat(rs.getTime(8));
        }
        return travelOrder;
    }

    public List<TravelOrder> getTravelOrder() throws Exception {
        List<TravelOrder> listTravelOrder = new ArrayList<TravelOrder>();
        String sql = "SELECT * FROM `travel_order`";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            TravelOrder travelOrder = new TravelOrder();
            travelOrder.setIdTravelOrder(rs.getInt(1));
            travelOrder.setNama(rs.getString(2));
            travelOrder.setAlamat(rs.getString(3));
            travelOrder.setTravelRegional(new TravelRegionalDAOImpl(this.conn).
                    getTravelRegional(rs.getString(4)));
            travelOrder.setTelp(rs.getString(5));
            travelOrder.setTglTransaksi(rs.getDate(6));
            travelOrder.setTglBerangkat(rs.getDate(7));
            travelOrder.setJamBerangkat(rs.getTime(8));
        }
        return listTravelOrder;
    }

}
