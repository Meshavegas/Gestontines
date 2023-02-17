package com.marius.tontine.viewRefactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Dashbord {
    @FXML
    private TableView<?> SceancesTable;

    @FXML
    private Text ac_adherant;

    @FXML
    private Button ac_btn;

    @FXML
    private Text ac_caisse;

    @FXML
    private TableColumn<?, ?> ac_cr_data;

    @FXML
    private TableColumn<?, ?> ac_cr_dateLimite;

    @FXML
    private TableColumn<?, ?> ac_cr_detenteur;

    @FXML
    private TableColumn<?, ?> ac_cr_id;

    @FXML
    private TableColumn<?, ?> ac_cr_montant;

    @FXML
    private TableView<?> ac_cr_table;

    @FXML
    private Text ac_credit;

    @FXML
    private TableColumn<?, ?> ac_sc_id;

    @FXML
    private TableView<?> ac_sc_table;

    @FXML
    private TableColumn<?, ?> ac_sc_totalCredit;

    @FXML
    private TableColumn<?, ?> ac_sc_totalEpargne;

    @FXML
    private VBox acceuilVbox;

    @FXML
    private GridPane acceuilpane;

    @FXML
    private Button adh_add;

    @FXML
    private TableColumn<?, ?> adh_age;

    @FXML
    private Button adh_btn;

    @FXML
    private TableColumn<?, ?> adh_contact;

    @FXML
    private TableColumn<?, ?> adh_dateInscription;

    @FXML
    private TableColumn<?, ?> adh_email;

    @FXML
    private TableColumn<?, ?> adh_id;

    @FXML
    private TableColumn<?, ?> adh_nom;

    @FXML
    private TableColumn<?, ?> adh_sexe;

    @FXML
    private TableView<?> adherannTable;

    @FXML
    private GridPane adherantPane;

    @FXML
    private VBox adherantVbox;

    @FXML
    private GridPane configurationPane;

    @FXML
    private VBox configurationVbox;

    @FXML
    private Button cr_btn;

    @FXML
    private GridPane creditPane;

    @FXML
    private VBox creditVbox;

    @FXML
    private Button ep_btn;

    @FXML
    private GridPane epargnePane;

    @FXML
    private VBox epargneVbox;

    @FXML
    private TableColumn<?, ?> sc_action;

    @FXML
    private Button sc_btn;

    @FXML
    private Button sc_creeBtn;

    @FXML
    private TableColumn<?, ?> sc_date;

    @FXML
    private TableColumn<?, ?> sc_heure_debut;

    @FXML
    private TableColumn<?, ?> sc_heure_fin;

    @FXML
    private TableColumn<?, ?> sc_id;

    @FXML
    private TextField sc_input;

    @FXML
    private TableColumn<?, ?> sc_lieu;

    @FXML
    private Button sc_recherche;

    @FXML
    private GridPane sceancePane;

    @FXML
    private VBox sceanceVbox;

    @FXML
    void onNavigate(ActionEvent e) {
        if(e.getSource() == ep_btn) {
            System.out.println("epargne");
            epargnePane.toFront();

        }
        else if(e.getSource() == ac_btn) {
            System.out.println("Acceuil");
            acceuilpane.toFront();
        }
        else if(e.getSource() == cr_btn) {
            System.out.println("Crédit");
            creditPane.toFront();

        }

        else if(e.getSource() == adh_btn) {
            System.out.println("Adhérants");
            adherantPane.toFront();

        }
        else if(e.getSource() == sc_btn) {
            System.out.println("Scéances");
            sceancePane.toFront();

        }
    }

    @FXML
    private void getAddView(ActionEvent event) {
        try {

            AnchorPane root = new FXMLLoader(getClass().getResource("/com/marius/tontine/addAdherant.fxml")).load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
