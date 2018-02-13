/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.Detail_Transaksi;
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

/**
 *
 * @author Nurul afiany (1672035)
 */
public class Detail_TransaksiDaoImpl implements DaoService<Detail_Transaksi> {

    @Override
    public int addData(Detail_Transaksi object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Detail_Transaksi(IdBarang,NamaBrg,HargaBeli,HargaJual,Stock) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getTransaksi_idTransaksi());
                ps.setInt(1, object.getBarang_idBarang());
                ps.setInt(1, object.getQtyBarang());
                ps.setDouble(7, object.getHargaJual());
                
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
    public int deleteData(Detail_Transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Detail_Transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Detail_Transaksi> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detail_Transaksi getData(Detail_Transaksi id) {
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String query
                    = "SELECT dt.Transaksi_idTransaksi, dt.Barang_idBarang, dt.QtyBarang, dt.HargaJual FROM Detail_Transaksi";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id.getTransaksi_idTransaksi());
            ps.setInt(1, id.getBarang_idBarang());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Detail_Transaksi dt = new Detail_Transaksi();
                dt.setBarang_idBarang(rs.getInt("u.idUser"));
                dt.setQtyBarang(rs.getInt("u.Password"));
                dt.setTransaksi_idTransaksi(rs.getInt("u.Nama"));
                dt.setHargaJual(rs.getDouble("u.Nama"));
                
                return dt;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
