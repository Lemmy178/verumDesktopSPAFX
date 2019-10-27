/*=============================================================================
 |       Author:  Erick Ruben Ramos Vazquez
 |       Course:  DESKTOP FX SPA
 |     Due Date:  10/27/2019
 |  Description:  PRODUCTWINDOW
 |                
 | Deficiencies:  Pestana product sin construir
 *===========================================================================*/
package com.verum.spa.gui;

import com.jfoenix.controls.JFXDrawer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProductWindow extends Application {

    @FXML
    private JFXDrawer drawer;
    FXMLLoader fxml;
    Stage window;
    Scene scene;

    //Se importa el objeto sideBar, que se separo en otra clase para optimizar el 
    //codigo
    SideBarControl sideBar;

    public ProductWindow() {
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
        sideBar = new SideBarControl(drawer);
    }

}
