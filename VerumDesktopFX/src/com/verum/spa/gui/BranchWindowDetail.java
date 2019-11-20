/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verum.spa.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 *
 * @author moi_3
 */
public class BranchWindowDetail{

    @FXML
    private JFXButton btnAddBranch;

    @FXML
    private JFXButton btnSaveBranch;

    @FXML
    private JFXButton btnDeleteBranch;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtLatitude;

    @FXML
    private JFXTextField txtLongitude;

    @FXML
    private JFXComboBox cmbStatus;

    
    
    FXMLLoader fxmll;
    
    public BranchWindowDetail(){
        fxmll = new FXMLLoader(getClass().getResource("/com/verum/spa/gui/fxml/branch_window_master.fxml"));
        fxmll.setController(this);
    }             
    
    private void addListeners(){                                    
        
        btnAddBranch.setOnAction(evt -> {            
        });               
    
        btnDeleteBranch.setOnAction(evt -> {        
        });
        
        btnSaveBranch.setOnMouseClicked(evt ->{            
        });                
    }
    
//    public Node getPanel(){                
//        return fxmll.;
//    }
    
}
