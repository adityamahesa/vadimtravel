/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.entity;

/**
 *
 * @author adityamahesa
 */
public class StatusTravel {
    private String idStatusTravel;
    private String status;
    public StatusTravel(){

    }

    /**
     * @return the idStatusTravel
     */
    public String getIdStatusTravel() {
        return idStatusTravel;
    }

    /**
     * @param idStatusTravel the idStatusTravel to set
     */
    public void setIdStatusTravel(String idStatusTravel) {
        this.idStatusTravel = idStatusTravel;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
