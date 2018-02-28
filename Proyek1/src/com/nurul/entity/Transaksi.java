/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.entity;

import java.sql.Timestamp;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

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
//    private final IntegerProperty User_idUser = new SimpleIntegerProperty();
//
//    public Integer getUser_idUser() {
//        return User_idUser.get();
//    }
//
//    public void setUser_idUser(Integer value) {
//        User_idUser.set(value);
//    }
//
//    public IntegerProperty User_idUserProperty() {
//        return User_idUser;
//    }
    private final ObjectProperty<User> User_idUser
            = new SimpleObjectProperty<>();

    public User getUser_idUser() {
        return User_idUser.get();
    }

    public void setUser_idUser(User value) {
        User_idUser.set(value);
    }

    public ObjectProperty User_idUserProperty() {
        return User_idUser;
    }

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

    private final ObjectProperty<Timestamp> Tanggal
            = new SimpleObjectProperty<>();

    public Timestamp getTanggal() {
        return Tanggal.get();
    }

    public void setTanggal(Timestamp value) {
        Tanggal.set(value);
    }

    public ObjectProperty TanggalProperty() {
        return Tanggal;
    }

    public Transaksi() {
    }

    public Transaksi(int idTransaksi, User User_idUser, int pembayaran,
            Timestamp Tanggal) {
        this.setIdTransaksi(idTransaksi);
        this.setUser_idUser(User_idUser);
        this.setPembayaran(pembayaran);
        this.setTanggal(Tanggal);
    }
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

