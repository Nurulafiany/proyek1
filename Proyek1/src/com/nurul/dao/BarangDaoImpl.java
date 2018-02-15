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
import java.sql.Timestamp;
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
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Barang(IdBarang,NamaBrg,HargaBeli,HargaJual,Stock) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdBarang());
                ps.setString(2, object.getNamaBrg());
                ps.setDouble(3, object.getHargaBeli());
                ps.setDouble(4, object.getHargaJual());
                ps.setInt(5, object.getStock());
                if (ps.executeUpdate() != 0) {
                    connection.commit();

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
                String query = "DELETE FROM barang WHERE id=?";
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
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query = "UPDATE Barang SET name=?,price=?,description=?,"
                        + "recomended=?,created=?,category_id=? WHERE id=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdBarang());
                ps.setString(1, object.getNamaBrg());
                ps.setDouble(2, object.getHargaBeli());
                ps.setDouble(2, object.getHargaJual());
                ps.setInt(3, object.getStock());
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
                String query = "SELECT m.*, c.id AS cat_id, c.name AS "
                        + "cat_name FROM menu m JOIN category c on c.id "
                        + "= m.category_id ORDER BY c.id ASC, m.id";
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

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
                    = "SELECT u.idUser, u.Nama, u.Alamat, u.Phone_Number, u.Username, u.Password, u.Email, ro.Role_idRole FROM User u JOIN Role ro ON u.Role_idRole = ro.Role_idRole WHERE u.idUser = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id.getIdBarang());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Barang barang = new Barang();
                barang.setIdBarang(rs.getInt("u.idUser"));
                barang.setNamaBrg(rs.getString("u.Password"));
                barang.setHargaBeli(rs.getInt("u.Nama"));
                barang.setHargaJual(rs.getInt("u.Nama"));
                barang.setStock(rs.getInt("br.stock"));

                return barang;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
