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

    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnLogin;
    @FXML
    private BorderPane bpLogin;

    private UserDaoImpl userDaoImpl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public ObservableList<User> users;
    
    public ObservableList<User> geUsers() {
        if (users == null) {
            users = FXCollections.observableArrayList();
            users.addAll(getUserDao().showAllData());
        }
        return users;
    }
    
    public UserDaoImpl getUserDao() {

        if (userDaoImpl == null) {
            userDaoImpl = new UserDaoImpl();
        }
        return userDaoImpl;
    }
    
    @FXML
    private void btnLoginAction(ActionEvent event) throws IOException {
        User user = new User();
        user.setIdUser(txtUsername.getText());
        user.setPassword(txtPassword.getText());
        if (getUserDao().getData(user) != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Login Berhasil.");
            alert.showAndWait();

            // Pembeda antara Owner dengan Kasir
            if (getUserDao().getData(user).getRole_idRole().getIdRole() == 1) {
                FXMLLoader loader = new FXMLLoader();

                    loader.setLocation(MainApp.class.getResource(
                            "view/TampilanOwner.fxml"));
                    BorderPane pane = loader.load();
                    Scene scene = new Scene(pane);
                    Stage secondStage = new Stage();
                    secondStage.setScene(scene);
                    secondStage.setTitle("Owner Form");
                    secondStage.show();
                } else if (getUserDao().getData(user).getRole_idRole().getIdRole() == 2) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/TampilanKasir.fxml"));
                BorderPane pane = loader.load();
                Scene scene = new Scene(pane);
                Stage secondStage = new Stage();
                secondStage.setScene(scene);
                secondStage.setTitle("Cashier Form");
                secondStage.show();
            }

                //Close Login Stage
                bpLogin.getScene().getWindow().hide();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username atau Password anda salah!");
                alert.showAndWait();
            }
        }
}
