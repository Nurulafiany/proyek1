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
                        = "INSERT INTO Barang(IdBarang,NamaBrg,HargaBeli,HargaJual,Stock) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdUser());
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
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query = "DELETE FROM barang WHERE id=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdUser());
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
                String query = "UPDATE User SET name=?,price=?,description=?,"
                        + "recomended=?,created=?,category_id=? WHERE id=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdUser());
                ps.setString(1, object.getNama());
                ps.setString(2, object.getAlamat());
                ps.setString(2, object.getUsername());
                ps.setString(2, object.getPassword());
                ps.setString(2, object.getPhone_Number());
                ps.setString(2, object.getEmail());
                ps.setInt(1, object.getRole_idRole());
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
        ObservableList<User> users = FXCollections.observableArrayList();
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
        return users;
    }

    public User getData(User id) {
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String query
                    = "SELECT u.idUser, u.Nama, u.Alamat, u.Phone_Number, u.Username, u.Password, u.Email, ro.Role_idRole FROM User u JOIN Role ro ON u.Role_idRole = ro.Role_idRole WHERE u.idUser = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id.getIdUser());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("u.idUser"));
                user.setPassword(rs.getString("u.Password"));
                user.setNama(rs.getString("u.Nama"));
                user.setAlamat(rs.getString("u.Alamat"));
                user.setPhone_Number(rs.getString("u.Phone_Number"));
                user.setUsername(rs.getString("u.Username"));
                user.setEmail(rs.getString("u.Email"));
                user.setRole_idRole(rs.getInt("u.Role_idRole"));

                return user;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
