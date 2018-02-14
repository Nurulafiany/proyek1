/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Nurul Afiany (1672035)
 */
public class Transaksi {

    private final IntegerProperty idTransaksi = new SimpleIntegerProperty();

    public int getIdTransaksi() {
        return idTransaksi.get();
    }

    public void setIdTransaksi(int value) {
        idTransaksi.set(value);
    }

    public IntegerProperty idTransaksiProperty() {
        return idTransaksi;
    }
    private final StringProperty User_idUser = new SimpleStringProperty();

    public String getUser_idUser() {
        return User_idUser.get();
    }

    public void setUser_idUser(String value) {
        User_idUser.set(value);
    }

    public StringProperty User_idUserProperty() {
        return User_idUser;
    }

//    int idTransaksi;
//    Timestamp Tanggal;
//    int pembayaran;
//    String User_idUser;
//
//    public Transaksi() {
//    }
//
//    public Transaksi(int idTransaksi, Timestamp Tanggal, int pembayaran,
//            String User_idUser) {
//        this.idTransaksi = idTransaksi;
//        this.Tanggal = Tanggal;
//        this.User_idUser = User_idUser;
//    }
//
//    public int getIdTransaksi() {
//        return idTransaksi;
//    }
//
//    public void setIdTransaksi(int idTransaksi) {
//        this.idTransaksi = idTransaksi;
//    }
//
//    public Timestamp getTanggal() {
//        return Tanggal;
//    }
//
//    public void setTanggal(Timestamp Tanggal) {
//        this.Tanggal = Tanggal;
//    }
//
//    public String getUser_idUser() {
//        return User_idUser;
//    }
//
//    public void setUser_idUser(String User_idUser) {
//        this.User_idUser = User_idUser;
//    }
//
//    public int getPembayaran() {
//        return pembayaran;
//    }
//
//    public void setPembayaran(int pembayaran) {
//        this.pembayaran = pembayaran;
//    }
    private final IntegerProperty pembayaran = new SimpleIntegerProperty();

    public int getPembayaran() {
        return pembayaran.get();
    }

    public void setPembayaran(int value) {
        pembayaran.set(value);
    }

    public IntegerProperty pembayaranProperty() {
        return pembayaran;
    }

}
