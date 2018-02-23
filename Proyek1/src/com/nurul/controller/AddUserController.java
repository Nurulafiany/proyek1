/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import com.nurul.dao.RoleDaoImpl;
import com.nurul.dao.UserDaoImpl;
import com.nurul.entity.Role;
import com.nurul.entity.User;
import com.nurul.utility.Utility;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
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
    private TextField txtAlamatUs;
    @FXML
    private TextField txtEmailUs;
    @FXML
    private TextField txtNoHP;
    @FXML
    private TextField txtFullNameUs;
    @FXML
    private PasswordField txtPasswordUs;
    @FXML
    private ComboBox<Role> CBStatus;
    @FXML
    private TableView<User> tblVuser;
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
    @FXML
    private TableColumn<User, String> ColStatusUs;
    @FXML
    private Button btnTambahUser;
    @FXML
    private Button btnHapusUser;
    @FXML
    private Button btnUpdateUser;

    private ObservableList<User> users;
    private Stage userStage;
    private UserDaoImpl userDao;
    public User selectedUser;
    private RoleDaoImpl roleDao;
    public Role selectedRole;
    private TampilanOwnerController mainController;
    private ObservableList<Role> roles;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblVuser.setItems(getUsers());
        CBStatus.setItems(getRoles());
        ColFullNameUs.
                setCellValueFactory(data -> data.getValue().NamaProperty());
        ColAlamatUs.
                setCellValueFactory(data -> data.getValue().AlamatProperty());
        ColNoHPUs.
                setCellValueFactory(data -> data.getValue().
                Phone_NumberProperty());
        ColPasswordUs.
                setCellValueFactory(data -> data.getValue().PasswordProperty());
        ColEmailUs.
                setCellValueFactory(data -> data.getValue().EmailProperty());
        ColStatusUs.
                setCellValueFactory((
                        TableColumn.CellDataFeatures<User, String> param)
                        -> new SimpleStringProperty(param.getValue().
                        getRole_idRole().getStatus()));

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

    public ObservableList<Role> getRoles() {
        if (roles == null) {
            roles = FXCollections.observableArrayList();
            roles.addAll(getRoleDao().showAllData());
        }
        return roles;
    }

    public RoleDaoImpl getRoleDao() {
        if (roleDao == null) {
            roleDao = new RoleDaoImpl();
        }
        return roleDao;
    }

    @FXML
    private void tblUserOnClick(MouseEvent event) {
        selectedUser = tblVuser.getSelectionModel().getSelectedItem();
        btnHapusUser.setDisable(false);

        if (selectedUser != null) {
            txtFullNameUs.setText(selectedUser.getNama());
            txtAlamatUs.setText(selectedUser.getAlamat());
            txtNoHP.setText(selectedUser.getPhone_Number());
            txtPasswordUs.setText(selectedUser.getPassword());
            txtEmailUs.setText(selectedUser.getEmail());
            CBStatus.setValue(selectedUser.getRole_idRole());
        }

    }

    @FXML
    private void btnTambahUserOnAction(ActionEvent event) {
        Utility utility = new Utility();
        if (!utility.isEmptyField(txtFullNameUs,
                txtAlamatUs, txtNoHP, txtPasswordUs, txtEmailUs)) {
            User user = new User();
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
        if (!Utility.isEmptyField(txtFullNameUs,
                txtAlamatUs, txtNoHP, txtPasswordUs, txtEmailUs)) {
            selectedUser.setNama(txtFullNameUs.getText().trim());
            selectedUser.setAlamat(txtAlamatUs.getText().trim());
            selectedUser.setPhone_Number(txtNoHP.getText().trim());
            selectedUser.setPassword(txtPasswordUs.getText().trim());
            selectedUser.setEmail(txtEmailUs.getText().trim());
            if (getUserDao().deleteData(selectedUser) == 1) {
                getUsers().clear();
                getUsers().addAll(getUserDao().showAllData());
                tblVuser.refresh();
            }
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
        if (!Utility.isEmptyField(txtFullNameUs,
                txtAlamatUs, txtNoHP, txtPasswordUs, txtEmailUs)) {
            selectedUser.setIdUser(selectedUser.getIdUser());
            selectedUser.setNama(txtFullNameUs.getText().trim());
            selectedUser.setAlamat(txtAlamatUs.getText().trim());
            selectedUser.setPhone_Number(txtNoHP.getText().trim());
            selectedUser.setPassword(txtPasswordUs.getText().trim());
            selectedUser.setEmail(txtEmailUs.getText().trim());
            if (getUserDao().updateData(selectedUser) == 1) {
                getUsers().clear();
                getUsers().addAll(getUserDao().showAllData());
                tblVuser.refresh();
            }
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
        ColFullNameUs.setCellValueFactory(p -> p.getValue().NamaProperty());
        ColAlamatUs.setCellValueFactory(p -> p.getValue().AlamatProperty());
        ColNoHPUs.setCellValueFactory(p -> p.getValue().Phone_NumberProperty());
        ColPasswordUs.setCellValueFactory(p -> p.getValue().PasswordProperty());
        ColEmailUs.setCellValueFactory(p -> p.getValue().EmailProperty());
    }

}
