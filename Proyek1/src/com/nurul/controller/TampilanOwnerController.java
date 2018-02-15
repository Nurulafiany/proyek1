/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import com.nurul.MainApp;
import com.nurul.dao.BarangDaoImpl;
import com.nurul.entity.Barang;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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

    @FXML
    private Button btnAddBarang;
    @FXML
    private Button btnAddUser;
    @FXML
    private Label lblNama;
    @FXML
    private Button btnLaporan;

    private Stage barangStage;
    @FXML
    private BorderPane borderPane;

    private ObservableList<Barang> barangs;

    private BarangDaoImpl barangDao;

    private TampilanOwnerController mainController;

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

    @FXML
    private void btnAddUserAction(ActionEvent event) {
    }

    @FXML
    private void btnLaporanAction(ActionEvent event) {
    }

    public BarangDaoImpl getBarangDao() {
        if (barangDao == null) {
            barangDao = new BarangDaoImpl();
        }
        return barangDao;
    }

    public ObservableList<Barang> getBarang() {

        if (barangs == null) {
            barangs = FXCollections.observableArrayList();
            barangs.addAll(getBarangDao().showAllData());
        }
        return barangs;
    }

}
