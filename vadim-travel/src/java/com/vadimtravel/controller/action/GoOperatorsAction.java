/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.OperatorDAO;
import com.vadimtravel.model.dao.mysql.OperatorDAOImpl;
import com.vadimtravel.model.entity.Operator;
import com.vadimtravel.util.MySQL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adityamahesa
 */
public class GoOperatorsAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        String result = "operator.jsp";
//        HttpSession session = request.getSession();
//        if(session.getAttribute("jabatan") == null){
//            result = "controller?action=officelogin";
//        }else{
//            if(session.getAttribute("jabatan") == "adm"){
//                result = "operator.jsp";
//            }else{
//                result = "controller?action=office";
//            }
//        }
        MySQL mySQL = new MySQL();
        List<Operator> listOperator = new ArrayList<Operator>();
        OperatorDAO opDAO = new OperatorDAOImpl(mySQL.getConn());
        try{
            listOperator = opDAO.getOperator();
        }catch(Exception e){
            request.setAttribute("msg", e.getMessage());
        }finally{
            mySQL.closeConn();
        }
        request.setAttribute("operator", listOperator);
        return result;
    }

}
