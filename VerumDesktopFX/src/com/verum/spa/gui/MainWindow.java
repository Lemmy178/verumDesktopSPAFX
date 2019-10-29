package com.verum.spa.gui;

import com.jfoenix.controls.JFXButton;
import java.awt.Paint;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
    private AnchorPane anchorPane;

    FXMLLoader fxml;
    Stage window;
    Scene scene;

    public MainWindow() {
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
        for (Node node : vBox.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "CLIENT":
                            anchorPane.getChildren().setAll(FXMLLoader.load("/com/verum/spa/gui/fxml/MainWindow.fxml"));
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
    }
}
