/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import com.nurul.dao.BarangDaoImpl;
import com.nurul.entity.Barang;
import com.nurul.utility.Utility;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

    private TampilanOwnerController mainController;
    @FXML
    private TableView<Barang> tblVBarang;
    @FXML
    private TableColumn<Barang, Integer> colKdBarang;
    @FXML
    private TableColumn<Barang, String> colNamaBarang;
    @FXML
    private TableColumn<Barang, Integer> colHargaBrg;
    @FXML
    private TableColumn<Barang, Integer> colHargaJual;
    @FXML
    private TableColumn<Barang, Integer> colJmlBrg;

    private ObservableList<Barang> barangs;
    private Stage barangStage;
    private BarangDaoImpl barangDao;
    public Barang selectedBarang;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblVBarang.setItems(getBarangs());
//        colKd_Barang.
//                setCellValueFactory(data -> data.getValue().
//                kd_BarangProperty().asObject());
        colNamaBarang.
                setCellValueFactory(data -> data.getValue().NamaBrgProperty());
        colHargaBrg.
                setCellValueFactory(data -> data.getValue().
                HargaBeliProperty().asObject());
        colHargaJual.
                setCellValueFactory(data -> data.getValue().
                HargaJualProperty().asObject());
        colJmlBrg.
                setCellValueFactory(data -> data.getValue().
                StockProperty().asObject());
    }

    @FXML
    private void btnTambahItemAction(ActionEvent event) {
        Utility utility = new Utility();
        if (!utility.isEmptyField(txtNamaBarang, txtHrgBarang,
                txtHrgJual, txtJmlBarang)) {
            Barang barang = new Barang();
            barang.setNamaBrg(txtNamaBarang.getText().trim());
            barang.setHargaBeli(Integer.
                    valueOf(txtHrgBarang.getText().trim()));
            barang.setHargaJual(Integer.
                    valueOf(txtHrgJual.getText().trim()));
            barang.setStock(Integer.
                    valueOf(txtJmlBarang.getText().trim()));

            if (getBarangDao().addData(barang) == 1) {
                getBarangs().clear();
                getBarangs().addAll(getBarangDao().showAllData());
                tblVBarang.refresh();
            }
            txtNamaBarang.clear();
            txtHrgBarang.clear();
            txtHrgJual.clear();
            txtJmlBarang.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Field masih ada yang kosong");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnHapusItemAction(ActionEvent event) {
    }

    @FXML
    private void btnUpdateItemAction(ActionEvent event) {
        Utility utility = new Utility();
        if (!utility.isEmptyField(txtNamaBarang, txtHrgBarang,
                txtHrgJual, txtHrgJual)) {
            Barang barang = new Barang();
            barang.setNamaBrg(txtNamaBarang.getText().trim());
            barang.setHargaBeli(Integer.
                    valueOf(txtHrgBarang.getText().trim()));
            barang.setHargaJual(Integer.
                    valueOf(txtHrgJual.getText().trim()));
            barang.setStock(Integer.
                    valueOf(txtJmlBarang.getText().trim()));
            if (getBarangDao().updateData(barang) == 1) {
                getBarangs().clear();
                getBarangs().addAll(getBarangDao().showAllData());

                tblVBarang.refresh();
                //mengkosongkan teks field setelah isi data
                txtNamaBarang.clear();
                txtHrgBarang.clear();
                txtHrgJual.clear();
                txtJmlBarang.clear();
                selectedBarang = null;

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Silahkan ketik ulang");
                alert.showAndWait();
            }
        }
    }

    public BarangDaoImpl getBarangDao() {
        if (barangDao == null) {
            barangDao = new BarangDaoImpl();
        }
        return barangDao;
    }

    public ObservableList<Barang> getBarangs() {

        if (barangs == null) {
            barangs = FXCollections.observableArrayList();
            barangs.addAll(getBarangDao().showAllData());
        }
        return barangs;
    }

    public void setMainController(TampilanOwnerController mainController) {
        //   categoryDao = new CategoryDaoImpl();
        this.mainController = mainController;
        tblVBarang.setItems(getBarangs());
        colKdBarang.setCellValueFactory(p -> p.getValue().idBarangProperty().
                asObject());
        colNamaBarang.setCellValueFactory(p -> p.getValue().NamaBrgProperty());
        colHargaBrg.setCellValueFactory(p -> p.getValue().HargaBeliProperty().
                asObject());
        colHargaJual.setCellValueFactory(p -> p.getValue().HargaJualProperty().
                asObject());
        colJmlBrg.setCellValueFactory(p -> p.getValue().StockProperty().
                asObject());
    }

    @FXML
    private void tblBrgOnClick(MouseEvent event) {
        selectedBarang = tblVBarang.getSelectionModel().getSelectedItem();
        btnHapusItem.setDisable(false);

        if (selectedBarang != null) {
            txtNamaBarang.setText(selectedBarang.getNamaBrg());
            txtHrgBarang.setText(String.valueOf(selectedBarang.getHargaBeli()));
            txtHrgJual.setText(String.valueOf(selectedBarang.getHargaJual()));
            txtJmlBarang.setText(String.valueOf(selectedBarang.getStock()));

        }

    }
}
