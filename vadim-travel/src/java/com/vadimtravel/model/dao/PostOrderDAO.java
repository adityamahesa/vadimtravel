/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao;

import com.vadimtravel.model.entity.LihatTransaksi;
import com.vadimtravel.model.entity.TravelDetailOrder;
import com.vadimtravel.model.entity.TravelOrder;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public interface PostOrderDAO {
    public void updateOrder(int idLama, TravelOrder travelOrder) throws Exception;
    public void updateDetailOrder(int idLama, TravelDetailOrder travelDetailOrder) throws Exception;
    public void deleteDetailOrder(int idTravelOrder) throws Exception;
    public void deleteOrder(int idTravelOrder) throws Exception;
    public List<LihatTransaksi> viewTransaksi() throws Exception;
    public LihatTransaksi getTransaksi(int idTravelOrder) throws Exception;
}
