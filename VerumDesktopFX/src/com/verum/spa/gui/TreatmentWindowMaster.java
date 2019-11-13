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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TreatmentWindowMaster implements Initializable {

    FXMLLoader fxml;
    Stage window;
    Scene scene;
    
    @FXML TableView tblvTreatTable;
    @FXML TableColumn tblcColumn1;
    @FXML TableColumn tblcColumn2;
    
    Parent root = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
