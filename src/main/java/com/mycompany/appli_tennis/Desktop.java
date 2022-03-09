/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.appli_tennis;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Utilisateur
 */
public class Desktop extends javax.swing.JFrame{
   DefaultTableModel model;
   DefaultTableModel pop;
   DefaultTableModel tTournoi;
   BDD BDDjoueur = new BDD();
    JFrame popUpSelect = new PopUpSelection();
    JFrame popUpAdd = new PopUpAdd();
   
    public Desktop() {
        initComponents();
        model = (DefaultTableModel)TabJoueurs.getModel();
        pop = (DefaultTableModel)PopTournoi.getModel();
        tTournoi = (DefaultTableModel) TabMatch.getModel();
        BDDjoueur.listeAnnees(Choix_annee);
        BDDjoueur.listeNomTournois(choix_tournoi);
        this.setBounds(300, 100, 1050, 700);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Frame_Joueur = new javax.swing.JTabbedPane();
        Joueur = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabJoueurs = new javax.swing.JTable();
        Choix_genre = new javax.swing.JComboBox<>();
        Nom = new java.awt.Label();
        CT_nom = new java.awt.TextField();
        Sexe1 = new java.awt.Label();
        Prenom = new java.awt.Label();
        CT_prenom = new java.awt.TextField();
        BT_joueurs = new java.awt.Button();
        BT_Modif = new java.awt.Button();
        Prenom1 = new java.awt.Label();
        BT_Supprimer = new java.awt.Button();
        BT_SearchJ = new java.awt.Button();
        BT_Add = new java.awt.Button();
        Choix_sexe = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        PopTournoi = new javax.swing.JTable();
        Tournois_gagnes = new java.awt.Label();
        Match = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabMatch = new javax.swing.JTable();
        choix_tournoi = new javax.swing.JComboBox<>();
        Choix_annee = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BT_Tournoi = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        TabJoueurs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Joueur", "Nom", "Prénom", "Sexe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabJoueurs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabJoueursMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabJoueurs);

