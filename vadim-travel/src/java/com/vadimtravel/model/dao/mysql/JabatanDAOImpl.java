/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao.mysql;

import com.vadimtravel.model.dao.JabatanDAO;
import com.vadimtravel.model.entity.Jabatan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public class JabatanDAOImpl implements JabatanDAO {
    private Connection conn;
    public JabatanDAOImpl(Connection conn){
        this.conn = conn;
    }

    public List<Jabatan> getJabatan() throws Exception {
        List<Jabatan> listJabatan = new ArrayList<Jabatan>();
        String sql = "SELECT `id_jabatan`,`nama` FROM `jabatan`";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Jabatan jabatan = new Jabatan();
            jabatan.setIdJabatan(rs.getString(1));
            jabatan.setNama(rs.getString(2));
            listJabatan.add(jabatan);
        }
        return listJabatan;
    }

    public Jabatan getJabatan(String id) throws Exception {
        String sql = "SELECT `id_jabatan`,`nama` FROM `jabatan`"+
                "WHERE `id_jabatan`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        Jabatan jabatan = null;
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            jabatan = new Jabatan();
            jabatan.setIdJabatan(rs.getString(1));
            jabatan.setNama(rs.getString(2));
        }
        return jabatan;
    }

}
