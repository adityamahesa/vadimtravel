/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao.mysql;

import com.vadimtravel.model.dao.TravelTujuanDAO;
import com.vadimtravel.model.entity.TravelTujuan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public class TravelTujuanDAOImpl implements TravelTujuanDAO{
    private Connection conn;
    public TravelTujuanDAOImpl(Connection conn){
        this.conn = conn;
    }

    public List<TravelTujuan> getTujuan() throws Exception {
        List<TravelTujuan> listTravelTujuan = new ArrayList<TravelTujuan>();
        String sql = "SELECT * FROM `travel_tujuan`";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            TravelTujuan travelTujuan = new TravelTujuan();
            travelTujuan.setIdTravelTujuan(rs.getString(1));
            travelTujuan.setTujuan(rs.getString(2));
            travelTujuan.setHarga(rs.getInt(3));
            travelTujuan.setDeskripsi(rs.getString(4));
            listTravelTujuan.add(travelTujuan);
        }
        return listTravelTujuan;
    }

}
