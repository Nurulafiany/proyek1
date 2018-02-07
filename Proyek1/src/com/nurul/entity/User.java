/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.entity;

/**
 *
 * @author Developer
 */
public class User {

    String idUser;
    String Nama;
    String Alamat;
    String Phone_Number;
    String Username;
    String Password;
    String Email;
    int Role_idRole;

    public User(String idUser, String Nama, String Alamat, String Phone_Number,
            String Username, String Password, String Email, int Role_idRole) {
        this.idUser = idUser;
        this.Nama = Nama;
        this.Alamat = Alamat;
        this.Phone_Number = Phone_Number;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Role_idRole = Role_idRole;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getRole_idRole() {
        return Role_idRole;
    }

    public void setRole_idRole(int Role_idRole) {
        this.Role_idRole = Role_idRole;
    }

}
