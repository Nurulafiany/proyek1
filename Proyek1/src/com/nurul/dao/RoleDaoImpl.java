/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.Role;
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
public class RoleDaoImpl implements DaoService<Role> {

    @Override
    public int addData(Role object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Role(idRole,Status) VALUES (?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdRole());
                ps.setString(2, object.getStatus());
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
    public int deleteData(Role object) {
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "DELETE FROM Role WHERE idRole = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdRole());
                ps.setString(2, object.getStatus());
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
    public int updateData(Role object) {
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "UPDATE Role SET idRole = ?, Status = ? WHERE idRole = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdRole());
                ps.setString(2, object.getStatus());
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
    public List<Role> showAllData() {
        ObservableList<Role> ro = FXCollections.observableArrayList();
        try {
            try (Connection connection = Koneksi.createConnection()) {
                String query
                        = "SELECT * FROM Role;";
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Role role = new Role();
                    role.setIdRole(rs.getInt("idRole"));
                    role.setStatus(rs.getString("Status"));

                    ro.add(role);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return ro;
    }

    @Override
    public Role getData(Role id) {
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String query
                    = "SELECT * FROM Role WHERE idRole=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id.getIdRole());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Role role = new Role();
                role.setIdRole(rs.getInt("idRole"));
                role.setStatus(rs.getString("Status"));

                return role;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
