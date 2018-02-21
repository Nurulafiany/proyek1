/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.Barang;
import com.nurul.utility.DaoService;
import com.nurul.utility.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Nurul afiany (1672035)
 */
public class BarangDaoImpl implements DaoService<Barang> {

    @Override
    public int addData(Barang object) {
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Barang(idBarang,NamaBrg,HargaBeli,HargaJual,Stock) VALUES (?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdBarang());
                ps.setString(2, object.getNamaBrg());
                ps.setInt(3, object.getHargaBeli());
                ps.setInt(4, object.getHargaJual());
                ps.setInt(5, object.getStock());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;

                } else {
                    connection.rollback();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public int deleteData(Barang object) {
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query = "DELETE FROM Barang WHERE idBarang=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdBarang());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public int updateData(Barang object) {
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "UPDATE Barang SET NamaBrg = ?,HargaBeli = ?, HargaJual = ?,Stock = ? WHERE idBarang = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, object.getNamaBrg());
                ps.setInt(2, object.getHargaBeli());
                ps.setInt(3, object.getHargaJual());
                ps.setInt(4, object.getStock());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public List<Barang> showAllData() {
        ObservableList<Barang> brg = FXCollections.observableArrayList();
        try {
            try (Connection connection = Koneksi.createConnection()) {
                String query = "SELECT * from Barang;";
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Barang bar = new Barang();
                    bar.setIdBarang(rs.getInt("idBarang"));
                    bar.setNamaBrg(rs.getString("NamaBrg"));
                    bar.setHargaBeli(rs.getInt("HargaBeli"));
                    bar.setHargaJual(rs.getInt("HargaJual"));
                    bar.setStock(rs.getInt("Stock"));

                    brg.add(bar);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return brg;
    }

    @Override
    public Barang getData(Barang id) {
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String query
                    = "SELECT idBarang, NamaBrg, HargaBeli, HargaJual, Stock FROM Barang";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id.getIdBarang());
            ps.setString(2, id.getNamaBrg());
            ps.setInt(3, id.getHargaBeli());
            ps.setInt(4, id.getHargaJual());
            ps.setInt(5, id.getStock());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Barang barang = new Barang();
                barang.setIdBarang(rs.getInt("idBarang"));
                barang.setNamaBrg(rs.getString("NamaBrg"));
                barang.setHargaBeli(rs.getInt("HargaBeli"));
                barang.setHargaJual(rs.getInt("Hargajual"));
                barang.setStock(rs.getInt("Stock"));

                return barang;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
