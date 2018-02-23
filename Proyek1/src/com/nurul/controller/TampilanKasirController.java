/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import com.nurul.dao.BarangDaoImpl;
import com.nurul.dao.TransaksiDaoImpl;
import com.nurul.entity.Barang;
import com.nurul.entity.Detail_Transaksi;
import com.nurul.entity.Transaksi;
import com.nurul.entity.User;
import com.nurul.utility.Utility;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nurul
 */
public class TampilanKasirController implements Initializable {

    @FXML
    private TextField txtNoTransaksi;
    @FXML
    private TextField txtUserTr;
    @FXML
    private TextField txtJumlahTr;
    @FXML
    private TextField txtTanggal;
    @FXML
    private ComboBox<Barang> cmbBoxBrg;
    @FXML
    private TextField txtTotalTr;
    @FXML
    private TextField txtBayarTr;
    @FXML
    private TextField txtKembaliTr;
    @FXML
    private TableView<Detail_Transaksi> tblVTransaksi;
    @FXML
    private Button btnHpsItemTr;
    @FXML
    private Button btnUpdtItemtr;
    @FXML
    private TextField txtPembayaranTr;
    @FXML
    private TextField txtKeteranganTr;
    @FXML
    private Button btnSubmitTr;
    @FXML
    private Button btnCancelTr;
    @FXML
    private TableColumn<Detail_Transaksi, String> colKdBrgTr;
    @FXML
    private TableColumn<Detail_Transaksi, String> colNmBrgTr;
    @FXML
    private TableColumn<Detail_Transaksi, String> colJmlTr;
    @FXML
    private TableColumn<Detail_Transaksi, String> colHrgTr;
    @FXML
    private TableColumn<Detail_Transaksi, String> colTotalTr;

    private ObservableList<Transaksi> transaksis;
    private Stage transaksiStage;
    private TransaksiDaoImpl transaksiDao;
    public Transaksi selectedTransaksi;
    private TampilanKasirController mainController;
    private ObservableList<Barang> barangs;
    private Stage barangStage;
    private BarangDaoImpl barangDao;
    public Barang selectedBarang;
    @FXML
    private Button btnTmbhIListTr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbBoxBrg.setItems(getBarangs());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        colKdBrgTr.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_Transaksi, String> prm)
                -> new SimpleStringProperty(String.valueOf(prm.getValue().
                        getBarang_IdBarang().getIdBarang()) + prm.getValue().
                                getBarang_IdBarang().getNamaBrg()));
        colNmBrgTr.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_Transaksi, String> prm)
                -> new SimpleStringProperty(String.valueOf(prm.getValue().
                        getBarang_IdBarang().getNamaBrg())));
        colJmlTr.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_Transaksi, String> prm)
                -> new SimpleStringProperty(String.valueOf(prm.getValue().
                        getQtyBarang())));
        colHrgTr.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_Transaksi, String> prm)
                -> new SimpleStringProperty(String.valueOf(prm.getValue().
                        getHargaJual())));
        colTotalTr.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_Transaksi, String> prm)
                -> new SimpleStringProperty(String.valueOf(prm.getValue().
                        getHargaJual() * prm.getValue().getQtyBarang())));
    }

    public ObservableList<Barang> getBarangs() {

        if (barangs == null) {
            barangs = FXCollections.observableArrayList();
            barangs.addAll(getBarangDao().showAllData());
        }
        return barangs;
    }

    private Transaksi cartDaoImpl;
    private ObservableList<Detail_Transaksi> carts;

    public ObservableList<Detail_Transaksi> getCarts() {
        if (carts == null) {
            carts = FXCollections.observableArrayList();
        }
        return carts;
    }

    public void setMainController(TampilanKasirController mainController) {
        this.mainController = mainController;
        tblVTransaksi.setItems(mainController.getCarts());
//        colKdBarang.setCellValueFactory(p -> p.getValue().idBarangProperty().
//                asObject());
//        colKdBrgTr.setCellValueFactory(p -> p.getValue().
//                barang_IdBarangProperty());
//        colNmBrgTr.setCellValueFactory(p -> p.getValue().
//                barang_IdBarangProperty().
//                asObject());
//        colJmlTr.setCellValueFactory(p -> p.getValue().HargaJualProperty().
//                asObject());
//        colHrgTr.setCellValueFactory(p -> p.getValue().StockProperty().
//                asObject());
//        colTotalTr.setCellValueFactory(p -> p.getValue().StockProperty().
//                asObject());
    }

    public BarangDaoImpl getBarangDao() {
        if (barangDao == null) {
            barangDao = new BarangDaoImpl();
        }
        return barangDao;
    }

    public TransaksiDaoImpl getTransaksiDao() {
        if (transaksiDao == null) {
            transaksiDao = new TransaksiDaoImpl();
        }
        return transaksiDao;
    }

    public ObservableList<Transaksi> getTransaksis() {

        if (transaksis == null) {
            transaksis = FXCollections.observableArrayList();
            transaksis.addAll(getTransaksiDao().showAllData());
        }
        return transaksis;
    }

    @FXML
    private void btnTambahItemAction(ActionEvent event) {
        if (!Utility.isEmptyField(txtTanggal, txtUserTr, txtJumlahTr,
                txtNoTransaksi,
                txtTotalTr, txtKembaliTr, txtBayarTr, txtPembayaranTr,
                txtKeteranganTr)) {
            Detail_Transaksi detail_transaksi = new Detail_Transaksi();
            Transaksi transaksi = new Transaksi();
            User user = new User();

            transaksi.setTanggal(Timestamp.valueOf(txtTanggal.
                    getText().trim()));
            user.setNama(txtUserTr.getText().trim());
            transaksi.setIdTransaksi(Integer.valueOf(txtNoTransaksi.getText().
                    trim()));
            detail_transaksi.setQtyBarang(Integer.valueOf(txtJumlahTr.getText().
                    trim()));
            // Total belanja
            transaksi.setPembayaran(Integer.valueOf(txtPembayaranTr.getText().
                    trim()));
//            //Kembalian
//            transaksi.setPembayaran(Integer.valueOf(txtPembayaranTr.getText().
//                    trim())) - transaksi.setPembayaran(Integer.valueOf(txtPembayaranTr.getText().
//                    trim()));
        }
    }

    @FXML
    private void btnHapusItemAction(ActionEvent event) {
    }

    @FXML
    private void btnUpdateItemAction(ActionEvent event) {
    }

}
