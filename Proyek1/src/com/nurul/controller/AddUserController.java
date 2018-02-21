/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import com.nurul.dao.UserDaoImpl;
import com.nurul.entity.Role;
import com.nurul.entity.User;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
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
public class AddUserController implements Initializable {

    @FXML
    private TextField txtKdUserUs;
    @FXML
    private TextField txtFullNameUs;
    @FXML
    private TextField txtEmailUs;
    @FXML
    private Button btnTambahUser;
    @FXML
    private Button btnHapusUser;
    @FXML
    private Button btnUpdateUser;
    @FXML
    private TextField txtAlamatUs;
    @FXML
    private TextField txtNoHP;
    @FXML
    private PasswordField txtPasswordUs;
    @FXML
    private TableView<User> tblVuser;
    @FXML
    private TableColumn<User, String> ColKdUser;
    @FXML
    private TableColumn<User, String> ColFullNameUs;
    @FXML
    private TableColumn<User, String> ColAlamatUs;
    @FXML
    private TableColumn<User, String> ColNoHPUs;
    @FXML
    private TableColumn<User, String> ColPasswordUs;
    @FXML
    private TableColumn<User, String> ColEmailUs;

    private ObservableList<User> users;
    private Stage userStageStage;
    private UserDaoImpl userDao;
    public User selectedUser;
    private TampilanOwnerController mainController;
    @FXML
    private ComboBox<Role> CBStatus;
    @FXML
    private TableColumn<Role, Integer> ColStatusUs;

    private ObservableList<Role> roles;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblVuser.setItems(getUsers());
        ColKdUser.
                setCellValueFactory(data -> data.getValue().idUserProperty());
        ColFullNameUs.
                setCellValueFactory(data -> data.getValue().NamaProperty());
        ColAlamatUs.
                setCellValueFactory(data -> data.getValue().AlamatProperty());
        ColNoHPUs.
                setCellValueFactory(data -> data.getValue().AlamatProperty());
        ColPasswordUs.
                setCellValueFactory(data -> data.getValue().AlamatProperty());
        ColEmailUs.
                setCellValueFactory(data -> data.getValue().AlamatProperty());
//        ColStatusUs.setCellValueFactory(data
//                -> data.getValue().getIdRole().StatusProperty());
    }

    public ObservableList<User> getUsers() {

        if (users == null) {
            users = FXCollections.observableArrayList();
            users.addAll(getUserDao().showAllData());
        }
        return users;
    }

    public UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    @FXML
    private void btnTambahUserOnAction(ActionEvent event) {

        Utility utility = new Utility();
        if (!utility.isEmptyField(txtKdUserUs, txtFullNameUs,
                txtAlamatUs, txtNoHP, txtPasswordUs, txtEmailUs)) {
            User user = new User();
            user.setIdUser(txtKdUserUs.getText().trim());
            user.setNama(txtFullNameUs.getText().trim());
            user.setAlamat(txtAlamatUs.getText().trim());
            user.setPhone_Number(txtNoHP.getText().trim());
            user.setPassword(txtPasswordUs.getText().trim());
            user.setEmail(txtEmailUs.getText().trim());
            if (getUserDao().addData(user) == 1) {
                getUsers().clear();
                getUsers().addAll(getUserDao().showAllData());
                tblVuser.refresh();
            }
            txtKdUserUs.clear();
            txtFullNameUs.clear();
            txtAlamatUs.clear();
            txtNoHP.clear();
            txtPasswordUs.clear();
            txtEmailUs.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Field masih ada yang kosong");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnHapusUserOnAction(ActionEvent event) {
        if (!Utility.isEmptyField(txtKdUserUs, txtFullNameUs,
                txtAlamatUs, txtNoHP, txtPasswordUs, txtEmailUs)) {
            User user = new User();
            user.setIdUser(txtKdUserUs.getText().trim());
            user.setNama(txtFullNameUs.getText().trim());
            user.setAlamat(txtAlamatUs.getText().trim());
            user.setPhone_Number(txtNoHP.getText().trim());
            user.setPassword(txtPasswordUs.getText().trim());
            user.setEmail(txtEmailUs.getText().trim());
            if (getUserDao().deleteData(user) == 1) {
                getUsers().clear();
                getUsers().addAll(getUserDao().showAllData());
                tblVuser.refresh();
            }
            txtKdUserUs.clear();
            txtFullNameUs.clear();
            txtAlamatUs.clear();
            txtNoHP.clear();
            txtPasswordUs.clear();
            txtEmailUs.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Field masih ada yang kosong");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnUpdateUser(ActionEvent event) {
        if (!Utility.isEmptyField(txtKdUserUs, txtFullNameUs,
                txtAlamatUs, txtNoHP, txtPasswordUs, txtEmailUs)) {
            User user = new User();
            user.setIdUser(txtKdUserUs.getText().trim());
            user.setNama(txtFullNameUs.getText().trim());
            user.setAlamat(txtAlamatUs.getText().trim());
            user.setPhone_Number(txtNoHP.getText().trim());
            user.setPassword(txtPasswordUs.getText().trim());
            user.setEmail(txtEmailUs.getText().trim());
            if (getUserDao().updateData(user) == 1) {
                getUsers().clear();
                getUsers().addAll(getUserDao().showAllData());
                tblVuser.refresh();
            }
            txtKdUserUs.clear();
            txtFullNameUs.clear();
            txtAlamatUs.clear();
            txtNoHP.clear();
            txtPasswordUs.clear();
            txtEmailUs.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Field masih ada yang kosong");
            alert.showAndWait();
        }
    }

    public void setMainController(TampilanOwnerController mainController) {
        //   categoryDao = new CategoryDaoImpl();
        this.mainController = mainController;
        tblVuser.setItems(getUsers());
        ColKdUser.setCellValueFactory(p -> p.getValue().idUserProperty());
        ColFullNameUs.setCellValueFactory(p -> p.getValue().NamaProperty());
        ColAlamatUs.setCellValueFactory(p -> p.getValue().AlamatProperty());
        ColNoHPUs.setCellValueFactory(p -> p.getValue().Phone_NumberProperty());
        ColPasswordUs.setCellValueFactory(p -> p.getValue().PasswordProperty());
        ColEmailUs.setCellValueFactory(p -> p.getValue().EmailProperty());
    }

    @FXML
    private void tblUserOnClick(MouseEvent event) {
        selectedUser = tblVuser.getSelectionModel().getSelectedItem();
        btnHapusUser.setDisable(false);

        if (selectedUser != null) {

            txtKdUserUs.setDisable(true);
            txtKdUserUs.setText(selectedUser.getIdUser());
            txtFullNameUs.setText(selectedUser.getNama());
            txtAlamatUs.setText(selectedUser.getAlamat());
            txtNoHP.setText(selectedUser.getPhone_Number());
            txtPasswordUs.setText(selectedUser.getPassword());
            txtEmailUs.setText(selectedUser.getEmail());
        }

    }
}
