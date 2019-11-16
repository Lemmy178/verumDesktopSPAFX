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
import java.awt.Dimension;
import java.awt.Toolkit;
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

    @FXML
    private BorderPane borderPanee;
    @FXML
    private VBox vBoxSide;
    @FXML
    private JFXButton btnCli;
    @FXML
    private JFXButton btnEmp;
    @FXML
    private JFXButton btnSer;
    @FXML
    private JFXButton btnTre;
    @FXML
    private JFXButton btnRes;
    @FXML
    private JFXButton btnSal;
    @FXML
    private ImageView btnSale;
    @FXML
    private JFXButton btnSto;
    @FXML
    private ImageView btnSal1;
    @FXML
    private JFXButton btnPro;
    @FXML
    private ImageView btnSale1;
    @FXML
    private HBox hBoxTop;

    FXMLLoader fxml;
    Stage window;
    Scene scene;
    Parent root = null;
//    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

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
        window.setMinHeight(600);
        window.setMinWidth(800);
        window.show();
        options();
    }

    public void options() throws IOException {
        for (Node node : vBoxSide.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "CUSTOMER": {
                            try {                                
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/customer_window_master.fxml"));
                                borderPanee.setCenter(root);
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/customer_window_detail.fxml"));
                                borderPanee.setRight(root);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case "EMPLOYEE": {
                            try {
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/employee_window_master.fxml"));
                                borderPanee.setCenter(root);
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/employee_window_detail.fxml"));
                                borderPanee.setRight(root);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case "TREATMENT": {
                            try {
//                                TreatmentWindow treat = new TreatmentWindow();
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/treatment_window.fxml"));
                                borderPanee.setCenter(root);
                                borderPanee.getRight().setVisible(false);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case "ROOM": {
                            try {
//                                RoomWindow room = new RoomWindow();
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/room_window.fxml"));
                                borderPanee.setCenter(root);
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/room_detail.fxml"));
                                borderPanee.setRight(root);
//                                borderPanee.getRight().setVisible(false);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case "RESERVATION":
                            borderPanee.getRight().setVisible(false);
                            break;
                        case "BRANCH": {
                            try {
//                                BranchWindow branch = new BranchWindow();
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/branch_window_master.fxml"));
                                borderPanee.setCenter(root);
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/branch_window_detail.fxml"));
                                borderPanee.setRight(root);
                            } catch (IOException ex) {                                
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case "PRODUCT": {
                            try {
//                                ProductWindow pro = new ProductWindow();
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/product_Window_Modify.fxml"));
                                borderPanee.setCenter(root);
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/product_detail2.fxml"));
                                borderPanee.setRight(root);

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
