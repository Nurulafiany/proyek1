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
public class Detail_Transaksi {

    String Transaksi_idTransaksi;
    String Barang_idBarang;
    int QtyBarang;
    Double HargaJual;

    public Detail_Transaksi(String Transaksi_idTransaksi, String Barang_idBarang,
            int QtyBarang, Double HargaJual) {
        this.Transaksi_idTransaksi = Transaksi_idTransaksi;
        this.Barang_idBarang = Barang_idBarang;
        this.QtyBarang = QtyBarang;
        this.HargaJual = HargaJual;
    }

    public String getTransaksi_idTransaksi() {
        return Transaksi_idTransaksi;
    }

    public void setTransaksi_idTransaksi(String Transaksi_idTransaksi) {
        this.Transaksi_idTransaksi = Transaksi_idTransaksi;
    }

    public String getBarang_idBarang() {
        return Barang_idBarang;
    }

    public void setBarang_idBarang(String Barang_idBarang) {
        this.Barang_idBarang = Barang_idBarang;
    }

    public int getQtyBarang() {
        return QtyBarang;
    }

    public void setQtyBarang(int QtyBarang) {
        this.QtyBarang = QtyBarang;
    }

    public Double getHargaJual() {
        return HargaJual;
    }

    public void setHargaJual(Double HargaJual) {
        this.HargaJual = HargaJual;
    }

}
