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
    public void update(int oldId, Operator operator) throws Exception;
    public void delete(int idOperator) throws Exception;
    public Operator getOperator(int idOperator) throws Exception;
    public List<Operator> getOperator() throws Exception;
    public List<Operator> getOperatorByJabatan() throws Exception;
}
