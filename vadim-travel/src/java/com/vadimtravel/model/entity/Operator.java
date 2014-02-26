/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.entity;

/**
 *
 * @author adityamahesa
 */
public class Operator {
    private int idOperator;
    private String nama;
    private String username;
    private String password;
    private Jabatan jabatan;
    public Operator(){
        
    }

    /**
     * @return the idOperator
     */
    public int getIdOperator() {
        return idOperator;
    }

    /**
     * @param idOperator the idOperator to set
     */
    public void setIdOperator(int idOperator) {
        this.idOperator = idOperator;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the jabatan
     */
    public Jabatan getJabatan() {
        return jabatan;
    }

    /**
     * @param jabatan the jabatan to set
     */
    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }
}
