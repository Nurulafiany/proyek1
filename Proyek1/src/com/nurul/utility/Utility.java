/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.utility;

import javafx.scene.control.TextField;

/**
 *
 * @author Nurul Afiany 1672035
 */
public class Utility {

    public static boolean isEmptyField(TextField... textFields) {
        for (TextField tic : textFields) {
            if (tic.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
