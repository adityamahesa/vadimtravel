/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.entity;

/**
 *
 * @author adityamahesa
 */
public class TravelTujuan {
    private String idTravelTujuan;
    private String tujuan;
    private int harga;
    private String deskripsi;
    public TravelTujuan(){

    }

    /**
     * @return the idTravelTujuan
     */
    public String getIdTravelTujuan() {
        return idTravelTujuan;
    }

    /**
     * @param idTravelTujuan the idTravelTujuan to set
     */
    public void setIdTravelTujuan(String idTravelTujuan) {
        this.idTravelTujuan = idTravelTujuan;
    }

    /**
     * @return the tujuan
     */
    public String getTujuan() {
        return tujuan;
    }

    /**
     * @param tujuan the tujuan to set
     */
    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    /**
     * @return the harga
     */
    public int getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }

    /**
     * @return the deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * @param deskripsi the deskripsi to set
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
