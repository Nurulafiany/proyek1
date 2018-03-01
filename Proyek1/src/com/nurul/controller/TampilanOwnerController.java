/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import com.nurul.MainApp;
import com.nurul.dao.BarangDaoImpl;
import com.nurul.entity.Barang;
import com.nurul.entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nurul
 */
public class TampilanOwnerController implements Initializable {
//
//    private AddBarangController addBrg;

    @FXML
    private Button btnAddBarang;
    @FXML
    private Button btnAddUser;
    @FXML
    private Label lblNama;
    @FXML
    private Button btnLaporan;

    @FXML
    private BorderPane borderPane;

    private ObservableList<Barang> barangs;

    private BarangDaoImpl barangDao;

    private TampilanOwnerController mainController;

    private Stage barangStage;
    private Stage userStage;

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
                barangStage.setTitle("Items Management");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/AddBarang.fxml"));
                BorderPane root = loader.load();
                Scene scene = new Scene(root);
                AddBarangController addBrg = loader.getController();
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

    public User getSelectedUser() {
        return getSelectedUser();
    }

    @FXML
    private void btnAddUserAction(ActionEvent event) {
        try {
            if (userStage == null) {
                userStage = new Stage();
                userStage.setTitle("Users Management");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/AddUser.fxml"));
                BorderPane root = loader.load();
                Scene scene = new Scene(root);
                AddUserController addUserController = loader.getController();
                addUserController.setMainController(this);
                userStage.setScene(scene);
                userStage.initOwner(borderPane.getScene().getWindow());
                userStage.initModality(Modality.WINDOW_MODAL);
            }
            if (!userStage.isShowing()) {
                userStage.show();
            } else {
                userStage.toFront();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void btnLaporanAction(ActionEvent event) {
        try {
            if (userStage == null) {
                userStage = new Stage();
                userStage.setTitle("Report Management");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/Laporan.fxml"));
                BorderPane root = loader.load();
                Scene scene = new Scene(root);
                LaporanController laporanController = loader.getController();
                laporanController.setMainController(this);
                userStage.setScene(scene);
                userStage.initOwner(borderPane.getScene().getWindow());
                userStage.initModality(Modality.WINDOW_MODAL);
            }
            if (!userStage.isShowing()) {
                userStage.show();
            } else {
                userStage.toFront();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
