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
 * @author Nurul
 */
public class Barang {

    private final IntegerProperty idBarang = new SimpleIntegerProperty();

    public int getIdBarang() {
        return idBarang.get();
    }

    public void setIdBarang(int value) {
        idBarang.set(value);
    }

    public IntegerProperty idBarangProperty() {
        return idBarang;
    }
    private final IntegerProperty HargaBeli = new SimpleIntegerProperty();

    public int getHargaBeli() {
        return HargaBeli.get();
    }

    public void setHargaBeli(int value) {
        HargaBeli.set(value);
    }

    public IntegerProperty HargaBeliProperty() {
        return HargaBeli;
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
    private final IntegerProperty Stock = new SimpleIntegerProperty();

    public int getStock() {
        return Stock.get();
    }

    public void setStock(int value) {
        Stock.set(value);
    }

    public IntegerProperty StockProperty() {
        return Stock;
    }

    private final StringProperty NamaBrg = new SimpleStringProperty();

    public String getNamaBrg() {
        return NamaBrg.get();
    }

    public void setNamaBrg(String value) {
        NamaBrg.set(value);
    }

    public StringProperty NamaBrgProperty() {
        return NamaBrg;
    }

//
//    int idBarang;
//    String NamaBrg;
//    int HargaBeli;
//    int HargaJual;
//    int Stock;
//
//    public Barang() {
//    }
//
//    public Barang(int idBarang, String NamaBrg, Double HargaBeli,
//            Double HargaJual, int Stock) {
//        this.idBarang = idBarang;
//        this.NamaBrg = NamaBrg;
//        this.HargaBeli = HargaBeli;
//        this.HargaJual = HargaJual;
//        this.Stock = Stock;
//    }
//
//    public int getIdBarang() {
//        return idBarang;
//    }
//
//    public void setIdBarang(int idBarang) {
//        this.idBarang = idBarang;
//    }
//
//    public String getNamaBrg() {
//        return NamaBrg;
//    }
//
//    public void setNamaBrg(String NamaBrg) {
//        this.NamaBrg = NamaBrg;
//    }
//
//    public Double getHargaBeli() {
//        return HargaBeli;
//    }
//
//    public void setHargaBeli(Double HargaBeli) {
//        this.HargaBeli = HargaBeli;
//    }
//
//    public Double getHargaJual() {
//        return HargaJual;
//    }
//
//    public void setHargaJual(Double HargaJual) {
//        this.HargaJual = HargaJual;
//    }
//
//    public int getStock() {
//        return Stock;
//    }
//
//    public void setStock(int Stock) {
//        this.Stock = Stock;
//    }
}
