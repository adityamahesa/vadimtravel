/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao;

import com.vadimtravel.model.entity.StatusTravel;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public interface StatusTravelDAO {
    StatusTravel getStatusTravel(String id) throws Exception;
    List<StatusTravel> getStatusTravel() throws Exception;
}
