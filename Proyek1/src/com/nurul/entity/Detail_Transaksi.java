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

/**
 *
 * @author Nurul Afiany (1672035)
 */
public class Detail_Transaksi {

    private final IntegerProperty Transaksi_idTransaksi
            = new SimpleIntegerProperty();

    public int getTransaksi_idTransaksi() {
        return Transaksi_idTransaksi.get();
    }

    public void setTransaksi_idTransaksi(int value) {
        Transaksi_idTransaksi.set(value);
    }

    public IntegerProperty Transaksi_idTransaksiProperty() {
        return Transaksi_idTransaksi;
    }
    private final IntegerProperty QtyBarang = new SimpleIntegerProperty();

    public int getQtyBarang() {
        return QtyBarang.get();
    }

    public void setQtyBarang(int value) {
        QtyBarang.set(value);
    }

    public IntegerProperty QtyBarangProperty() {
        return QtyBarang;
    }
    private final IntegerProperty HargaJual = new SimpleIntegerProperty();

    public int getHargaJual() {
        return HargaJual.get();
    }

    public void setHargaJual(int value) {
        HargaJual.set(value);
    }

    public IntegerProperty HargaJualProperty() {
        return HargaJual;
    }

//
//    int Transaksi_idTransaksi;
//    int Barang_idBarang;
//    int QtyBarang;
//    Double HargaJual;
//
//    public Detail_Transaksi() {
//    }
//
//    public Detail_Transaksi(int Transaksi_idTransaksi, int Barang_idBarang,
//            int QtyBarang, Double HargaJual) {
//        this.Transaksi_idTransaksi = Transaksi_idTransaksi;
//        this.Barang_idBarang = Barang_idBarang;
//        this.QtyBarang = QtyBarang;
//        this.HargaJual = HargaJual;
//    }
//
//    public int getTransaksi_idTransaksi() {
//        return Transaksi_idTransaksi;
//    }
//
//    public void setTransaksi_idTransaksi(int Transaksi_idTransaksi) {
//        this.Transaksi_idTransaksi = Transaksi_idTransaksi;
//    }
//
//    public int getBarang_idBarang() {
//        return Barang_idBarang;
//    }
//
//    public void setBarang_idBarang(int Barang_idBarang) {
//        this.Barang_idBarang = Barang_idBarang;
//    }
//
//    public int getQtyBarang() {
//        return QtyBarang;
//    }
//
//    public void setQtyBarang(int QtyBarang) {
//        this.QtyBarang = QtyBarang;
//    }
//
//    public Double getHargaJual() {
//        return HargaJual;
//    }
//
//    public void setHargaJual(Double HargaJual) {
//        this.HargaJual = HargaJual;
//    }
    private final ObjectProperty<Barang> barang_IdBarang
            = new SimpleObjectProperty<>();

    public Barang getBarang_IdBarang() {
        return barang_IdBarang.get();
    }

    public void setBarang_IdBarang(Barang value) {
        barang_IdBarang.set(value);
    }

    public ObjectProperty barang_IdBarangProperty() {
        return barang_IdBarang;
    }

}
