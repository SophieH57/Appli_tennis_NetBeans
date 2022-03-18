/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appli_tennis;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Utilisateur
 */
public class Identifiant_connexion {
   private final String url = "jdbc:mysql://localhost:3306/tennis?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
   private final String login = "root";
   private final String password="";
   private Connection connexion;
    
    public Connection seConnecter(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connexion;
    }
    
    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }
    
    public String getPassword() {
        return password;
    }
  
}
