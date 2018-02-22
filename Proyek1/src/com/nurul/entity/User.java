/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Developer
 */
public class User {

    private final IntegerProperty idUser = new SimpleIntegerProperty();

    public int getIdUser() {
        return idUser.get();
    }

    public void setIdUser(int value) {
        idUser.set(value);
    }

    public IntegerProperty idUserProperty() {
        return idUser;
    }
    private final StringProperty Alamat = new SimpleStringProperty();

    public String getAlamat() {
        return Alamat.get();
    }

    public void setAlamat(String value) {
        Alamat.set(value);
    }

    public StringProperty AlamatProperty() {
        return Alamat;
    }
    private final StringProperty Phone_Number = new SimpleStringProperty();

    public String getPhone_Number() {
        return Phone_Number.get();
    }

    public void setPhone_Number(String value) {
        Phone_Number.set(value);
    }

    public StringProperty Phone_NumberProperty() {
        return Phone_Number;
    }
    private final StringProperty Password = new SimpleStringProperty();

    public String getPassword() {
        return Password.get();
    }

    public void setPassword(String value) {
        Password.set(value);
    }

    public StringProperty PasswordProperty() {
        return Password;
    }
    private final StringProperty Email = new SimpleStringProperty();

    public String getEmail() {
        return Email.get();
    }

    public void setEmail(String value) {
        Email.set(value);
    }

    public StringProperty EmailProperty() {
        return Email;
    }
    private final ObjectProperty<Role> Role_idRole
            = new SimpleObjectProperty<>();

    public Role getRole_idRole() {
        return Role_idRole.get();
    }

    public void setRole_idRole(Role value) {
        Role_idRole.set(value);
    }

    public ObjectProperty Role_idRoleProperty() {
        return Role_idRole;
    }

//    String idUser;
//    String Nama;
//    String Alamat;
//    String Phone_Number;
//    String Password;
//    String Email;
//    int Role_idRole;
//
//    public User(String idUser, String Nama, String Alamat, String Phone_Number,
//            String Username, String Password, String Email, int Role_idRole) {
//        this.idUser = idUser;
//        this.Nama = Nama;
//        this.Alamat = Alamat;
//        this.Phone_Number = Phone_Number;
//        this.Password = Password;
//        this.Email = Email;
//        this.Role_idRole = Role_idRole;
//    }
//
//    public User() {
//
//    }
//
//    public String getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(String idUser) {
//        this.idUser = idUser;
//    }
//
//    public String getNama() {
//        return Nama;
//    }
//
//    public void setNama(String Nama) {
//        this.Nama = Nama;
//    }
//
//    public String getAlamat() {
//        return Alamat;
//    }
//
//    public void setAlamat(String Alamat) {
//        this.Alamat = Alamat;
//    }
//
//    public String getPhone_Number() {
//        return Phone_Number;
//    }
//
//    public void setPhone_Number(String Phone_Number) {
//        this.Phone_Number = Phone_Number;
//    }
//
//    public String getPassword() {
//        return Password;
//    }
//
//    public void setPassword(String Password) {
//        this.Password = Password;
//    }
//
//    public String getEmail() {
//        return Email;
//    }
//
//    public void setEmail(String Email) {
//        this.Email = Email;
//    }
//
//    public int getRole_idRole() {
//        return Role_idRole;
//    }
//
//    public void setRole_idRole(int Role_idRole) {
//        this.Role_idRole = Role_idRole;
//    }
    private final StringProperty Nama = new SimpleStringProperty();

    public String getNama() {
        return Nama.get();
    }

    public void setNama(String value) {
        Nama.set(value);
    }

    public StringProperty NamaProperty() {
        return Nama;
    }

}
