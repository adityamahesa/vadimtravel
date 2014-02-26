/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao.mysql;

import com.vadimtravel.model.dao.TravelRegionalDAO;
import com.vadimtravel.model.entity.TravelRegional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public class TravelRegionalDAOImpl implements TravelRegionalDAO{
    private Connection conn;
    public TravelRegionalDAOImpl(Connection conn){
        this.conn = conn;
    }
    public TravelRegional getTravelRegional(String id) throws Exception {
        String sql = "SELECT `id_travel_regional`,`regional`,`harga` FROM `travel_regional`"+
                "WHERE `id_travel_regional=?`";
        PreparedStatement st = this.conn.prepareStatement(sql);
        TravelRegional travelRegional = null;
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            travelRegional = new TravelRegional();
            travelRegional.setIdTravelRegional(rs.getString(1));
            travelRegional.setRegional(rs.getString(2));
            travelRegional.setHarga(rs.getInt(3));
        }
        return travelRegional;
    }

    public List<TravelRegional> getTravelRegional() throws Exception {
        List<TravelRegional> listTravelRegional = new ArrayList<TravelRegional>();
        String sql = "SELECT `id_travel_regional`,`regional`,`harga` FROM `travel_regional`";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            TravelRegional travelRegional =  new TravelRegional();
            travelRegional.setIdTravelRegional(rs.getString(1));
            travelRegional.setRegional(rs.getString(2));
            travelRegional.setHarga(rs.getInt(3));
            listTravelRegional.add(travelRegional);
        }
        return listTravelRegional;
    }

}
