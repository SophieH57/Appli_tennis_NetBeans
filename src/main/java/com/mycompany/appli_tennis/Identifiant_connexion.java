/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appli_tennis;

/**
 *
 * @author Utilisateur
 */
public class Identifiant_connexion {
   private String url = "jdbc:mysql://localhost:3306/tennis?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
   private String login = "root";
   private String password="";

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
