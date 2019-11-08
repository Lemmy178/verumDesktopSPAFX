/*=============================================================================
 |       Author:  Erick Ruben Ramos Vazquez
 |       Course:  Spa
 |     Due Date:  10/28/2019
 |  Description:  ProductWindowAdd
 |                
 | Deficiencies:  Idea, permitir manejar nulos, detectarlos en controlador
                  y no acualizar esos en BD para no generar NULLS

                  
 *===========================================================================*/
package com.verum.spa.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.verum.spa.consume.controller.ProductController;
import com.verum.spa.model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductWindowModify implements Initializable {

    @FXML
    private TextField txtOldProdName;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private TextField txtOldProdBrand;
    @FXML
    private TextField txtOldProdPrice;
    @FXML
    private JFXTextField txtProdName;
    @FXML
    private ComboBox<?> cmbProdBrand;
    @FXML
    private JFXTextField txtProdPrice;
    @FXML
    private JFXButton btnAccept;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXCheckBox checkBoxProduct;
    @FXML
    private JFXComboBox<?> cmbEstatus;
    @FXML
    private TextField txtOldProdEstatus;

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> columnProductID;
    @FXML
    private TableColumn<Product, String> columnProductName;
    @FXML
    private TableColumn<Product, String> columnProductBrand;
    @FXML
    private TableColumn<Product, Double> columnProductPrice;
    @FXML
    private TableColumn<Product, Integer> columnProductStatus;

    private RequiredFieldValidator validator = new RequiredFieldValidator();
    private ProductController proCtrl = new ProductController();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private ObservableList<Product> masterData = FXCollections.observableArrayList();
    private ObservableList<Product> filteredData = FXCollections.observableArrayList();

    public ProductWindowModify() {
        addValues();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        creatingTables();
        validations();
        addingListeners();
    }

    /* <------------------------LISTENERS---------------------------------------------------------------------->*/
    public void addingListeners() {
        //Accept Button 
        btnAccept.setOnAction((event) -> {
            String prodName = txtProdName.getText().trim();
//            String prodBrand = cmbProdBrand.getValue().toString();
            String prodPrice = txtProdPrice.getText().trim();

            if (prodName == null || /*prodBrand == null ||*/ prodPrice == null) {
                alert.setHeaderText("Resultado de operacion:");
                alert.setContentText("Todos los campos deben estar llenos");
                alert.showAndWait();
            } else {
                String resutl = proCtrl.addProductController(prodName, "hola",
                        Double.parseDouble(prodPrice));
                alert.setHeaderText("Resultado de operacion:");
                alert.setContentText(resutl);
                alert.showAndWait();
                txtProdName.setText("");
                txtProdPrice.setText("");
            }
        });

        //Cancel Button
        btnCancel.setOnAction((event) -> {
            txtOldProdBrand.setText("");
            txtOldProdName.setText("");
            txtOldProdPrice.setText("");
            txtProdPrice.setText("");
            txtSearch.setText("");
            txtProdName.setText("");
        });

        //Selected Item
        productTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
                txtOldProdName.setText(newValue.getProdName());
                txtOldProdBrand.setText(newValue.getBrand());
                txtOldProdPrice.setText(String.valueOf(newValue.getUseCost()));
                if (newValue.getProdStatus() == 0) {
                    txtOldProdEstatus.setText("Inactivo");
                } else {
                    txtOldProdEstatus.setText("Activo");
                }

            }
        });
    }

    /* <------------------------VALIDATIONS---------------------------------------------------------------------->*/
    public void validations() {
        txtProdName.getValidators().add(validator);
        validator.setMessage("Es necesario agregar un nombre de producto");
        txtProdPrice.getValidators().add(validator);
        validator.setMessage("Es necesario agregar un precio de producto");

        txtProdName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtProdName.validate();
                }
            }
        });
    }

    /* <------------------------ADDING VALUES---------------------------------------------------------------------->*/
    public void addValues() {
        Platform.runLater(() -> {
            try {
                ArrayList<Product> productData = proCtrl.productList();
                if (productData != null) {
                    for (Product product : productData) {
                        masterData.add(product);
                    }
                    filteredData.addAll(masterData);
                } else {
                    alert.setHeaderText("Error:");
                    alert.setContentText("No se logro recopilar la informacion de los productos");
                    alert.showAndWait();
                }
            } catch (IOException ex) {
                Logger.getLogger(ProductWindowModify.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    /* <------------------------ADDING CELL VALUES---------------------------------------------------------------------->*/
    public void creatingTables() {
        columnProductID.setCellValueFactory(new PropertyValueFactory<Product, Integer>("ProdId"));
        columnProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("ProdName"));
        columnProductBrand.setCellValueFactory(new PropertyValueFactory<Product, String>("Brand"));
        columnProductStatus.setCellValueFactory(new PropertyValueFactory<Product, Integer>("ProdStatus"));
        columnProductPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("UseCost"));
        productTable.setItems(masterData);
    }

}
