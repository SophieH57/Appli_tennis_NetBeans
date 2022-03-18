/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appli_tennis;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Utilisateur
 */
public class JoueurOnglet{
    
    Identifiant_connexion IdC = new Identifiant_connexion();
   private final Connection con = IdC.seConnecter();
   
   int ID_Joueur;
   private String nomJoueur;
   private String prenomJoueur;
   private String sexeJoueur; 
    
public void deleteAllRows(DefaultTableModel model){
    for (int i=model.getRowCount()-1; i>=0; i--){
        model.removeRow(i);
    }
}

public void clearCT(TextField CT){
    CT.setText("");
}
 public void listeJoueurs(DefaultTableModel model){
     deleteAllRows(model);
     try {
    PreparedStatement pstmt = con.prepareStatement("SELECT * from joueur");
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()){
        ID_Joueur = rs.getInt("ID");
        nomJoueur = rs.getString("NOM");
        prenomJoueur = rs.getString("PRENOM");
        sexeJoueur = rs.getString("SEXE");
        model.insertRow(model.getRowCount(), new Object[]{ID_Joueur,nomJoueur,prenomJoueur,sexeJoueur});
        }
 }
     catch (Exception e){
         System.out.println("e");
     }
 }
 
 public void triParGenre(DefaultTableModel model, String genre){
    deleteAllRows(model);
    try{
        PreparedStatement pstmt = con.prepareStatement("SELECT * from joueur where sexe=?");
        pstmt.setString(1, genre);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            ID_Joueur = rs.getInt("ID");
            nomJoueur = rs.getString("NOM");
            prenomJoueur = rs.getString("PRENOM");
            sexeJoueur = rs.getString("SEXE");
            model.insertRow(model.getRowCount(), new Object[]{ID_Joueur,nomJoueur,prenomJoueur,sexeJoueur});
        }
    }catch (Exception e){
        System.out.println("e");
    }
 }
    
public void deleteJoueur(DefaultTableModel model, int Id){
    try {
        PreparedStatement pstmt = con.prepareStatement("DELETE from joueur where ID = ?");
        pstmt.setInt(1, Id);
        pstmt.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
        }
    listeJoueurs(model);
    }

public void addJoueur(DefaultTableModel model, String nom, String prenom, String sexe){
    try {
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO joueur (NOM, PRENOM, SEXE) values (?, ?, ?)");
        pstmt.setString(1, nom);
        pstmt.setString(2, prenom);
        pstmt.setString(3, sexe);
        pstmt.executeUpdate();
    } catch (Exception e) {
            System.out.println(e);
        }
        listeJoueurs(model);
}

public void updateJoueur(DefaultTableModel model, String nom, String prenom, String sexe, int Id){
    try {
        PreparedStatement pstmt = con.prepareStatement("UPDATE joueur SET NOM = ?, PRENOM = ? , SEXE= ? where ID = ?");
        pstmt.setString(1, nom);
        pstmt.setString(2, prenom);
        pstmt.setString(3, sexe);
        pstmt.setInt(4, Id);
        pstmt.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
    }
    listeJoueurs(model);
}

public void searchJoueur(DefaultTableModel model, String nom, String prenom){
    deleteAllRows(model);
    String condition = null;
    try {
        if (nom != null && prenom != null){
            condition = "NOM like '%"+nom+"%' AND PRENOM like '%"+prenom+"%'";
        }
        else if(nom != null && prenom == null){
            condition = "NOM like '%"+nom+"%'";
        }
        else if (nom == null && prenom != null){
            condition = "PRENOM like '%"+prenom+"%'";
        }
        PreparedStatement pstmt = con.prepareStatement("select * from joueur where "+condition);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            ID_Joueur = rs.getInt("ID");
            nomJoueur = rs.getString("NOM");
            prenomJoueur = rs.getString("PRENOM");
            sexeJoueur = rs.getString("SEXE");
            model.insertRow(model.getRowCount(), new Object[]{ID_Joueur,nomJoueur,prenomJoueur,sexeJoueur});
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}

public void afficherPopUp(DefaultTableModel pop, int Id_Joueur){
    deleteAllRows(pop);
    String tournoi;
    int année;
    try{
        PreparedStatement pstmt = con.prepareStatement(
        "select tournoi.`NOM`, epreuve.`ANNEE` from match_tennis " +
        "inner join joueur inner join epreuve inner join tournoi " +
        "where joueur.`ID`= "+Id_Joueur+" AND match_tennis.`ID_VAINQUEUR` = joueur.`ID` AND match_tennis.`ID_EPREUVE` = epreuve.`ID`AND epreuve.`ID_TOURNOI` = tournoi.`ID`");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            tournoi = rs.getString("NOM");
            année = rs.getInt("ANNEE");
            pop.insertRow(pop.getRowCount(), new Object[]{tournoi, année});
        }
    }
    catch(Exception e){
        System.out.println(e);
    }
}


}
