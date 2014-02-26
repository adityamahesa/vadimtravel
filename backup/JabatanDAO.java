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
    public void insert(Jabatan jabatan) throws Exception;
    public void update(String oldId, Jabatan jabatan) throws Exception;
    public void delete(String idJabatan) throws Exception;
    /**
     * Melihat tabel `jabatan` berdasarkan `id_jabatan`
     * @param idJabatan
     * @return
     * @throws Exception
     */
    public Jabatan getJabatan(String idJabatan) throws Exception;
    /**
     * Melihat tabel `jabatan`
     * @return
     * @throws Exception
     */
    public List<Jabatan> getJabatan() throws Exception;
}
