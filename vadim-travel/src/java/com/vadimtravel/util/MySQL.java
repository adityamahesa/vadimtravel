/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adityamahesa
 */
public class MySQL {
    private Connection conn = null;
    public MySQL(){
        String URL = "jdbc:mysql://localhost:3306/vadimtravel";
        String USER = "root";
        String PASS = "";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn = DriverManager.getConnection(URL, USER, PASS);
        }catch(Exception ex){

        }
    }
    public Connection getConn(){
        return this.conn;
    }
    public void closeConn(){
        if(this.conn!=null){
            try {
                this.conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
