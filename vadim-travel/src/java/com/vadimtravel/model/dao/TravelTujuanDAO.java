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
    public List<TravelTujuan> getTujuan() throws Exception;
}
