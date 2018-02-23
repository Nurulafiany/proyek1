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
 * @author Developer
 */
public class Cart {

    private final IntegerProperty KodeBarangTr = new SimpleIntegerProperty();

    public int getKodeBarangTr() {
        return KodeBarangTr.get();
    }

    public void setKodeBarangTr(int value) {
        KodeBarangTr.set(value);
    }

    public IntegerProperty KodeBarangTrProperty() {
        return KodeBarangTr;
    }
    private final StringProperty NamaBarangTr = new SimpleStringProperty();

    public String getNamaBarangTr() {
        return NamaBarangTr.get();
    }

    public void setNamaBarangTr(String value) {
        NamaBarangTr.set(value);
    }

    public StringProperty NamaBarangTrProperty() {
        return NamaBarangTr;
    }
    private final IntegerProperty JmlBarangTr = new SimpleIntegerProperty();

    public int getJmlBarangTr() {
        return JmlBarangTr.get();
    }

    public void setJmlBarangTr(int value) {
        JmlBarangTr.set(value);
    }

    public IntegerProperty JmlBarangTrProperty() {
        return JmlBarangTr;
    }
    private final IntegerProperty HargaBarangTr = new SimpleIntegerProperty();

    public int getHargaBarangTr() {
        return HargaBarangTr.get();
    }

    public void setHargaBarangTr(int value) {
        HargaBarangTr.set(value);
    }

    public IntegerProperty HargaBarangTrProperty() {
        return HargaBarangTr;
    }

    public Cart() {
    }

    public Cart(int KodeBarangTr, String NamaBarangTr, int JmlBarangTr,
            int HargaBarangTr) {
        this.setKodeBarangTr(KodeBarangTr);
        this.setNamaBarangTr(NamaBarangTr);
        this.setHargaBarangTr(HargaBarangTr);
    }

    @Override
    public String toString() {
        return String.valueOf(getKodeBarangTr()) + " - " + getNamaBarangTr();
    }

}
