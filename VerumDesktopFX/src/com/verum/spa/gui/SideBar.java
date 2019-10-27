package com.verum.spa.gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SideBar extends Application {

    @FXML
    private JFXButton btnCli;

    @FXML
    private JFXButton btnEmp;

    @FXML
    private JFXButton btnSer;

    @FXML
    private JFXButton btnTre;

    @FXML
    private JFXButton btnRoo;

    @FXML
    private JFXButton btnRes;

    @FXML
    private JFXButton btnSto;

    @FXML
    private JFXButton btnLogOut;

    FXMLLoader fxml;
    Stage window;
    Scene scene;

    public SideBar() {
        fxml = new FXMLLoader(System.class.getResource("/com/verum/spa/gui/fxml/SideBar.fxml"));
        fxml.setController(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxml.load();
        scene = new Scene(fxml.getRoot());
        window = primaryStage;
        window.setScene(scene);
        window.show();
        addListeners();
    }

    public void addListeners(){}
}
