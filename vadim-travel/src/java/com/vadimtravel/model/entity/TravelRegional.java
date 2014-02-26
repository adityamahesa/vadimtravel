/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.entity;

/**
 *
 * @author adityamahesa
 */
public class TravelRegional {
    private String idTravelRegional;
    private String regional;
    private long harga;
    public TravelRegional(){

    }

    /**
     * @return the idTravelRegional
     */
    public String getIdTravelRegional() {
        return idTravelRegional;
    }

    /**
     * @param idTravelRegional the idTravelRegional to set
     */
    public void setIdTravelRegional(String idTravelRegional) {
        this.idTravelRegional = idTravelRegional;
    }

    /**
     * @return the regional
     */
    public String getRegional() {
        return regional;
    }

    /**
     * @param regional the regional to set
     */
    public void setRegional(String regional) {
        this.regional = regional;
    }

    /**
     * @return the harga
     */
    public long getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(long harga) {
        this.harga = harga;
    }
}
