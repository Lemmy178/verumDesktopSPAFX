/*=============================================================================
 |       Author:  Ricardo Iván Ramírez Bello
 |       Course:  Spa
 |     Due Date:  11/03/2019
 |  Description:  Treatment Window
 |                
 | Deficiencies:  No por el momento
 *===========================================================================*/
package com.verum.spa.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelTreatment implements Initializable {

    FXMLLoader fxml;
    Stage window;
    Scene scene;
    
    @FXML TextField txtName;
    @FXML TextField txtCost;
    @FXML ComboBox cmbStatus;
    @FXML TextArea txaDescription;
    
    @FXML Button btnNew;
    @FXML Button btnSave;
    @FXML Button btnDelete;
    
    @FXML VBox vBox;
    
    Parent root = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void addListeners() {
        for (Node node : vBox.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "add":
                            break;
                        case "update":
                            break;
                        case "delete":
                            break;
                    }
                });
            }
        }
    }
    

    

}
