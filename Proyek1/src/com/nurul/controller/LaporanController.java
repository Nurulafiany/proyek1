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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author Developer
 */
public class LaporanController implements Initializable {

    @FXML
    private ComboBox<?> cmbSort;
    @FXML
    private Button btnSimpanLap;
    @FXML
    private DatePicker datepickDari;
    @FXML
    private DatePicker datepickerSampai;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSimpanLapAction(ActionEvent event) {
    }

    @FXML
    private void DariOnAction(ActionEvent event) {
    }

    @FXML
    private void SampaiOnAction(ActionEvent event) {
    }

    
}
