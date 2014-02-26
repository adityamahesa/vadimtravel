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
public interface  TravelOrderDAO {
    TravelOrder getTravelOrder(int idTravelOrder) throws Exception;
    List<TravelOrder> getTravelOrder() throws Exception;
}
