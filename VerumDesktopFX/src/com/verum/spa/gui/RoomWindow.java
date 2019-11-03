/*=============================================================================
 |       Author:  Erick Ruben Ramos Vazquez
 |       Course:  Spa
 |     Due Date:  10/28/2019
 |  Description:  ProductWindow
 |                
 | Deficiencies:  No por el momento
 *===========================================================================*/
package com.verum.spa.gui;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoomWindow implements Initializable {

    FXMLLoader fxml;
    Stage window;
    Scene scene;
    
    @FXML TreeTableView trtRoom;
    @FXML TextField txtRoomName;
    @FXML TextArea txaRoomDesc;
    @FXML TextField txtRoomStatus;
    
    @FXML ImageView imgvRoomPhoto;
    
    Parent root = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    

    

}
