/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nurul
 */
public class TampilanOwnerController implements Initializable {

    @FXML
    private Button btnAddBarang;
    @FXML
    private Button btnAddUser;
    @FXML
    private Label lblNama;
    @FXML
    private Button btnLaporan;
    
    private Stage barangStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAddBarangAction(ActionEvent event) {
         try {
            if (barangStage == null) {
                barangStage = new Stage();
                barangStage.setTitle("Category Management");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(mainApp.class.getResource
                    ("view/secondLayoutView.fxml"));
                BorderPane root = loader.load();
                Scene scene = new Scene(root);
                AddBarangController addBrg = 
                          loader.getController();
                addBrg.setMainController(this);
                barangStage.setScene(scene);
                barangStage.initOwner(borderPane.getScene().getWindow());
                barangStage.initModality(Modality.WINDOW_MODAL);
            }
            if (!barangStage.isShowing()) {
                barangStage.show();
            } else {
                barangStage.toFront();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void btnAddUserAction(ActionEvent event) {
    }

    @FXML
    private void btnLaporanAction(ActionEvent event) {
    }

}
