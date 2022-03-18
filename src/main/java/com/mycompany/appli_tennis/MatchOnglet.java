/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appli_tennis;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Utilisateur
 */
public class MatchOnglet {
    Identifiant_connexion IdC = new Identifiant_connexion();

   private final Connection con = IdC.seConnecter();
     
   private int ID_Joueur;
   private String nomJoueur;
   private String prenomJoueur;
   private String sexeJoueur;
   private String nomTournoi;
   private int annee;
   private int ID_Vainqueur;
   private String statut;
   
   JoueurOnglet BDDMatch = new JoueurOnglet();
    
    public void triVainqueursFinalistes(DefaultTableModel model, String selectionVainqueur, String selectionTournoi, String type, String textSearch){
        
        try {
            PreparedStatement pstmt = con.prepareStatement("select joueur.nom, joueur.`PRENOM`, joueur.`SEXE`, tournoi.`NOM`, epreuve.annee, match_tennis.ID_VAINQUEUR "
                    + "from joueur inner join match_tennis inner join epreuve inner join tournoi "
                    + "where "+selectionVainqueur+" and match_tennis.`ID_EPREUVE`= epreuve.`ID` and epreuve.`ID_TOURNOI` = tournoi.`ID` "+selectionTournoi+" and (joueur.nom like '%"+textSearch+"%' or joueur.prenom like '%"+textSearch+"%')");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                nomJoueur = rs.getString("joueur.nom");
                prenomJoueur = rs.getString("joueur.prenom");
                sexeJoueur = rs.getString("joueur.sexe");
                nomTournoi = rs.getString("tournoi.nom");
                annee = rs.getInt("epreuve.annee");
                model.insertRow(model.getRowCount(), new Object[]{nomTournoi,annee,nomJoueur,prenomJoueur,sexeJoueur,type});
            }
        }catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void searchJoueur(DefaultTableModel model, String texte, String statusSelected){
    BDDMatch.deleteAllRows(model);
    try {
        PreparedStatement pstmt = con.prepareStatement("select joueur.ID, joueur.nom, joueur.`PRENOM`, joueur.`SEXE`, tournoi.`NOM`, epreuve.annee ,match_tennis.`ID_VAINQUEUR` from joueur " +
"inner join match_tennis inner join epreuve inner join tournoi " +
"where (joueur.NOM like '%"+texte+"%' or joueur.prenom like '%"+texte+"%') and  " +
"match_tennis.`ID_EPREUVE`= epreuve.`ID` and epreuve.`ID_TOURNOI` = tournoi.`ID` "+statusSelected);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            nomJoueur = rs.getString("joueur.nom");
            prenomJoueur = rs.getString("joueur.prenom");
            sexeJoueur = rs.getString("joueur.sexe");
            nomTournoi = rs.getString("tournoi.nom");
            annee = rs.getInt("epreuve.annee");
            ID_Joueur = rs.getInt("joueur.ID");
            ID_Vainqueur = rs.getInt("match_tennis.ID_VAINQUEUR");
            if (ID_Joueur == ID_Vainqueur) statut = "Vainqueur";
            else statut = "Finaliste";
            model.insertRow(model.getRowCount(), new Object[]{nomTournoi,annee,nomJoueur,prenomJoueur,sexeJoueur,statut});
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
}
