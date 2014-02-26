/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao;

import com.vadimtravel.model.entity.TravelOrder;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public interface TravelOrderDAO {
    public void insert(TravelOrder travelOrder) throws Exception;
    public void update(long oldId, TravelOrder travelOrder) throws Exception;
    public void delete(long idTravelOrder) throws Exception;
    public TravelOrder getTravelOrder(long idTravelOrder) throws Exception;
    public List<TravelOrder> getTravelOrder() throws Exception;
    public List<TravelOrder> getTravelOrderByTravelRegional(String idTravelRegional) throws Exception;
}
