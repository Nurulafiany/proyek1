/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.controller;

import com.nurul.MainApp;
import com.nurul.dao.UserDaoImpl;
import com.nurul.entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nurul
 */
public class LoginController implements Initializable {

    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnLogin;
    @FXML
    private BorderPane bpLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLoginAction(ActionEvent event) throws IOException {
        User user = new User();
        user.setIdUser(Integer.valueOf(txtUserName.getText()));
        user.setPassword(txtPassword.getText());
        if (getUserDao().getData(user) != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Login Berhasil.");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader();

            int userRole = user.getRole_idRole();

            // Pembeda antara Owner dengan Kasir
            loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Login Form");
            secondStage.show();

            //Close Login Stage
            bpLogin.getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username atau Password anda salah!");
            alert.showAndWait();
        }
    }

    public UserDaoImpl getUserDao() {
        Object Userdao = null;
        if (Userdao == null) {
            Userdao = new UserDaoImpl();
        }
        UserDaoImpl userDao = null;
        return userDao;
    }

    public ObservableList<User> users;

    public ObservableList<User> geUsers() {
        if (users == null) {
            users = FXCollections.observableArrayList();
            users.addAll(getUserDao().showAllData());
        }
        return users;
    }

}
