/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appli_tennis;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Utilisateur
 */
public class BDD{
    
    Identifiant_connexion IdC = new Identifiant_connexion();
   private String url = IdC.getUrl();
   private String login = IdC.getLogin();
   private String password= IdC.getPassword();
   
   int ID_Joueur;
   private String nomJoueur;
   private String prenomJoueur;
   private String sexeJoueur;
   private Connection con;
   private String nomTournoi;
   private int annee;
   private int numRow;
   
    public BDD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, login, password);
            System.out.println("connexion réussie");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 
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
    numRow = 0;
    while (rs.next()){
        numRow++;
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
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);
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
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);
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

public void afficherTournois(DefaultTableModel tTournoi){
    deleteAllRows(tTournoi);
     try {
    PreparedStatement pstmt = con.prepareStatement("select tournoi.NOM , epreuve.ANNEE, joueur.NOM, joueur.PRENOM , joueur.SEXE " +
"from tournoi inner join epreuve inner join match_tennis inner join joueur " +
"where tournoi.`ID` = epreuve.`ID_TOURNOI` and epreuve.`ID`=match_tennis.`ID_EPREUVE` and joueur.`ID`=match_tennis.`ID_VAINQUEUR`");
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()){
        nomTournoi = rs.getString("tournoi.NOM");
        annee = rs.getInt("ANNEE");
        nomJoueur = rs.getString("joueur.NOM");
        prenomJoueur = rs.getString("joueur.PRENOM");
        sexeJoueur = rs.getString("SEXE");
        tTournoi.insertRow(tTournoi.getRowCount(), new Object[]{nomTournoi, annee,nomJoueur,prenomJoueur,sexeJoueur});
        }
 }
     catch (Exception e){
         System.out.println("e");
     }
}

public void listeAnnees(JComboBox box){
    int annee;
    box.addItem("Toutes");
    try {
        PreparedStatement pstmt = con.prepareStatement("select ANNEE from epreuve");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            annee = rs.getInt("ANNEE");
            box.addItem(annee);
        }
    }
    catch (Exception e){
            System.out.println(e);
            }
    }

public void listeNomTournois(JComboBox box){
    String tournoi;
    box.addItem("Tous");
    try{
        PreparedStatement pstmt = con.prepareStatement("select tournoi.NOM from tournoi");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            tournoi = rs.getString("NOM");
            box.addItem(tournoi);
        }
    }
    catch(Exception e){
        System.out.println(e);
    }
}

public void triTournoi(DefaultTableModel tTournoi, String nomTournoi){
    deleteAllRows(tTournoi);
    try{
        PreparedStatement pstmt = con.prepareStatement("select tournoi.`NOM` , epreuve.`ANNEE`, joueur.`NOM`, joueur.`PRENOM`, joueur.SEXE " +
        "from tournoi inner join epreuve inner join match_tennis inner join joueur " +
        "where tournoi.`NOM` = ? and tournoi.`ID` = epreuve.`ID_TOURNOI` and epreuve.`ID`=match_tennis.`ID_EPREUVE` and joueur.`ID`=match_tennis.`ID_VAINQUEUR`");
        pstmt.setString(1, nomTournoi);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            nomTournoi = rs.getString("tournoi.NOM");
            annee = rs.getInt("ANNEE");
            nomJoueur = rs.getString("joueur.NOM");
            prenomJoueur = rs.getString("joueur.PRENOM");
            sexeJoueur = rs.getString("SEXE");
            tTournoi.insertRow(tTournoi.getRowCount(), new Object[]{nomTournoi, annee,nomJoueur,prenomJoueur,sexeJoueur});
        }
    }catch (Exception e){
        System.out.println("e");
    }
}

public void triAnnee(DefaultTableModel tTounoi, String an){
        deleteAllRows(tTounoi);
    try{
        PreparedStatement pstmt = con.prepareStatement("select tournoi.`NOM` , epreuve.`ANNEE`, joueur.`NOM`, joueur.`PRENOM`, joueur.SEXE " +
        "from tournoi inner join epreuve inner join match_tennis inner join joueur " +
        "where epreuve.`ANNEE`=? and tournoi.`ID` = epreuve.`ID_TOURNOI` and epreuve.`ID`=match_tennis.`ID_EPREUVE` and joueur.`ID`=match_tennis.`ID_VAINQUEUR`");
        pstmt.setString(1, an);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            nomTournoi = rs.getString("tournoi.NOM");
            annee = rs.getInt("ANNEE");
            nomJoueur = rs.getString("joueur.NOM");
            prenomJoueur = rs.getString("joueur.PRENOM");
            sexeJoueur = rs.getString("SEXE");
            tTounoi.insertRow(tTounoi.getRowCount(), new Object[]{nomTournoi, annee,nomJoueur,prenomJoueur,sexeJoueur});
        }
    }catch (Exception e){
        System.out.println("e");
    }
}
}

