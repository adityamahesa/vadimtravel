/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao.mysql;

import com.vadimtravel.model.dao.PostOrderDAO;
import com.vadimtravel.model.entity.LihatTransaksi;
import com.vadimtravel.model.entity.StatusTravel;
import com.vadimtravel.model.entity.TravelDetailOrder;
import com.vadimtravel.model.entity.TravelOrder;
import com.vadimtravel.model.entity.TravelRegional;
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
public class PostOrderDAOImpl implements PostOrderDAO{
    private Connection conn;
    public PostOrderDAOImpl(Connection conn){
        this.conn = conn;
    }

    public List<LihatTransaksi> viewTransaksi() throws Exception {
        List<LihatTransaksi> listLihatTransaksi = new ArrayList<LihatTransaksi>();
        String sql = "SELECT * FROM `lihat_transaksi` ORDER BY `id_travel_order`";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            LihatTransaksi lihatTransaksi = new LihatTransaksi();
            lihatTransaksi.setTotal(rs.getInt(13));

            TravelOrder travelOrder = new TravelOrder();
            travelOrder.setIdTravelOrder(rs.getInt(1));
            travelOrder.setNama(rs.getString(2));
            travelOrder.setAlamat(rs.getString(3));
            travelOrder.setTelp(rs.getString(5));
            travelOrder.setTglTransaksi(rs.getDate(6));
            travelOrder.setTglBerangkat(rs.getDate(7));
            travelOrder.setJamBerangkat(rs.getTime(8));
            lihatTransaksi.setTravelOrder(travelOrder);

            TravelRegional travelRegional = new TravelRegional();
            travelRegional.setRegional(rs.getString(4));
            travelRegional.setHarga(rs.getInt(10));
            lihatTransaksi.setTravelRegional(travelRegional);

            StatusTravel statusTravel = new StatusTravel();
            statusTravel.setStatus(rs.getString(14));
            lihatTransaksi.setStatusTravel(statusTravel);

            TravelDetailOrder travelDetailOrder = new TravelDetailOrder();
            travelDetailOrder.setCharge(rs.getInt(12));
            lihatTransaksi.setTravelDetailOrder(travelDetailOrder);

            TravelTujuan travelTujuan = new TravelTujuan();
            travelTujuan.setTujuan(rs.getString(9));
            travelTujuan.setHarga(rs.getInt(11));
            lihatTransaksi.setTravelTujuan(travelTujuan);

            listLihatTransaksi.add(lihatTransaksi);
        }
        return listLihatTransaksi;
    }

    public void updateOrder(int idLama, TravelOrder travelOrder) throws Exception {
        String sql = "UPDATE `travel_order` "+
                "SET `tgl_berangkat`=?,`jam_berangkat`=? "+
                "WHERE `id_travel_order`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setDate(1, travelOrder.getTglBerangkat());
        st.setTime(2, travelOrder.getJamBerangkat());
        st.setInt(3, idLama);
        st.executeUpdate();
        st.close();
    }

    public void updateDetailOrder(int idLama, TravelDetailOrder travelDetailOrder) throws Exception {
        String sql = "UPDATE `travel_detail_order` "+
                "SET `id_travel_tujuan`=?,`id_status_travel`=?,`charge`=? "+
                "WHERE `id_travel_order`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setString(1, travelDetailOrder.getTravelTujuan().getIdTravelTujuan());
        st.setString(2, travelDetailOrder.getStatusTravel().getIdStatusTravel());
        st.setLong(3, travelDetailOrder.getCharge());
        st.setInt(4, idLama);
        st.executeUpdate();
        st.close();
    }

    public void deleteDetailOrder(int idTravelOrder) throws Exception {
        String sql = "DELETE FROM `travel_detail_order` WHERE `id_travel_order`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setInt(1, idTravelOrder);
        st.executeUpdate();
        st.close();
    }

    public void deleteOrder(int idTravelOrder) throws Exception {
        String sql = "DELETE FROM `travel_order` WHERE `id_travel_order`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setInt(1, idTravelOrder);
        st.executeUpdate();
        st.close();
    }

    public LihatTransaksi getTransaksi(int idTravelOrder) throws Exception {
        String sql = "SELECT * FROM `lihat_transaksi` WHERE `id_travel_order`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        LihatTransaksi lihatTransaksi = null;
        st.setInt(1, idTravelOrder);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            lihatTransaksi = new LihatTransaksi();
            lihatTransaksi.setTotal(rs.getInt(13));

            TravelOrder travelOrder = new TravelOrder();
            travelOrder.setIdTravelOrder(rs.getInt(1));
            travelOrder.setNama(rs.getString(2));
            travelOrder.setAlamat(rs.getString(3));
            travelOrder.setTelp(rs.getString(5));
            travelOrder.setTglTransaksi(rs.getDate(6));
            travelOrder.setTglBerangkat(rs.getDate(7));
            travelOrder.setJamBerangkat(rs.getTime(8));
            lihatTransaksi.setTravelOrder(travelOrder);

            TravelRegional travelRegional = new TravelRegional();
            travelRegional.setRegional(rs.getString(4));
            travelRegional.setHarga(rs.getInt(10));
            lihatTransaksi.setTravelRegional(travelRegional);

            StatusTravel statusTravel = new StatusTravel();
            statusTravel.setStatus(rs.getString(14));
            lihatTransaksi.setStatusTravel(statusTravel);

            TravelDetailOrder travelDetailOrder = new TravelDetailOrder();
            travelDetailOrder.setCharge(rs.getInt(12));
            lihatTransaksi.setTravelDetailOrder(travelDetailOrder);

            TravelTujuan travelTujuan = new TravelTujuan();
            travelTujuan.setTujuan(rs.getString(9));
            travelTujuan.setHarga(rs.getInt(11));
            lihatTransaksi.setTravelTujuan(travelTujuan);
        }
        return lihatTransaksi;
    }

    

}
