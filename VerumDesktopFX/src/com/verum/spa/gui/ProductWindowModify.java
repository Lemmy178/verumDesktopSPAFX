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
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.validation.RequiredFieldValidator;
import com.verum.spa.consume.controller.ProductController;
import com.verum.spa.model.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.StackPane;

public class ProductWindowModify implements Initializable {

    @FXML
    private TextField txtOldProdName;
    @FXML
    private JFXTreeTableView<?> tableProduct;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private TextField txtOldProdBrand;
    @FXML
    private TextField txtOldProdPrice;
    @FXML
    private JFXTextField txtprodName;
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

    RequiredFieldValidator validator = new RequiredFieldValidator();
    ProductController proCtrl;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        creatingTables();
//        tableProducts = null;
        validations();
    }

    public void addingListeners() {
        btnAccept.setOnAction((event) -> {
            String prodName = txtprodName.getText().trim();
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
                txtprodName.setText("");
                txtProdPrice.setText("");
            }
        });

        btnCancel.setOnAction((event) -> {
            txtOldProdBrand.setText("");
            txtOldProdName.setText("");
            txtOldProdPrice.setText("");
            txtProdPrice.setText("");
            txtSearch.setText("");
            txtprodName.setText("");
        });
    }

    public void creatingTables() {
        Product producto = new Product(1, "Producto", "Brand", 8, 0);
        Product product = new Product(2, "Producto", "Brand", 8, 0);

//        tableProducts = new JFXTreeTableView<>();
        TreeTableView<Product> treeTableView = new TreeTableView<Product>();
        TreeTableColumn<Product, Integer> idProCol = new TreeTableColumn<Product, Integer>("ID");
        TreeTableColumn<Product, String> prodName = new TreeTableColumn<Product, String>("Nombre de producto");
        TreeTableColumn<Product, String> prodBrand = new TreeTableColumn<Product, String>("Marca");
        TreeTableColumn<Product, Double> prodUsePrice = new TreeTableColumn<Product, Double>("Precio");
        TreeTableColumn<Product, Integer> prodStatus = new TreeTableColumn<Product, Integer>("Estatus");

        idProCol.setCellValueFactory(new TreeItemPropertyValueFactory<Product, Integer>("prodId"));
        prodName.setCellValueFactory(new TreeItemPropertyValueFactory<Product, String>("prodName"));
        prodBrand.setCellValueFactory(new TreeItemPropertyValueFactory<Product, String>("brand"));
        prodUsePrice.setCellValueFactory(new TreeItemPropertyValueFactory<Product, Double>("useCost"));
        prodStatus.setCellValueFactory(new TreeItemPropertyValueFactory<Product, Integer>("prodStatus"));
        treeTableView.getColumns().addAll(idProCol, prodName, prodBrand, prodUsePrice, prodStatus);

        TreeItem<Product> itemRoot = new TreeItem<Product>(producto);
        itemRoot.getChildren().addAll(itemRoot);
        treeTableView.setRoot(itemRoot);
        StackPane root = new StackPane();
        root.getChildren().add(treeTableView);

    }

    public void validations() {
        //Validations
        txtprodName.getValidators().add(validator);
        validator.setMessage("Es necesario agregar un nombre de producto");
        txtProdPrice.getValidators().add(validator);
        validator.setMessage("Es necesario agregar un precio de producto");

        txtprodName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtprodName.validate();
                }
            }
        });

        txtProdPrice.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtProdPrice.validate();
                }
            }
        });
    }

}
