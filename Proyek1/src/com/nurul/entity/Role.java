/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Nurul Afiany (1672035)
 */
public class Role {

    private final IntegerProperty idRole = new SimpleIntegerProperty();

    public int getIdRole() {
        return idRole.get();
    }

    public void setIdRole(int value) {
        idRole.set(value);
    }

    public IntegerProperty idRoleProperty() {
        return idRole;
    }

//
//    int idRole;
//    String Status;
//
//    public Role(int idRole, String Status) {
//        this.idRole = idRole;
//        this.Status = Status;
//    }
//
//    public Role() {
//    }
//
//    public int getIdRole() {
//        return idRole;
//    }
//
//    public void setIdRole(int idRole) {
//        this.idRole = idRole;
//    }
//
//    public String getStatus() {
//        return Status;
//    }
//
//    public void setStatus(String Status) {
//        this.Status = Status;
//    }
    private final StringProperty Status = new SimpleStringProperty();

    public String getStatus() {
        return Status.get();
    }

    public void setStatus(String value) {
        Status.set(value);
    }

    public StringProperty StatusProperty() {
        return Status;
    }

    @Override
    public String toString() {
        return getStatus();
    }

}
