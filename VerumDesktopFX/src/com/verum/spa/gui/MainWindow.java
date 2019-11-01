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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @FXML
    private JFXButton btnLogOut;
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
    private JFXButton btnSto;
    @FXML
    private VBox vBox;
    @FXML
    private BorderPane borderPanee;

    @FXML
    private Pane pane;
    
    FXMLLoader fxml;
    Stage window;
    Scene scene;
    Parent root = null;

    public MainWindow() throws IOException {
        fxml = new FXMLLoader(System.class.getResource("/com/verum/spa/gui/fxml/MainWindow.fxml"));
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
        //Aqui se menajean las opciones de la barra lateral...
        for (Node node : vBox.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "CLIENT":
                            break;
                        case "EMPLOYEE":
                            break;
                        case "TREATMENT":
                            break;
                        case "SALON":
                            break;
                        case "RESERVATION":
                            break;
                        case "STORE":
                            break;
                        case "PRODUCT": {
                            try {
                                ProductWindow pro = new ProductWindow();
                                root = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/ProductWindow.fxml"));
                                borderPanee.setCenter(root);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    }
//                        case "LOGOUT":
//                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                            alert.setTitle("Confirmacion de salir");
//                            alert.setHeaderText("Confirmar Salida");
//                            alert.setContentText("¿Esta seguro de salir?");
//
//                            Optional<ButtonType> result = alert.showAndWait();
//                            if (result.get() == ButtonType.OK) {
//                                Platform.exit();
//                            }
//                            break;
//                    }
                });
            }
        }
    }
}
