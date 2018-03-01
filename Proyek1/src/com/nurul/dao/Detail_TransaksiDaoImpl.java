/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.Barang;
import com.nurul.entity.Detail_Transaksi;
import com.nurul.entity.Transaksi;
import com.nurul.entity.User;
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
public class Detail_TransaksiDaoImpl implements DaoService<Detail_Transaksi> {

    @Override
    public int addData(Detail_Transaksi object) {
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Detail_Transaksi(Transaksi_idTransaksi,Barang_idBarang,QtyBarang,HargaJual) VALUES (?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getTransaksi_idTransaksi().getIdTransaksi());
                ps.setInt(2, object.getBarang_idBarang().getIdBarang());
                ps.setInt(3, object.getQtyBarang());
                ps.setInt(4, object.getHargaJual());

                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Detail_TransaksiDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
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
        ObservableList<Detail_Transaksi> relPenjs = FXCollections.
                observableArrayList();
        try {
            try (Connection connection = Koneksi.createConnection()) {
                String query
                        = "SELECT t.tgl_Transaksi, t.kd_Transaksi, b.kd_Barang, b.nm_Barang, dt.jml, dt.saling_price,u.kd_User FROM detail_transaksi dt JOIN transaksi t ON dt.transaksi_kd_Transaksi = t.kd_Transaksi JOIN User u ON t.user_kd_User = u.kd_User JOIN Barang b ON b.kd_Barang = dt.barang_kd_Barang";

                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Detail_Transaksi detail_transaksi = new Detail_Transaksi();
                    Transaksi transaksis = new Transaksi();
                    User user = new User();
                    Barang barang = new Barang();

                    transaksis.setIdTransaksi(rs.getInt("t.idTransaksi"));
                    user.setIdUser(rs.getInt("u.idUser"));
                    barang.setIdBarang(rs.getInt("b.idBarang"));
                    barang.setNamaBrg(rs.getString("b.NamaBrg"));

                    detail_transaksi.setQtyBarang(rs.getInt("dt.QtyBarang"));
                    detail_transaksi.setHargaJual(rs.
                            getInt("dt.HargaJual"));

                    transaksis.setTanggal(rs.getTimestamp(
                            "t.Tanggal"));

                    detail_transaksi.setBarang_idBarang(barang);
                    transaksis.setUser_idUser(user);
                    detail_transaksi.setTransaksi_idTransaksi(transaksis);
                    relPenjs.add(detail_transaksi);

                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BarangDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return relPenjs;
    }

    @Override
    public Detail_Transaksi getData(Detail_Transaksi id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//        try (Connection connection = Koneksi.createConnection()) {
//            connection.setAutoCommit(false);
//            String query
//                    = "SELECT Transaksi_idTransaksi, Barang_idBarang, QtyBarang, dt.HargaJual FROM Detail_Transaksi dt JOIN Barang br ON dt.Barang_idBarang = br.idBarang JOIN Transaksi tk ON dt.Transaksi_idTransaksi = tk.idTransaksi";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, id.getTransaksi_idTransaksi());
//            ps.setInt(2, id.getBarang_idBarang());
//            ps.setInt(3, id.getQtyBarang());
//            ps.setInt(4, id.getHargaJual());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Detail_Transaksi dt = new Detail_Transaksi();
//                dt.setBarang_idBarang(rs.getInt("u.idUser"));
//                dt.setQtyBarang(rs.getInt("u.Password"));
//                dt.setTransaksi_idTransaksi(rs.getInt("u.Nama"));
//                dt.setHargaJual(rs.getInt("u.Nama"));
//
//                return dt;
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(UserDaoImpl.class.getName()).
//                    log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    }
}
