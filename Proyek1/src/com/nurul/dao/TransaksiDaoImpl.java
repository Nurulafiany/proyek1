/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.Transaksi;
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

/**
 *
 * @author Developer
 */
public class TransaksiDaoImpl implements DaoService<Transaksi> {

    @Override
    public int addData(Transaksi object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Transaksi(idTransaksi,pembayaran,User_idUser) VALUES (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdTransaksi());
                ps.setInt(2, object.getPembayaran());
                ps.setInt(3, object.getUser_idUser());
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
    public int deleteData(Transaksi object) {

    }

    @Override
    public int updateData(Transaksi object) {

    }

    @Override
    public List<Transaksi> showAllData() {

    }

    @Override
    public Transaksi getData(Transaksi id) {
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String query
                    = "SELECT u.idUser, u.Nama, u.Alamat, u.Phone_Number, u.Username, u.Password, u.Email, ro.Role_idRole FROM User u JOIN Role ro ON u.Role_idRole = ro.Role_idRole WHERE u.idUser = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id.getIdTransaksi());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Transaksi tr = new Transaksi();
                tr.setIdUser(rs.getInt("u.idUser"));
                tr.setPassword(rs.getString("u.Password"));
                return tr;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
