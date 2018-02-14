/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.entity;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

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
    private final DoubleProperty HargaJual = new SimpleDoubleProperty();

    public double getHargaJual() {
        return HargaJual.get();
    }

    public void setHargaJual(double value) {
        HargaJual.set(value);
    }

    public DoubleProperty HargaJualProperty() {
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
    private final IntegerProperty Barang_idBarang = new SimpleIntegerProperty();

    public int getBarang_idBarang() {
        return Barang_idBarang.get();
    }

    public void setBarang_idBarang(int value) {
        Barang_idBarang.set(value);
    }

    public IntegerProperty Barang_idBarangProperty() {
        return Barang_idBarang;
    }

}
