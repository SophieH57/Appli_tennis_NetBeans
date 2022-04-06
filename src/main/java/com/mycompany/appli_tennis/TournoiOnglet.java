/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appli_tennis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Utilisateur
 */
public class TournoiOnglet {
    Identifiant_connexion IdC = new Identifiant_connexion();
    private final Connection con = IdC.seConnecter();
    
   int ID_Joueur;
   private String nomJoueur;
   private String prenomJoueur;
   private String sexeJoueur;
   private String codeTournoi;
   private String nomTournoi;
   private int annee;
   
   JoueurOnglet BDDTournoi = new JoueurOnglet();
       
    public void afficherTournois(DefaultTableModel tTournoi){
    BDDTournoi.deleteAllRows(tTournoi);
     try {
    PreparedStatement pstmt = con.prepareStatement("select tournoi.CODE, tournoi.NOM from tournoi");
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()){
        codeTournoi = rs.getString("tournoi.CODE");
        nomTournoi = rs.getString("tournoi.NOM");
        tTournoi.insertRow(tTournoi.getRowCount(), new Object[]{codeTournoi,nomTournoi});
        }
 }
     catch (Exception e){
         System.out.println("e");
     }
}
    
public void listeAnnees(JComboBox box){
    box.addItem("Toutes");
    ArrayList<Integer> annees = new ArrayList<>();
    try {
        PreparedStatement pstmt = con.prepareStatement("select ANNEE from epreuve");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            annee = rs.getInt("ANNEE");
            if (!annees.contains(annee)) box.addItem(annee);
            annees.add(annee);
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
   BDDTournoi.deleteAllRows(tTournoi);
    try{
        PreparedStatement pstmt = con.prepareStatement("select tournoi.code, tournoi.`NOM` , epreuve.`ANNEE`, joueur.`NOM`, joueur.`PRENOM`, joueur.SEXE " +
        "from tournoi inner join epreuve inner join match_tennis inner join joueur " +
        "where tournoi.`NOM` = ? and tournoi.`ID` = epreuve.`ID_TOURNOI` and epreuve.`ID`=match_tennis.`ID_EPREUVE` and joueur.`ID`=match_tennis.`ID_VAINQUEUR`");
        pstmt.setString(1, nomTournoi);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            codeTournoi = rs.getString("tournoi.CODE");
            annee = rs.getInt("ANNEE");
            nomJoueur = rs.getString("joueur.NOM");
            prenomJoueur = rs.getString("joueur.PRENOM");
            sexeJoueur = rs.getString("SEXE");
            tTournoi.insertRow(tTournoi.getRowCount(), new Object[]{codeTournoi,nomTournoi, annee,nomJoueur,prenomJoueur,sexeJoueur});
        }
    }catch (Exception e){
        System.out.println("e");
    }
}

public void triAnnee(DefaultTableModel tTounoi, String an){
        BDDTournoi.deleteAllRows(tTounoi);
    try{
        PreparedStatement pstmt = con.prepareStatement("select tournoi.CODE, tournoi.`NOM` , epreuve.`ANNEE`, joueur.`NOM`, joueur.`PRENOM`, joueur.SEXE " +
        "from tournoi inner join epreuve inner join match_tennis inner join joueur " +
        "where epreuve.`ANNEE`=? and tournoi.`ID` = epreuve.`ID_TOURNOI` and epreuve.`ID`=match_tennis.`ID_EPREUVE` and joueur.`ID`=match_tennis.`ID_VAINQUEUR`");
        pstmt.setString(1, an);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            codeTournoi = rs.getString("tournoi.CODE");
            nomTournoi = rs.getString("tournoi.NOM");
            nomJoueur = rs.getString("joueur.NOM");
            prenomJoueur = rs.getString("joueur.PRENOM");
            sexeJoueur = rs.getString("SEXE");
            tTounoi.insertRow(tTounoi.getRowCount(), new Object[]{codeTournoi, nomTournoi, an,nomJoueur,prenomJoueur,sexeJoueur});
        }
    }catch (Exception e){
        System.out.println("e");
    }
}

public void addTournoi(DefaultTableModel model, String codeTournoi, String nomTournoi){
    try {
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO tournoi (NOM, CODE) values (?,?)");
        pstmt.setString(1, nomTournoi);
        pstmt.setString(2, codeTournoi);
        pstmt.executeUpdate();
    } catch (Exception e) {
            System.out.println(e);
        }
        afficherTournois(model);
}

public int recupererId(DefaultTableModel model, String code, String nom){
   int Id = 0;
    try{
        PreparedStatement pstmt = con.prepareStatement("select ID from tournoi where CODE = ? OR NOM = ?");
        pstmt.setString(1, code);
        pstmt.setString(2, nom);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            Id = rs.getInt("ID");
            System.out.println(Id);
        }
    }
    catch(Exception e){
        System.out.println(e);
    }
    return Id;
}

public void updateTournoi(DefaultTableModel model, int IdAModif, String modifCode, String modifNomTournoi){
    try {
        PreparedStatement pstmt = con.prepareStatement("UPDATE tournoi SET CODE = ?, NOM = ? where ID = ?");
        pstmt.setString(1, modifCode);
        pstmt.setString(2, modifNomTournoi);
        pstmt.setInt(3, IdAModif);
        pstmt.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
    }
}

public void deleteTournoi(DefaultTableModel model, int IdASup){
    try {
        PreparedStatement pstmt = con.prepareStatement("DELETE from tournoi where ID = ?");
        pstmt.setInt(1, IdASup);
        pstmt.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
        }
    afficherTournois(model);
}

public void afficherVainqueursTournois(DefaultTableModel tTournoi){
    BDDTournoi.deleteAllRows(tTournoi);
     try {
    PreparedStatement pstmt = con.prepareStatement("select tournoi.CODE, tournoi.NOM , epreuve.ANNEE, joueur.NOM, joueur.PRENOM, joueur.SEXE " +
"from tournoi inner join epreuve inner join match_tennis inner join joueur " +
"where tournoi.`ID` = epreuve.`ID_TOURNOI` and epreuve.`ID`=match_tennis.`ID_EPREUVE` and joueur.`ID`=match_tennis.`ID_VAINQUEUR`");
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()){
        codeTournoi = rs.getString("tournoi.CODE");
        nomTournoi = rs.getString("tournoi.NOM");
        annee = rs.getInt("epreuve.ANNEE");
        nomJoueur = rs.getString("joueur.NOM");
        prenomJoueur = rs.getString("joueur.prenom");
        sexeJoueur = rs.getString("joueur.sexe");
        tTournoi.insertRow(tTournoi.getRowCount(), new Object[]{codeTournoi,nomTournoi,annee,nomJoueur,prenomJoueur,sexeJoueur});
        }
 }
     catch (Exception e){
         System.out.println("e");
     }
}

public void searchTournoi(DefaultTableModel model, String texte){
    BDDTournoi.deleteAllRows(model);
    try {
        PreparedStatement pstmt = con.prepareStatement("select tournoi.code, tournoi.nom from tournoi where code like '%"+texte+"%' OR nom like '%"+texte+"%'");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            codeTournoi = rs.getString("code");
            nomTournoi = rs.getString("nom");
            model.insertRow(model.getRowCount(), new Object[]{codeTournoi,nomTournoi});
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
    
    
}
