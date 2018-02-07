/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.entity;

import java.util.Date;

/**
 *
 * @author Developer
 */
public class Transaksi {

    String idTransaksi;
    Date Tanggal;
    Double TotalHarga;
    String User_idUser;

    public Transaksi(String idTransaksi, Date Tanggal, Double TotalHarga,
            String User_idUser) {
        this.idTransaksi = idTransaksi;
        this.Tanggal = Tanggal;
        this.TotalHarga = TotalHarga;
        this.User_idUser = User_idUser;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Date getTanggal() {
        return Tanggal;
    }

    public void setTanggal(Date Tanggal) {
        this.Tanggal = Tanggal;
    }

    public Double getTotalHarga() {
        return TotalHarga;
    }

    public void setTotalHarga(Double TotalHarga) {
        this.TotalHarga = TotalHarga;
    }

    public String getUser_idUser() {
        return User_idUser;
    }

    public void setUser_idUser(String User_idUser) {
        this.User_idUser = User_idUser;
    }

}