        Choix_genre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aucun tri", "F", "H" }));
        Choix_genre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Choix_genreItemStateChanged(evt);
            }
        });

        Nom.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Nom.setText("Nom");

        Sexe1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Sexe1.setText("Tri par genre");

        Prenom.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Prenom.setText("Prénom");

        BT_joueurs.setLabel("Afficher tous les joueurs");
        BT_joueurs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_joueursMouseClicked(evt);
            }
        });

        BT_Modif.setActionCommand("BT_SearchJ");
        BT_Modif.setBackground(new java.awt.Color(0, 204, 255));
        BT_Modif.setForeground(new java.awt.Color(51, 102, 255));
        BT_Modif.setLabel("Modifier");
        BT_Modif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_ModifMouseClicked(evt);
            }
        });

        Prenom1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Prenom1.setText("Sexe");

        BT_Supprimer.setActionCommand("BT_SearchJ");
        BT_Supprimer.setBackground(new java.awt.Color(0, 204, 255));
        BT_Supprimer.setForeground(new java.awt.Color(51, 102, 255));
        BT_Supprimer.setLabel("Supprimer");
        BT_Supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_SupprimerMouseClicked(evt);
            }
        });

        BT_SearchJ.setActionCommand("BT_SearchJ");
        BT_SearchJ.setBackground(new java.awt.Color(0, 204, 255));
        BT_SearchJ.setForeground(new java.awt.Color(51, 102, 255));
        BT_SearchJ.setLabel("Rechercher");
        BT_SearchJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_SearchJMouseClicked(evt);
            }
        });

        BT_Add.setActionCommand("BT_Add");
        BT_Add.setBackground(new java.awt.Color(0, 204, 255));
        BT_Add.setForeground(new java.awt.Color(51, 102, 255));
        BT_Add.setLabel("Ajouter");
        BT_Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_AddMouseClicked(evt);
            }
        });

        Choix_sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "F", "H" }));

        PopTournoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tournoi", "Année"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PopTournoi.setShowHorizontalLines(false);
        PopTournoi.setShowVerticalLines(false);
        jScrollPane3.setViewportView(PopTournoi);

        Tournois_gagnes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Tournois_gagnes.setText("Tournois gagnés");

        javax.swing.GroupLayout JoueurLayout = new javax.swing.GroupLayout(Joueur);
        Joueur.setLayout(JoueurLayout);
        JoueurLayout.setHorizontalGroup(
            JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JoueurLayout.createSequentialGroup()
                .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JoueurLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Prenom1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CT_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Choix_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(238, 238, 238)
                        .addComponent(Choix_genre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JoueurLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(BT_Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(BT_Modif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(BT_Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JoueurLayout.createSequentialGroup()
                        .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JoueurLayout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(BT_SearchJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JoueurLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BT_joueurs, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154)))
                        .addComponent(Sexe1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JoueurLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JoueurLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Tournois_gagnes, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JoueurLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        JoueurLayout.setVerticalGroup(
            JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JoueurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JoueurLayout.createSequentialGroup()
                        .addComponent(BT_joueurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JoueurLayout.createSequentialGroup()
                                .addComponent(BT_SearchJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(JoueurLayout.createSequentialGroup()
                                .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CT_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sexe1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CT_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Choix_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JoueurLayout.createSequentialGroup()
                                        .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Prenom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Choix_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                        .addGroup(JoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BT_Add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BT_Modif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JoueurLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(BT_Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(JoueurLayout.createSequentialGroup()
                        .addComponent(Tournois_gagnes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Frame_Joueur.addTab("Joueur", Joueur);

        TabMatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tournoi", "Année", "Nom du vainqueur", "Prénom du vainqueur", "Sexe du vainqueur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TabMatch);

        choix_tournoi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choix_tournoiItemStateChanged(evt);
            }
        });

        Choix_annee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Choix_anneeItemStateChanged(evt);
            }
        });

        jLabel1.setText("Tournoi");

        jLabel2.setText("Année");

        BT_Tournoi.setLabel("Afficher les tournois");
        BT_Tournoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_TournoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MatchLayout = new javax.swing.GroupLayout(Match);
        Match.setLayout(MatchLayout);
        MatchLayout.setHorizontalGroup(
            MatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MatchLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MatchLayout.createSequentialGroup()
                .addGroup(MatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MatchLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(BT_Tournoi, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(choix_tournoi, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MatchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Choix_annee, 0, 92, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(216, 216, 216))
        );
        MatchLayout.setVerticalGroup(
            MatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Tournoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choix_tournoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Choix_annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Frame_Joueur.addTab("Tournoi", Match);

        getContentPane().add(Frame_Joueur);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Choix_genreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Choix_genreItemStateChanged
       String genre = Choix_genre.getSelectedItem().toString();
       if (genre.equalsIgnoreCase("Aucun tri")) BDDjoueur.listeJoueurs(model);
       else BDDjoueur.triParGenre(model, genre);
      
       if (genre.equals("F"))TabJoueurs.setBackground(new Color(168,238,121));
       else if (genre.equals("H")) TabJoueurs.setBackground(new Color(194, 246, 244));
       else TabJoueurs.setBackground(new Color(249, 241, 131));
       clearAllTextField();
    }//GEN-LAST:event_Choix_genreItemStateChanged

    private void BT_joueursMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_joueursMouseClicked
        BDDjoueur.listeJoueurs(model);
        clearAllTextField();
        Choix_genre.setSelectedItem("Aucun tri");
        TabJoueurs.setBackground(Color.lightGray);
    }//GEN-LAST:event_BT_joueursMouseClicked

    private void BT_ModifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ModifMouseClicked
        if (TabJoueurs.getSelectedRow() == -1) popUpSelect.setVisible(true);
        else {
        String modifNom = CT_nom.getText();
        String modifPrenom = CT_prenom.getText();
        String modifSexe = Choix_sexe.getSelectedItem().toString();
        int IdAModif = (int) model.getValueAt(TabJoueurs.getSelectedRow(), 0);
        BDDjoueur.updateJoueur(model, modifNom, modifPrenom, modifSexe, IdAModif);
        }
    }//GEN-LAST:event_BT_ModifMouseClicked

    private void BT_SupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_SupprimerMouseClicked
        if (TabJoueurs.getSelectedRow() == -1) popUpSelect.setVisible(true);
        else {
        int Id_Sup = (int) model.getValueAt(TabJoueurs.getSelectedRow(), 0);
        BDDjoueur.deleteJoueur(model, Id_Sup);
        clearAllTextField();
        }
    }//GEN-LAST:event_BT_SupprimerMouseClicked

    private void BT_SearchJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_SearchJMouseClicked
        String searchNom = CT_nom.getText().toUpperCase();
        String searchPrenom = CT_prenom.getText().toUpperCase();
        BDDjoueur.searchJoueur(model, searchNom, searchPrenom);
    }//GEN-LAST:event_BT_SearchJMouseClicked

    private void TabJoueursMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabJoueursMouseClicked
        CT_nom.setText(String.valueOf(model.getValueAt(TabJoueurs.getSelectedRow(), 1)));
        CT_prenom.setText(String.valueOf(model.getValueAt(TabJoueurs.getSelectedRow(), 2)));
        if (String.valueOf(model.getValueAt(TabJoueurs.getSelectedRow(), 3)).equals("F")){
            Choix_sexe.setSelectedIndex(1);
        }
        else if (String.valueOf(model.getValueAt(TabJoueurs.getSelectedRow(), 3)).equals("H")){
            Choix_sexe.setSelectedIndex(2);
        }
        BDDjoueur.afficherPopUp(pop,(int)model.getValueAt(TabJoueurs.getSelectedRow(), 0));
    }//GEN-LAST:event_TabJoueursMouseClicked

    private void BT_AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_AddMouseClicked
        String newNom = CT_nom.getText();
        String newPrenom = CT_prenom.getText();
        String newSexe = Choix_genre.getSelectedItem().toString();
        if (newNom.equals("") || newPrenom.equals("") || newSexe.equals("")){
             popUpAdd.setVisible(true);
        } else {
            BDDjoueur.addJoueur(model, newNom, newPrenom, newSexe);
            clearAllTextField();
        }
    }//GEN-LAST:event_BT_AddMouseClicked

    private void choix_tournoiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choix_tournoiItemStateChanged
        Choix_annee.setSelectedItem("Toutes");
        String nomTournoi = choix_tournoi.getSelectedItem().toString();
        if (nomTournoi.equalsIgnoreCase("Tous")) BDDjoueur.afficherTournois(tTournoi);
        else BDDjoueur.triTournoi(tTournoi, nomTournoi);
    }//GEN-LAST:event_choix_tournoiItemStateChanged

    private void BT_TournoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_TournoiMouseClicked
        BDDjoueur.afficherTournois(tTournoi);
        Choix_annee.setSelectedItem("Toutes");
        choix_tournoi.setSelectedItem("Tous");
    }//GEN-LAST:event_BT_TournoiMouseClicked

    private void Choix_anneeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Choix_anneeItemStateChanged
        choix_tournoi.setSelectedItem("Tous");
        String annee = Choix_annee.getSelectedItem().toString();
        if (annee.equalsIgnoreCase("Toutes")) BDDjoueur.afficherTournois(tTournoi);
        else BDDjoueur.triAnnee(tTournoi, annee);
    }//GEN-LAST:event_Choix_anneeItemStateChanged

    public void clearAllTextField(){
        BDDjoueur.clearCT(CT_nom);
        BDDjoueur.clearCT(CT_prenom);
        Choix_sexe.setSelectedIndex(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Desktop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button BT_Add;
    private java.awt.Button BT_Modif;
    private java.awt.Button BT_SearchJ;
    private java.awt.Button BT_Supprimer;
    private java.awt.Button BT_Tournoi;
    private java.awt.Button BT_joueurs;
    private java.awt.TextField CT_nom;
    private java.awt.TextField CT_prenom;
    private javax.swing.JComboBox<String> Choix_annee;
    private javax.swing.JComboBox<String> Choix_genre;
    private javax.swing.JComboBox<String> Choix_sexe;
    private javax.swing.JTabbedPane Frame_Joueur;
    private javax.swing.JPanel Joueur;
    private javax.swing.JPanel Match;
    private java.awt.Label Nom;
    private javax.swing.JTable PopTournoi;
    private java.awt.Label Prenom;
    private java.awt.Label Prenom1;
    private java.awt.Label Sexe1;
    private javax.swing.JTable TabJoueurs;
    private javax.swing.JTable TabMatch;
    private java.awt.Label Tournois_gagnes;
    private javax.swing.JComboBox<String> choix_tournoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
