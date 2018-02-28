/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import com.nurul.dao.BarangDaoImpl;
import com.nurul.dao.Detail_TransaksiDaoImpl;
import com.nurul.dao.TransaksiDaoImpl;
import com.nurul.entity.Barang;
import com.nurul.entity.Cart;
import com.nurul.entity.Detail_Transaksi;
import com.nurul.entity.Transaksi;
import com.nurul.entity.User;
import com.nurul.utility.Koneksi;
import com.nurul.utility.Utility;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Nurul
 */
public class TampilanKasirController implements Initializable {

    public Cart selectedCart;
    @FXML
    private TextField txtNoTransaksi;
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
    private TableView<Cart> tblVTransaksi;
    @FXML
    private Button btnHpsItemTr;
    @FXML
    private Button btnUpdtItemtr;
    @FXML
    private TextField txtPembayaranTr;
    @FXML
    private Button btnSubmitTr;
    @FXML
    private Button btnCancelTr;
    @FXML
    private TableColumn<Cart, String> colKdBrgTr;
    @FXML
    private TableColumn<Cart, String> colNmBrgTr;
    @FXML
    private TableColumn<Cart, String> colJmlTr;
    @FXML
    private TableColumn<Cart, String> colHrgTr;
    @FXML
    private TableColumn<Cart, String> colTotalTr;

    private ObservableList<Transaksi> transaksis;
    private Stage transaksiStage;
    private TransaksiDaoImpl transaksiDao;
    public Transaksi selectedTransaksi;
    private TampilanOwnerController mainController;
    private ObservableList<Barang> barangs;
    private Stage barangStage;
    private BarangDaoImpl barangDao;
    public Barang selectedBarang;
    @FXML
    private Button btnTmbhIListTr;
    private LoginController loginController;
    public Barang selectedBarang1;
    public User selectedUser;

    private int tmpNoTransaksi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tmpNoTransaksi = getTransaksis().size() + 1;
        cmbBoxBrg.setItems(getBarangs());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date = new Date();

        colKdBrgTr.setCellValueFactory((
                TableColumn.CellDataFeatures<Cart, String> prm)
                -> new SimpleStringProperty(String.valueOf(prm.getValue().
                        getKodeBarangTr())));
        colNmBrgTr.
                setCellValueFactory((
                        TableColumn.CellDataFeatures<Cart, String> param)
                        -> new SimpleStringProperty(String.valueOf(param.
                                getValue().getNamaBarangTr())));
        colJmlTr.
                setCellValueFactory((
                        TableColumn.CellDataFeatures<Cart, String> param)
                        -> new SimpleStringProperty(String.valueOf(param.
                                getValue().getJmlBarangTr())));
        colHrgTr.setCellValueFactory((
                TableColumn.CellDataFeatures<Cart, String> param)
                -> new SimpleStringProperty(String.valueOf(param.
                        getValue().getHargaBarangTr())));
        colTotalTr.setCellValueFactory((
                TableColumn.CellDataFeatures<Cart, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getHargaBarangTr() * param.getValue().getJmlBarangTr())));
        txtTanggal.setText(dateFormat.format(date));

        txtNoTransaksi.setText(String.valueOf(tmpNoTransaksi));
