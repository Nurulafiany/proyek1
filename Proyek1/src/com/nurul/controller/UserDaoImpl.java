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
public class UserDaoImpl implements DaoService<User> {

    @Override
    public int addData(User object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO User(idUser,Nama,Alamat,Phone_Number,Username,Password,Email,Role_idRole) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, object.getIdUser());
                ps.setString(2, object.getNama());
                ps.setString(3, object.getAlamat());
                ps.setString(4, object.getPhone_Number());
                ps.setString(5, object.getUsername());
                ps.setString(6, object.getPassword());
                ps.setString(7, object.getEmail());
                ps.setInt(8, object.getRole_idRole());
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

    @Override
    public User getData(Object id) {
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "SELECT u.idUser, u.Password, ro.Role_idRole FROM User u JOIN Role ro ON u.Role_idRole = ro.idRole";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, id.getIdUser());
                ps.setString(2, id.getPassword);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    User user = new User();
                    user.setIdUser(rs.getString("u.idUser"));
                    user.setIdUser(rs.getString("u.Password"));
//                    user.setRole_idRole(0);
                    return user;

                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

            return (null);
        }
    }

}
