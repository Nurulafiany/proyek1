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
                        = "INSERT INTO Transaksi(idTransaksi,Tanggal,pembayaran,User_idUser) VALUES (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdTransaksi());
                ps.setTimestamp(2, t);
                ps.setInt(3, object.getPembayaran());
                ps.setInt(4, object.getUser_idUser());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int updateData(Transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public List<Transaksi> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Transaksi getData(Transaksi id) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String query
                    = "SELECT idTransaksi, Tanggal, pembayaran, User_idUser FROM Transaksi tk JOIN User u ON tk.User_idUser = u.idUser Where idTransaksi = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id.getIdTransaksi());
            ps.setTimestamp(2, t);
            ps.setInt(3, id.getPembayaran());
            ps.setInt(4, id.getUser_idUser());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Transaksi tr = new Transaksi();
                tr.setIdTransaksi(rs.getInt("tr.idTransaksi"));
                //    tr.setTanggal(rs.getTimestamp("tr.Tanggal"));
                tr.setPembayaran(rs.getInt("tr.pembayaran"));
                tr.setUser_idUser(rs.getInt("tr.User_idUser"));

                return tr;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
