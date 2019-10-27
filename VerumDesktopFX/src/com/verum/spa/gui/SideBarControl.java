/*=============================================================================
 |       Author:  Erick Ruben Ramos Vazquez
 |       Course:  DESKTOP FX SPA
 |     Due Date:  10/27/2019
 |  Description:  PRODUCTWINDOW
 |                
 | Deficiencies:  Codigo sideBar optimizado, falta agregar opciones y funciones
 *===========================================================================*/
package com.verum.spa.gui;

import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.util.Optional;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

public class SideBarControl {

    public SideBarControl(JFXDrawer drawer) {
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/com/verum/spa/gui/fxml/SideBar.fxml"));
            drawer.setSidePane(box);
            drawer.open();
            for (Node node : box.getChildren()) {
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
