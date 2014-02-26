/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vadimtravel.controller.action;

import com.vadimtravel.model.dao.mysql.OperatorDAOImpl;
import com.vadimtravel.model.entity.Operator;
import com.vadimtravel.util.MySQL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adityamahesa
 */
public class AuthentificationAction implements ActionInterface{

    public String execute(HttpServletRequest request) {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result = "";

        MySQL mySQL = new MySQL();
        OperatorDAOImpl operatorDAOImpl = new OperatorDAOImpl(mySQL.getConn());
        try{
            Operator op = operatorDAOImpl.login(username, password);
            if(op!=null){
                if(op.getPassword().equals(password)){
                    HttpSession session = request.getSession(true);
                    result="c?action=office";
                    String jab = op.getJabatan().getIdJabatan();
                    session.setAttribute("jabatan", jab);
                    result = "controller?action=office";
                }else{
                    request.setAttribute("msg", "User Name Or Password is not valid");
                    result = "controller?action=officelogin";
                }
            }else{
                request.setAttribute("msg", "User Name Or Password is not valid");
                result = "controller?action=officelogin";
            }
        }catch(Exception ex){

        }finally{
            mySQL.closeConn();
        }
        return result;
    }

}
