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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Developer
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
                ps.setString(1, object.getIdBarang());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Barang object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Barang> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
