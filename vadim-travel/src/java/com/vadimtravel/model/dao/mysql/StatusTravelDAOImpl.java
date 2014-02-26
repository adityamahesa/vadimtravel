/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao.mysql;

import com.vadimtravel.model.dao.StatusTravelDAO;
import com.vadimtravel.model.entity.StatusTravel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public class StatusTravelDAOImpl implements StatusTravelDAO{
    private Connection conn;
    public StatusTravelDAOImpl(Connection conn){
        this.conn = conn;
    }

    public StatusTravel getStatusTravel(String id) throws Exception {
        String sql = "SELECT `id_status_travel`,`status` FROM `status_travel`"+
                "WHERE `id_status_travel`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        StatusTravel statusTravel = null;
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            statusTravel = new StatusTravel();
            statusTravel.setIdStatusTravel(rs.getString(1));
            statusTravel.setStatus(rs.getString(2));
        }
        return statusTravel;
    }

    public List<StatusTravel> getStatusTravel() throws Exception {
        List<StatusTravel> listStatusTravel = new ArrayList<StatusTravel>();
        String sql = "SELECT `id_status_travel`,`status` FROM `status_travel`";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            StatusTravel statusTravel = new StatusTravel();
            statusTravel.setIdStatusTravel(rs.getString(1));
            statusTravel.setStatus(rs.getString(2));
            listStatusTravel.add(statusTravel);
        }
        return listStatusTravel;
    }

}
