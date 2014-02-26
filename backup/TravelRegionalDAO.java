/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao;

import com.vadimtravel.model.entity.TravelRegional;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public interface TravelRegionalDAO {
    public void insert(TravelRegional travelRegional) throws Exception;
    public void update(String oldId, TravelRegional travelRegional) throws Exception;
    public void delete(String idTravelRegional) throws Exception;
    public TravelRegional getTravelRegional(String idTravelRegional) throws Exception;
    public List<TravelRegional> getTravelRegional() throws Exception;
}
