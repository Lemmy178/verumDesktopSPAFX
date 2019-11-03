/*=============================================================================
 |       Author:  Erick Ruben Ramos Vazquez
                  Ricardo Iván Ramírez Bello
 |       Course:  Spa
 |     Due Date:  10/18/2019
 |  Description:  MainWindow
 |                
 | Deficiencies:  Falta completar la barra superior
 *===========================================================================*/
package com.verum.spa.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

  
    @FXML private BorderPane borderPanee;
    @FXML private VBox vBoxSide;
    @FXML private JFXButton btnCli;
    @FXML private JFXButton btnEmp;
    @FXML private JFXButton btnSer;
    @FXML private JFXButton btnTre;
    @FXML private JFXButton btnRes;
    @FXML private JFXButton btnSal;
    @FXML private ImageView btnSale;
    @FXML private JFXButton btnSto;
    @FXML private ImageView btnSal1;
    @FXML private JFXButton btnPro;
    @FXML private ImageView btnSale1;
    @FXML private HBox hBoxTop;

    FXMLLoader fxml;
    Stage window;
    Scene scene;
    Parent root = null;

    public MainWindow() throws IOException {
        fxml = new FXMLLoader(System.class.getResource("/com/verum/spa/gui/fxml/main_Window.fxml"));
        fxml.setController(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxml.load();
        scene = new Scene(fxml.getRoot());
        window = primaryStage;
        window.setScene(scene);
        window.show();
        options();
    }

    public void options() throws IOException {
        for (Node node : vBoxSide.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "CLIENT":
                            break;
                        case "EMPLOYEE":
                            break;
                        case "TREATMENT":
                            break;
                        case "SALON":{
                            try {
                                RoomWindow room = new RoomWindow();
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/room_window.fxml"));
                                borderPanee.setCenter(root);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                            break;
                        case "RESERVATION":
                            break;
                        case "STORE":
                            break;
                        case "PRODUCT": {
                            try {
                                ProductWindow pro = new ProductWindow();
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/product_Window.fxml"));
                                borderPanee.setCenter(root);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    }
                });
            }
        }
    }
}
