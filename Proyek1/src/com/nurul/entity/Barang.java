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
public class Barang {

    String idBarang;
    String NamaBrg;
    Double HargaBeli;
    Double HargaJual;
    int Stock;

    public Barang(String idBarang, String NamaBrg, Double HargaBeli,
            Double HargaJual, int Stock) {
        this.idBarang = idBarang;
        this.NamaBrg = NamaBrg;
        this.HargaBeli = HargaBeli;
        this.HargaJual = HargaJual;
        this.Stock = Stock;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBrg() {
        return NamaBrg;
    }

    public void setNamaBrg(String NamaBrg) {
        this.NamaBrg = NamaBrg;
    }

    public Double getHargaBeli() {
        return HargaBeli;
    }

    public void setHargaBeli(Double HargaBeli) {
        this.HargaBeli = HargaBeli;
    }

    public Double getHargaJual() {
        return HargaJual;
    }

    public void setHargaJual(Double HargaJual) {
        this.HargaJual = HargaJual;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

}
