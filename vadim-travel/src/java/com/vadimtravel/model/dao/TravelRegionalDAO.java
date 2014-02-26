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
public interface  TravelRegionalDAO {
    TravelRegional getTravelRegional(String id) throws Exception;
    List<TravelRegional> getTravelRegional() throws Exception;
}
