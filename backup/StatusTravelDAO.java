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
    public void insert(StatusTravel statusTravel) throws Exception;
    public void update(String oldId, StatusTravel statusTravel) throws Exception;
    public void delete(String idStatusTravel) throws Exception;
    public StatusTravel getStatusTravel(String idStatusTravel) throws Exception;
    public List<StatusTravel> getStatusTravel() throws Exception;
}
