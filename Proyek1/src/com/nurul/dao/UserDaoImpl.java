/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.User;
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
public class UserDaoImpl implements DaoService<User> {

    @Override
    public int addData(User object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Barang(IdBarang,NamaBrg,HargaBeli,HargaJual,Stock) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, object.getIdUser());
                ps.setString(2, object.getNama());
                ps.setString(3, object.getAlamat());
                ps.setString(4, object.getPhone_Number());
                ps.setString(5, object.getUsername());
                ps.setString(6, object.getPassword());
                ps.setString(6, object.getEmail());
                ps.setInt(7, object.getRole_idRole());
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
    public int deleteData(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
