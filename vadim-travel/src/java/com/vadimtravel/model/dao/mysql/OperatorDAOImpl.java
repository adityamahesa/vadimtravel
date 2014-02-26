/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao.mysql;

import com.vadimtravel.model.dao.OperatorDAO;
import com.vadimtravel.model.entity.Jabatan;
import com.vadimtravel.model.entity.Operator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public class OperatorDAOImpl implements OperatorDAO{
    private Connection conn;
    public OperatorDAOImpl(Connection conn){
        this.conn = conn;
    }

    public void insert(Operator operator) throws Exception {
        String sql = "INSERT INTO `operator` "+
                "(`nama`,`username`,`password`,`id_jabatan`) "+
                "VALUES (?,?,?,?)";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setString(1, operator.getNama());
        st.setString(2, operator.getUsername());
        st.setString(3, operator.getPassword());
        st.setString(4, operator.getJabatan().getIdJabatan());
        st.executeUpdate();
        st.close();
    }
    
    public void delete(int idOperator) throws Exception {
        String sql = "DELETE FROM `operator` WHERE `id_operator`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setInt(1, idOperator);
        st.executeUpdate();
        st.close();
    }

    public Operator login(String username, String password) throws Exception {
        Operator operator = null;
        String sql = "SELECT `id_operator`,`nama`,`username`,`password`,`id_jabatan`"+
                "FROM `operator` WHERE `username`=? AND `password`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            operator = new Operator();
            operator.setIdOperator(rs.getInt(1));
            operator.setNama(rs.getString(2));
            operator.setUsername(rs.getString(3));
            operator.setPassword(rs.getString(4));
            Jabatan jabatan = new Jabatan();
            jabatan.setIdJabatan(rs.getString(5));
            operator.setJabatan(jabatan);
        }
        return operator;
    }

    public List<Operator> getOperator() throws Exception {
        List<Operator> listOperator = new ArrayList<Operator>();
        String sql = "SELECT `id_operator`,`nama`,`username`,`id_jabatan` FROM `operator`";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Operator operator = new Operator();
            operator.setIdOperator(rs.getInt(1));
            operator.setNama(rs.getString(2));
            operator.setUsername(rs.getString(3));
            Jabatan jabatan = new Jabatan();
            jabatan.setIdJabatan(rs.getString(4));
            operator.setJabatan(jabatan);
            listOperator.add(operator);

        }
        return listOperator;
    }

    public Operator getOperator(int id) throws Exception {
        String sql = "SELECT `id_operator`,`nama`,`username`,`id_jabatan` FROM `operator` "+
                "WHERE `id_operator`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        Operator operator = null;
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            operator = new Operator();
            operator.setIdOperator(rs.getInt(1));
            operator.setNama(rs.getString(2));
            operator.setUsername(rs.getString(3));
            Jabatan jabatan = new Jabatan();
            jabatan.setIdJabatan(rs.getString(4));
            operator.setJabatan(jabatan);
        }
        return operator;
    }

    public void update(int idLama, Operator operator) throws Exception {
        String sql = "UPDATE `operator` SET `nama`=?,`username`=?,`id_jabatan`=? WHERE `id_operator`=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setString(1, operator.getNama());
        st.setString(2, operator.getUsername());
        st.setString(3, operator.getJabatan().getIdJabatan());
        st.setInt(4, idLama);
        st.executeUpdate();
        st.close();
    }

}
