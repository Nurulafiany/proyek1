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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nurul
 */
public class AddBarangController implements Initializable {

    @FXML
    private TextField txtKdBarang;
    @FXML
    private TextField txtNamaBarang;
    @FXML
    private TextField txtHrgBarang;
    @FXML
    private TextField txtHrgJual;
    @FXML
    private TextField txtJmlBarang;
    @FXML
    private Button btnTambahItem;
    @FXML
    private Button btnHapusItem;
    @FXML
    private Button btnUpdateItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnTambahItemAction(ActionEvent event) {
        
    }

    @FXML
    private void btnHapusItemAction(ActionEvent event) {
    }

    @FXML
    private void btnUpdateItemAction(ActionEvent event) {
    }

}
