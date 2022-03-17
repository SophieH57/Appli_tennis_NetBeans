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
public class Connexion {
    Identifiant_connexion Idc = new Identifiant_connexion();
    private Connection con;
    
    public Connection seConnecter(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Idc.getUrl(), Idc.getLogin(), Idc.getPassword());
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
}
}
