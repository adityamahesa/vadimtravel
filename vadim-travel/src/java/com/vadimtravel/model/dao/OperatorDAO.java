/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.model.dao;

import com.vadimtravel.model.entity.Operator;
import java.util.List;

/**
 *
 * @author adityamahesa
 */
public interface OperatorDAO {
    public void insert(Operator operator) throws Exception;
    public void update(int idLama, Operator operator) throws Exception;
    public void delete(int idOperator) throws Exception;
    public Operator login(String username, String password) throws Exception;
    public List<Operator> getOperator() throws Exception;
    public Operator getOperator(int id) throws Exception;
}
