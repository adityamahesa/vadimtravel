/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao;

import com.vadimtravel.model.entity.Jabatan;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public interface JabatanDAO {
    Jabatan getJabatan(String id) throws  Exception;
    List<Jabatan> getJabatan() throws Exception;
}
