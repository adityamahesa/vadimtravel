/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao;

import com.vadimtravel.model.entity.TravelTujuan;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public interface TravelTujuanDAO {
    public void insert(TravelTujuan travelTujuan) throws Exception;
    public void update(String oldId, TravelTujuan travelTujuan) throws Exception;
    public void delete(String idTravelTujuan) throws Exception;
    public TravelTujuan getTravelTujuan(String idStatusTravel) throws Exception;
    public List<TravelTujuan> getTravelTujuan() throws Exception;
}
