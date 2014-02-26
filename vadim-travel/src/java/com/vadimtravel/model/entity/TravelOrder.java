/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.entity;


import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public class TravelOrder {
    private int idTravelOrder;
    private String nama;
    private String alamat;
    private TravelRegional travelRegional;
    private String telp;
    private Date tglTransaksi;
    private Date tglBerangkat;
    private Time jamBerangkat;
    private List<TravelDetailOrder> listOrder = new ArrayList<TravelDetailOrder>();
    public TravelOrder(){

    }

    /**
     * @return the idTravelOrder
     */
    public int getIdTravelOrder() {
        return idTravelOrder;
    }

    /**
     * @param idTravelOrder the idTravelOrder to set
     */
    public void setIdTravelOrder(int idTravelOrder) {
        this.idTravelOrder = idTravelOrder;
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
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the travelRegional
     */
    public TravelRegional getTravelRegional() {
        return travelRegional;
    }

    /**
     * @param travelRegional the travelRegional to set
     */
    public void setTravelRegional(TravelRegional travelRegional) {
        this.travelRegional = travelRegional;
    }

    /**
     * @return the telp
     */
    public String getTelp() {
        return telp;
    }

    /**
     * @param telp the telp to set
     */
    public void setTelp(String telp) {
        this.telp = telp;
    }

    /**
     * @return the tglTransaksi
     */
    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    /**
     * @param tglTransaksi the tglTransaksi to set
     */
    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    /**
     * @return the tglBerangkat
     */
    public Date getTglBerangkat() {
        return tglBerangkat;
    }

    /**
     * @param tglBerangkat the tglBerangkat to set
     */
    public void setTglBerangkat(Date tglBerangkat) {
        this.tglBerangkat = tglBerangkat;
    }

    /**
     * @return the jamBerangkat
     */
    public Time getJamBerangkat() {
        return jamBerangkat;
    }

    /**
     * @param jamBerangkat the jamBerangkat to set
     */
    public void setJamBerangkat(Time jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    /**
     * @return the listOrder
     */
    public List<TravelDetailOrder> getListOrder() {
        return listOrder;
    }

    /**
     * @param listOrder the listOrder to set
     */
    public void setListOrder(List<TravelDetailOrder> listOrder) {
        this.listOrder = listOrder;
    }

    
}
