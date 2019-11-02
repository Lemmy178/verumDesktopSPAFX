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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductWindow implements Initializable {

    FXMLLoader fxml;
    Stage window;
    Scene scene;

    @FXML
    private BorderPane proBorderPane;

    @FXML
    private JFXButton btnProAdd;

    @FXML
    private JFXButton btnProAdm;

    @FXML
    private JFXButton btnProList;

    @FXML
    private VBox vBox;

    Parent root = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListeners();
        try {
            windowDefautl();
        } catch (IOException ex) {
            Logger.getLogger(ProductWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addListeners() {
        for (Node node : vBox.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "addProduct":
                            try {
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/product_Window_Add.fxml"));
                                proBorderPane.setCenter(root);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case "admProduct":
                            try {
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/product_Window_Modify.fxml"));
                                proBorderPane.setCenter(root);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case "listProduct":
                            try {
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/product_Window_List.fxml"));
                                proBorderPane.setCenter(root);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                    }
                });
            }
        }

    }

    public void windowDefautl() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/product_Window_Modify.fxml"));
        proBorderPane.setCenter(root);
    }

}
