package com.verum.spa.gui;

import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductWindow extends Application {

    @FXML
    private JFXDrawer drawer;
    FXMLLoader fxml;
    Stage window;
    Scene scene;
    
    public ProductWindow(){
        fxml = new FXMLLoader(System.class.getResource("/com/verum/spa/gui/fxml/ProductWindow.fxml"));
        fxml.setController(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxml.load();
        scene = new Scene(fxml.getRoot());
        window = primaryStage;
        window.setScene(scene);
        window.show();
        menu();
    }

    public void menu() throws IOException {
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/SideBar.fxml"));
            drawer.setSidePane(box);
            drawer.open();
            for (Node node : box.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (e) -> {
                        switch (node.getAccessibleText()) {
                            case "SALES":
                                break;
                            case "GRAPHICS":
                                break;
                            case "INVENTORY":
                                break;
                            case "ADMIN":
                                break;
                            case "LOGOUT":
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Confirmacion de salir");
                                alert.setHeaderText("Confirmar Salida");
                                alert.setContentText("¿Esta seguro de salir?");

                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.get() == ButtonType.OK) {
                                    Platform.exit();
                                }
                                break;
                        }
                    });
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
