/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.entity;

/**
 *
 * @author adityamahesa
 */
public class TravelDetailOrder {
    private TravelOrder travelOrder;
    private TravelTujuan travelTujuan;
    private StatusTravel statusTravel;
    private long charge;
    public TravelDetailOrder(){

    }

    /**
     * @return the travelOrder
     */
    public TravelOrder getTravelOrder() {
        return travelOrder;
    }

    /**
     * @param travelOrder the travelOrder to set
     */
    public void setTravelOrder(TravelOrder travelOrder) {
        this.travelOrder = travelOrder;
    }

    /**
     * @return the travelTujuan
     */
    public TravelTujuan getTravelTujuan() {
        return travelTujuan;
    }

    /**
     * @param travelTujuan the travelTujuan to set
     */
    public void setTravelTujuan(TravelTujuan travelTujuan) {
        this.travelTujuan = travelTujuan;
    }

    /**
     * @return the statusTravel
     */
    public StatusTravel getStatusTravel() {
        return statusTravel;
    }

    /**
     * @param statusTravel the statusTravel to set
     */
    public void setStatusTravel(StatusTravel statusTravel) {
        this.statusTravel = statusTravel;
    }

    /**
     * @return the charge
     */
    public long getCharge() {
        return charge;
    }

    /**
     * @param charge the charge to set
     */
    public void setCharge(long charge) {
        this.charge = charge;
    }

}