//        btnHpsItemTr.setDisable(true);
        tblVTransaksi.setItems(getCarts());
        tblVTransaksi.refresh();

    }

    public ObservableList<Barang> getBarangs() {

        if (barangs == null) {
            barangs = FXCollections.observableArrayList();
            barangs.addAll(getBarangDao().showAllData());
        }
        return barangs;
    }
    private Transaksi cartDaoImpl;

    //hanya untuk menampung ke list tanpa update  ke database
    private ObservableList<Cart> carts;

    public ObservableList<Cart> getCarts() {
        if (carts == null) {
            carts = FXCollections.observableArrayList();
        }
        return carts;
    }
    private Transaksi transaksi;

    public Transaksi getTransaksi() {
        if (transaksi == null) {
            transaksi = new Transaksi();
            transaksi.setIdTransaksi(getTransaksiDao().showAllData().size() + 1);
            transaksi.setPembayaran(0);

        }
        return transaksi;
    }

    private Detail_TransaksiDaoImpl detail_transaksiDaoImpl;

    public void setTampilanOwnerController(
            TampilanOwnerController mainController) {
        this.mainController = mainController;
        System.out.println(this.mainController);
        tblVTransaksi.setItems(getCarts());
        cmbBoxBrg.setItems(getBarangs());
        txtNoTransaksi.setText(String.valueOf(mainController.getSelectedUser().
                getIdUser()));
        txtUserTr.setText(String.valueOf(mainController.getSelectedUser().
                getNama()));

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
        if (!Utility.isEmptyField(txtJumlahTr) && cmbBoxBrg != null) {
            if (Utility.isNumber(txtJumlahTr.getText())) {
                Cart cart = new Cart();
                cart.setKodeBarangTr(cmbBoxBrg.getValue().getIdBarang());
                cart.setNamaBarangTr(cmbBoxBrg.getValue().getNamaBrg());
                cart.setJmlBarangTr(Integer.
                        valueOf(txtJumlahTr.getText().trim()));
                cart.setHargaBarangTr(Integer.valueOf(cmbBoxBrg.getValue().
                        getHargaJual()));

                getTransaksi().setPembayaran(getTransaksi().getPembayaran()
                        + cart.getJmlBarangTr() * cart.getHargaBarangTr());

                txtTotalTr.setText(String.valueOf(getTransaksi().
                        getPembayaran()));

                int qty = Integer.valueOf(txtJumlahTr.getText());
                cart = itemCart(cart);
                if (itemCartBoolean(cart)) {
                    cart.setJmlBarangTr(cart.getJmlBarangTr() + qty);
                    tblVTransaksi.refresh();
                } else {
                    boolean duplikat = false;

                    for (Cart c : carts) {
                        if (cmbBoxBrg.getValue().getNamaBrg().equals(c.
                                getNamaBarangTr())) {
                            duplikat = true;
                            c.setJmlBarangTr(c.getJmlBarangTr() + Integer.
                                    valueOf(
                                            txtJumlahTr.
                                            getText()));
                            tblVTransaksi.refresh();
                        }
                    }
                    if (!duplikat) {
                        getCarts().add(cart);
                    }

//                    selectedBarang.setStock(selectedBarang.getStock() - qty);
                    selectedBarang = null;
                    txtJumlahTr.setText("");
//                    btnTmbhIListTr.setDisable(true);
//                    txtJumlahTr.setDisable(true);
                    tblVTransaksi.refresh();
                }

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Isi semua terlebih dahulu");
            alert.showAndWait();
        }
    }

    public Detail_TransaksiDaoImpl getDetail_TransaksiDao() {
        if (detail_transaksiDaoImpl == null) {
            detail_transaksiDaoImpl = new Detail_TransaksiDaoImpl();
        }
        return detail_transaksiDaoImpl;
    }

    private boolean itemCartBoolean(Cart nowCart) {
        for (Cart cart : carts) {
            if (cart.getKodeBarangTr() == nowCart.getKodeBarangTr()) {
                return true;
            }
        }
        return false;
    }

    private Cart itemCart(Cart nowCart) {
        for (Cart cart : carts) {
            if (cart.getKodeBarangTr() == nowCart.getKodeBarangTr()) {
                return cart;
            }
        }
        return nowCart;
    }

    @FXML
    private void btnUpdateItemAction(ActionEvent event
    ) {
    }

    @FXML
    private void tblTrOnClicked(MouseEvent event
    ) {
        selectedCart = tblVTransaksi.getSelectionModel().getSelectedItem();
        if (selectedCart != null) {
            btnHpsItemTr.setDisable(false);
        }
    }

    private void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public void setLoginController(LoginController loginController, User user) {
        this.loginController = loginController;
        this.selectedUser = user;
        txtNoTransaksi.setText(String.valueOf(getTransaksi().getIdTransaksi()));
//        txtUserTr.setText(String.
//                valueOf(selectedUser.getIdUser()));
//        getTransaksi().setUser_idUser(loginController.getSelectedUser());
        getTransaksi().setUser_idUser(loginController.getUser());
        System.out.println(loginController.getUser().getIdUser());

    }

    @FXML
    private void btnHapusItemAction(ActionEvent event) {
        if (selectedCart != null) {
            carts.remove(selectedCart);
            getTransaksi().setPembayaran(0);
            for (Cart c : carts) {

                getTransaksi().setPembayaran(getTransaksi().getPembayaran()
                        + c.getJmlBarangTr() * c.getHargaBarangTr());
            }
            txtTotalTr.setText(String.valueOf(getTransaksi().
                    getPembayaran()));

            btnHpsItemTr.setDisable(true);
            selectedCart = null;

        }
    }

    @FXML
    private void btnSubmitOnCLicked(MouseEvent event) {
        if (!carts.isEmpty()) {
            if (Utility.isNumber(txtPembayaranTr.getText())) {
                if (Integer.valueOf(txtPembayaranTr.getText()) >= Integer.
                        valueOf(
                                txtTotalTr.getText())) {

                    getTransaksi().setIdTransaksi(Integer.valueOf(
                            txtNoTransaksi.
                            getText().trim()));
                    getTransaksi().setPembayaran(Integer.valueOf(
                            txtPembayaranTr.getText().trim()));

                    getTransaksiDao().addData(getTransaksi());

                    for (Cart c : carts) {
                        Detail_Transaksi detail_transaksi
                                = new Detail_Transaksi();

                        detail_transaksi.
                                setTransaksi_idTransaksi(getTransaksi());

                        detail_transaksi.setBarang_idBarang(new Barang(c.
                                getKodeBarangTr()));
                        detail_transaksi.setQtyBarang(c.getJmlBarangTr());
                        detail_transaksi.setHargaJual(c.getHargaBarangTr());

                        getDetail_TransaksiDao().addData(detail_transaksi);

                    }
                    int kembalian = Integer.valueOf(txtPembayaranTr.getText())
                            - Integer.valueOf(txtTotalTr.getText());
                    txtKembaliTr.setText(String.valueOf(kembalian));
                    int pembayaran = Integer.valueOf(txtPembayaranTr.getText());
                    txtBayarTr.setText(String.valueOf(pembayaran));
//                    txtKembaliTr.setText(String.valueOf(Utility.StoI(
//                            txtPembayaranTr.getText()) - Utility.StoI(
//                                    txtTotalTr.getText())));
                    Utility.showAlert("Infomasi", "Kembalian : Rp" + String.
                            valueOf(kembalian),
                            Alert.AlertType.INFORMATION);

                    int Kembali = Integer.valueOf(txtPembayaranTr.getText())
                            - Integer.valueOf(txtTotalTr.getText());
                    int TotalHarga = Integer.valueOf(txtPembayaranTr.getText());

                    Task<Void> task = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            try {
                                HashMap parameters = new HashMap();
                                parameters.put("TotalHarga", TotalHarga);
                                parameters.put("Kembali", Kembali);
                                JasperPrint jasperPrint = JasperFillManager.
                                        fillReport(
                                                "report/NotaPenjualan.jasper",
                                                parameters, Koneksi.
                                                createConnection());
                                JasperViewer jasperViewer = new JasperViewer(
                                        jasperPrint, false);
                                jasperViewer.setVisible(true);
                            } catch (JRException ex) {
                                System.out.println(ex);
                            }
                            return null;
                        }
                    };
                    ExecutorService service = Executors.newCachedThreadPool();
                    service.execute(task);
                    service.shutdown();

                    setTransaksi(null);
                    carts.clear();

                    txtTotalTr.setText("");
                    txtJumlahTr.setText("");
                    txtKembaliTr.setText("");
                    txtPembayaranTr.setText("");
                    txtBayarTr.setText("");

                    cmbBoxBrg.setValue(null);
//
//                    txtUserTr.setText(mainController.getSelectedUser().
//                            getNama());

                    getTransaksis().clear();
                    getTransaksis().addAll(getTransaksiDao().showAllData());

                    txtNoTransaksi.setText(String.
                            valueOf(getTransaksis().size() + 1));

                    DateFormat dateFormat = new SimpleDateFormat(
                            "dd/MM/yyyy HH:mm");
                    Date date = new Date();

                    txtTanggal.setText(dateFormat.format(date));

                } else {
                    Utility.showAlert("Error", "Uang tidak cukup",
                            Alert.AlertType.ERROR);
                }
            }
        }
    }

    @FXML
    private void btnCancelOnClicked(MouseEvent event) {
        setTransaksi(null);

        carts.clear();

        txtTotalTr.setText("");
        txtJumlahTr.setText("");
        txtKembaliTr.setText("");
        txtPembayaranTr.setText("");

        cmbBoxBrg.setValue(null);

        txtUserTr.setText(mainController.getSelectedUser().
                getNama());

        getTransaksis().clear();
        getTransaksis().addAll(getTransaksiDao().showAllData());

        txtNoTransaksi.setText(String.
                valueOf(getTransaksis().size() + 1));

        DateFormat dateFormat = new SimpleDateFormat(
                "dd/MM/yyyy HH:mm");
        Date date = new Date();

        txtTanggal.setText(dateFormat.format(date));
    }

}
