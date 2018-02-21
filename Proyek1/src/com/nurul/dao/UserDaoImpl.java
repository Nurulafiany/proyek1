/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.Role;
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
 * @author Nurul afiany (1672035)
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
                        = "INSERT INTO User(idUser,Nama,Alamat,Phone_Number,Password,Email,Role_idRole) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, object.getIdUser());
                ps.setString(2, object.getNama());
                ps.setString(3, object.getAlamat());
                ps.setString(4, object.getPhone_Number());
                ps.setString(5, object.getPassword());
                ps.setString(6, object.getEmail());
                ps.setInt(7, object.getRole_idRole().getIdRole());
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
    public int deleteData(User object) {
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query = "DELETE FROM User WHERE idUser=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, object.getIdUser());
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
    public int updateData(User object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "UPDATE User SET idUser = ?, Nama = ?, Alamat = ?, Phone_Number = ?, Email = ? WHERE idUser = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, object.getIdUser());
                ps.setString(2, object.getNama());
                ps.setString(3, object.getAlamat());
                ps.setString(4, object.getPassword());
                ps.setString(5, object.getPhone_Number());
                ps.setString(6, object.getEmail());
                ps.setInt(7, object.getRole_idRole().getIdRole());
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
    public List<User> showAllData() {
        ObservableList<User> usr = FXCollections.observableArrayList();
        try {
            try (Connection connection = Koneksi.createConnection()) {
                String query = "SELECT * FROM User;";
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    User us = new User();
                    us.setIdUser(rs.getString("idUser"));
                    us.setNama(rs.getString("Nama"));
                    us.setAlamat(rs.getString("Alamat"));
                    us.setPhone_Number(rs.getString("Phone_Number"));
                    us.setPassword(rs.getString("Password"));
                    us.setEmail(rs.getString("Email"));

                    Role urole = new Role();
                    urole.setIdRole(rs.getInt("u.Role_idRole"));
                    us.setRole_idRole(urole);
                    usr.add(us);
                }

            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return usr;
    }

    public User getData(User id) {
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String query
                    = "SELECT idUser, Password, Role_idRole FROM User u JOIN Role ro ON u.Role_idRole = ro.idRole WHERE u.idUser = ? and u.Password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id.getIdUser());
            ps.setString(2, id.getPassword());
//            ps.setString(3, id.getAlamat());
//            ps.setString(4, id.getPhone_Number());
//            ps.setString(5, id.getPassword());
//            ps.setString(6, id.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getString("u.idUser"));
//                user.setNama(rs.getString("u.Nama"));
//                user.setAlamat(rs.getString("u.Alamat"));
//                user.setPhone_Number(rs.getString("u.Phone_Number"));
                user.setPassword(rs.getString("u.Password"));
//                user.setEmail(rs.getString("u.Email"));

                Role urole = new Role();
                urole.setIdRole(rs.getInt("u.Role_idRole"));
                user.setRole_idRole(urole);

                return user;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
