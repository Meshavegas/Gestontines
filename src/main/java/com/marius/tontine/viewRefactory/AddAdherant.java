package com.marius.tontine.viewRefactory;

import com.marius.tontine.controller.AdherantController;
import com.marius.tontine.modele.Adherant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAdherant {
    @FXML
    private Button adh_anuler;

    @FXML
    private TextField adh_dataad;

    @FXML
    private TextField adh_datn;

    @FXML
    private TextField adh_mail;

    @FXML
    private TextField adh_nom;

    @FXML
    private TextField adh_numtel;

    @FXML
    private TextField adh_prenom;

    @FXML
    private TextField adh_sexe;

    @FXML
    private Text adh_statut;

    @FXML
    private Button adh_valider;
    @FXML
    public void addAdhereant(ActionEvent e){
        Adherant adh = new Adherant();
        try {

            if(e.getSource() == adh_valider) {
                adh_valider.setDisable(true);
                boolean error = false;

                System.out.println(adh_nom.getText().toString());
                if(adh_nom.getText().toString().length() > 3) {
                    adh.setNom(adh_nom.getText().toString());
                    adh.setPrenom(adh_prenom.getText().toString());

                }else {
                    error = true;
                    adh_valider.setDisable(!error);
                    adh_statut.setText("veuillez remplir le champ Nom");
                }


                if(adh_mail.getText().toString().length()>1) {
                    adh.setEmail(adh_mail.getText().toString());

                }else{}

                if(adh_numtel.getText().toString().length()>1) {
                    adh.setContact(Integer.valueOf(adh_numtel.getText().toString()));


                }else
                {
                    error = true;
                    adh_statut.setText("veuillez remplir le champ Numero");

                }

                if(adh_dataad.getText().toString().length()>1) {

                    try {
                        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse( adh_dataad.getText().toString());

                        java.sql.Date dataAdh = new java.sql.Date(date1.getTime());

                        adh.setDateAdhesion(dataAdh);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }

                }else
                {
                    error = true;
                    adh_statut.setText("veuillez remplir le champ date d'adhésion");
                }
                if(adh_sexe.getText().toString().length()>=1) {
                    adh.setSexe(adh_sexe.getText().toString());

                }else
                {
                    error = true;
                    adh_statut.setText("veuillez remplir le champ Sexe");
                }

                if(adh_datn.getText().toString().length()>1) {
                    try {
                        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse( adh_datn.getText().toString());

                        java.sql.Date dataAdh = new java.sql.Date(date1.getTime());

                        adh.setDateNaissance(dataAdh);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                }


    //			execution
                if(!error) {
                    try {
                        System.out.print(AdherantController.addAdherant(adh));
                        adh_valider.setDisable(false);
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                        adh_valider.setDisable(false);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        adh_valider.setDisable(false);
                    }
                }else {
                    adh_valider.setDisable(false);
                }
            }else {
                Stage stage =(Stage) adh_anuler.getScene().getWindow();
                stage.close();

        }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            adh_statut.setText(ex.getMessage());
        }
    }
}
