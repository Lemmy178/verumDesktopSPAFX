/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verum.spa.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Edson
 */
public class CustomerWindowMaster implements Initializable {

    @FXML
    Button btnNewEmployee;
    @FXML
    Button btnSaveEmployee;
    @FXML
    BorderPane empMasterBorder;

    Parent root = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addListeners() {

    }

}
