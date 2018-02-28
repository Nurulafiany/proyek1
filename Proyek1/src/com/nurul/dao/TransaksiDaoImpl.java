/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.Transaksi;
import com.nurul.entity.User;
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
 * @author Nurul Afiany (1672035)
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
//                ps.setTimestamp(2, t);
                ps.setInt(2, object.getPembayaran());
                ps.setInt(3, object.getUser_idUser().getIdUser());
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
    public int deleteData(Transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int updateData(Transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public List<Transaksi> showAllData() {
        ObservableList<Transaksi> trsks = FXCollections.observableArrayList();
        try {
            try (Connection connection = Koneksi.createConnection()) {
                String query
                        = "SELECT tr.idTransaksi, tr.pembayaran, tr.Tanggal, tr.User_idUser FROM transaksi tr JOIN User u ON tr.User_idUser = u.idUser";
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Transaksi tr = new Transaksi();
                    tr.setIdTransaksi(rs.getInt("tr.idTransaksi"));
                    tr.setTanggal(rs.getTimestamp("tr.Tanggal"));
                    tr.setPembayaran(rs.getInt("tr.pembayaran"));

                    User user = new User();
                    user.setIdUser(rs.getInt("tr.User_idUser"));
//                    user.setNama(rs.getString("u.Nama"));
                    tr.setUser_idUser(user);
                    trsks.add(tr);
                }

            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return trsks;

    }

    @Override
    public Transaksi getData(Transaksi id) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String query
                    = "SELECT idTransaksi, Tanggal, pembayaran, User_idUser, u.Nama FROM Transaksi tk JOIN User u ON tk.User_idUser = u.idUser Where idTransaksi = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id.getIdTransaksi());
            ps.setTimestamp(2, t);
            ps.setInt(3, id.getPembayaran());
            ps.setInt(4, id.getUser_idUser().getIdUser());
            ps.setString(5, id.getUser_idUser().getNama());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Transaksi tr = new Transaksi();
                tr.setIdTransaksi(rs.getInt("tr.idTransaksi"));
                tr.setTanggal(rs.getTimestamp("tr.Tanggal"));
                tr.setPembayaran(rs.getInt("tr.pembayaran"));

                User user = new User();
                user.setIdUser(rs.getInt("User_idUser"));
                user.setNama(rs.getString("u.Nama"));
                tr.setUser_idUser(user);

                return tr;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
