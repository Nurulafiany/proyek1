/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Nurul Afiany (1672035)
 */
public class Transaksi {

    int idTransaksi;
    Timestamp Tanggal;
    int pembayaran;
    int User_idUser;

    public Transaksi() {
    }

    public Transaksi(int idTransaksi, Timestamp Tanggal, int pembayaran,
            int User_idUser) {
        this.idTransaksi = idTransaksi;
        this.Tanggal = Tanggal;
        this.User_idUser = User_idUser;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Timestamp getTanggal() {
        return Tanggal;
    }

    public void setTanggal(Timestamp Tanggal) {
        this.Tanggal = Tanggal;
    }

    public int getUser_idUser() {
        return User_idUser;
    }

    public void setUser_idUser(int User_idUser) {
        this.User_idUser = User_idUser;
    }

    public int getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(int pembayaran) {
        this.pembayaran = pembayaran;
    }

}
