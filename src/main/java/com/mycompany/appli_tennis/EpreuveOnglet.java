/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appli_tennis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Utilisateur
 */
public class EpreuveOnglet {
    Identifiant_connexion IdC = new Identifiant_connexion();
    private String url = IdC.getUrl();
    private String login = IdC.getLogin();
    private String password= IdC.getPassword();
     private Connection con;
     
     private String nomJoueur;
   private String prenomJoueur;
   private String nomTournoi;
   private int ID_Joueur;
   private int ID_Vainqueur;
   private String statut;
   private String annee;
     
    public EpreuveOnglet(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void affichageParticipants(DefaultTableModel model, String anneeString, String epreuve){
        if (anneeString.equals("Toutes")) annee = "";
        else annee = "and epreuve.`ANNEE` = "+anneeString;
        try {
            PreparedStatement pstmt = con.prepareStatement("select tournoi.nom, joueur.ID, joueur.nom, joueur.prenom, match_tennis.ID_vainqueur, match_tennis.ID_finaliste, joueur.ID " +
"from joueur inner join match_tennis inner join epreuve inner join tournoi " +
"where tournoi.`ID` = epreuve.`ID_TOURNOI` and epreuve.`ID` = match_tennis.`ID_EPREUVE`  " +
"and (joueur.`ID` = match_tennis.`ID_VAINQUEUR` or joueur.`ID` = match_tennis.`ID_FINALISTE`) " +
"and epreuve.`TYPE_EPREUVE` = '"+epreuve+"' "+annee);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                nomJoueur = rs.getString("joueur.nom");
                prenomJoueur = rs.getString("joueur.prenom");
                nomTournoi = rs.getString("tournoi.nom");
                ID_Joueur = rs.getInt("joueur.ID");
                ID_Vainqueur = rs.getInt("match_tennis.ID_VAINQUEUR");
                if (ID_Joueur == ID_Vainqueur) statut = "Vainqueur";
                else statut = "Finaliste";
                model.insertRow(model.getRowCount(), new Object[]{nomTournoi,anneeString, epreuve,nomJoueur,prenomJoueur, statut});
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
