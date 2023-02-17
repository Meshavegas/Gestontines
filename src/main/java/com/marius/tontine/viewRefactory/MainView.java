package com.marius.tontine.viewRefactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView {
    @FXML
    private Button btn_connect;

    @FXML
    private TextField inp_name;

    @FXML
    private TextField inp_pass;

    @FXML
    void onConnect(ActionEvent event) {

            System.out.println(inp_name.getText()+":"+inp_pass.getText());
        try{

            Stage stage =(Stage) btn_connect.getScene().getWindow();
        stage.close();

        Stage pStage = new Stage();
            AnchorPane root = new FXMLLoader(getClass().getResource( "/com/marius/tontine/dashbord.fxml")).load();

        pStage.setTitle("Aceuill");
        pStage.setScene(new Scene(root));
        //Image icon = new Image("icon.png");
        //pStage.getIcons().add(icon);
        pStage.show();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    @FXML
    protected void onHelloButtonClick() {

    }
}