/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao;

import com.vadimtravel.model.entity.TravelDetailOrder;
import com.vadimtravel.model.entity.TravelOrder;

/**
 *
 * @author adityamahesa
 */
public interface PreOrderDAO {
    public void insertOrder(TravelOrder travelOrder) throws Exception;
    public void insertDetailOrder(TravelDetailOrder travelDetailOrder)
            throws Exception;
}
