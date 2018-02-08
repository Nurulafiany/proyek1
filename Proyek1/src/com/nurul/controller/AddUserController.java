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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nurul
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField txtKdUserUs;
    @FXML
    private TextField txtUsernameUs;
    @FXML
    private TextField txtFullNameUs;
    @FXML
    private PasswordField txtPasswordAdd;
    @FXML
    private PasswordField txtNoHPUs;
    @FXML
    private TextField txtAlamateUs;
    @FXML
    private TextField txtEmailUs;
    @FXML
    private Button btnTambahUser;
    @FXML
    private Button btnHapusUser;
    @FXML
    private Button btnUpdateUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnTambahUserOnAction(ActionEvent event) {
    }

    @FXML
    private void btnHapusUserOnAction(ActionEvent event) {
    }

    @FXML
    private void btnUpdateUser(ActionEvent event) {
    }

}
