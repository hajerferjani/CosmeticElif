/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.Controller;

import cosmeticelif.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
    


/**
 *
 * @author USER
 */
public class LoginControl {
    
         Statement st;
         String type;
         
        public  boolean isLogin(User u ){
           
         
            
        try {
             st=ConnectionDB.openConnection().createStatement();
            String check="select * from user where login ='"+u.getLogin()+"' and mot_de_passe = '"+u.getMot_de_passe()+"'";
            ResultSet result =  st.executeQuery(check);
            while(result.next()){
                type=result.getString(3);
                return true;
            }
             ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            System.out.println("hi"+ex.getMessage());
        }
       
       return false;
    }
        
  
    public String getRole(){
        
        if(type.equals("admin"))
            return "admin";
        else
            return "magasinier";
    }
   

    
}