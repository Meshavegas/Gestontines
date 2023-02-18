package com.marius.tontine.viewRefactory;

import com.marius.tontine.controller.AdherantController;
import com.marius.tontine.dbHelper.Connexion;
import com.marius.tontine.modele.Adherant;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;

public class Dashbord implements Initializable {
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
    private TableColumn<Adherant, Integer> adh_age;

    @FXML
    private Button adh_btn;

    @FXML
    private TableColumn<Adherant, Integer> adh_contact;

    @FXML
    private TableColumn<Adherant, String> adh_dateInscription;

    @FXML
    private TableColumn<Adherant, String> adh_email;

    @FXML
    private TableColumn<Adherant, Integer> adh_id;

    @FXML
    private TableColumn<Adherant, String > adh_nom;

    @FXML
    private TableColumn<Adherant, String> adh_sexe;

    @FXML
    private TableView<Adherant> adherannTable;
    @FXML
    private TableColumn<Adherant, String>  adh_action;


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

    ResultSet resultSet;
    ObservableList<Adherant> adherantsList = FXCollections.observableArrayList();
    AdherantController adherantController = new AdherantController();



    @FXML
    void onNavigate(ActionEvent e) throws SQLException, ClassNotFoundException {
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
            loadAdherantData();

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
    @FXML
    private void loadAdherantData() throws SQLException, ClassNotFoundException {
        refreshTable("adherant");
        adh_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        adh_nom.setCellValueFactory(new PropertyValueFactory<>("nomPrenom"));
        adh_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        adh_dateInscription.setCellValueFactory(new PropertyValueFactory<>("dateAdhesion"));
        adh_contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
       adh_email.setCellValueFactory(new PropertyValueFactory<>("email"));
       adh_sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        Callback<TableColumn<Adherant, String>, TableCell<Adherant, String>>  cellFatory = (TableColumn<Adherant, String > param) ->{
            final  TableCell<Adherant,String> cell = new TableCell<Adherant, String>(){
                @Override
                public void updateItem(String item, boolean empty){
                    super.updateItem(item,empty);
                    if (empty){

                    setGraphic((null));
                    setText(null);
                    }else {
                        FontAwesomeIconView deleteicon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editicon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteicon.setStyle(" -fx-cursor: hand ;-glyph-size:28px; -fx-fill:#ff1744;"
                        );
                        editicon.setStyle(
                                " -fx-cursor: hand ;"
                                        + "-glyph-size:28px;"
                                        + "-fx-fill:#00E676;"
                        );
                        deleteicon.onMouseClickedProperty();
                        editicon.onMouseClickedProperty();

                        HBox managebtn = new HBox(editicon, deleteicon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteicon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editicon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }

                }

            };
            return cell;
        };

        adh_action.setCellFactory(cellFatory);
        adherannTable.setItems(adherantsList);

    }
    void refreshTable(String table) throws SQLException, ClassNotFoundException {
        adherantsList.clear();
        resultSet = adherantController.getData();

        while (resultSet.next()){
            adherantsList.add(new Adherant(
                    resultSet.getInt("id"),
                    resultSet.getString("nom") +" "+ resultSet.getString("prenom"),
                    new Date(new java.util.Date().getTime()).getYear() -resultSet.getDate("date_naissance").getYear(),
                    resultSet.getDate("date_adhesion"),
                    resultSet.getInt("contact"),
                    resultSet.getString("email"),
                    resultSet.getString("sexe")
                    ));

                adherannTable.setItems(adherantsList);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acceuilpane.toFront();
    }
}
