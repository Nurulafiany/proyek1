/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import com.nurul.entity.Detail_Transaksi;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Developer
 */
public class LaporanController implements Initializable {

    @FXML
    private ComboBox<Detail_Transaksi> cmbSort;
    @FXML
    private Button btnSimpanLap;
    @FXML
    private DatePicker datepickDari;
    @FXML
    private DatePicker datepickerSampai;

    private TampilanOwnerController mainController;
    @FXML
    private TableView<Detail_Transaksi> tblVLaporan;
    @FXML
    private TableColumn<Detail_Transaksi, Timestamp> colTglLaporan;
    @FXML
    private TableColumn<Detail_Transaksi, Integer> colNoTrLap;
    @FXML
    private TableColumn<Detail_Transaksi, Integer> colKDBrglap;
    @FXML
    private TableColumn<Detail_Transaksi, String> colnamabrglap;
    @FXML
    private TableColumn<?, ?> colJmlLap;
    @FXML
    private TableColumn<?, ?> colHrgBeliLap;
    @FXML
    private TableColumn<?, ?> colHrgJualLap;
    @FXML
    private TableColumn<?, ?> colTotLap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       cmbSort.setItems();
    }

    private ObservableList<Detail_Transaksi> dets;

    public ObservableList<Detail_Transaksi> getDetail_Transaksis() {

        if (dets == null) {
            dets = FXCollections.observableArrayList();
//            dets.addAll(getBarangDao().showAllData());
        }
        return dets;
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

    public void setMainController(TampilanOwnerController mainController) {
        //   categoryDao = new CategoryDaoImpl();
        this.mainController = mainController;

    }
}
