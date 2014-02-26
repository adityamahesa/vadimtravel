/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.entity;

/**
 *
 * @author adityamahesa
 */
public class LihatTransaksi {
    private TravelOrder travelOrder;
    private TravelRegional travelRegional;
    private TravelDetailOrder travelDetailOrder;
    private StatusTravel statusTravel;
    private TravelTujuan travelTujuan;
    private int total;
    public LihatTransaksi(){

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
     * @return the travelDetailOrder
     */
    public TravelDetailOrder getTravelDetailOrder() {
        return travelDetailOrder;
    }

    /**
     * @param travelDetailOrder the travelDetailOrder to set
     */
    public void setTravelDetailOrder(TravelDetailOrder travelDetailOrder) {
        this.travelDetailOrder = travelDetailOrder;
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
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

}
