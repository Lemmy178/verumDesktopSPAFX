package com.verum.spa.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.verum.spa.model.Product;
import java.awt.Insets;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.StackPane;

public class ProductWindowModify implements Initializable {

    @FXML
    private TextField txtProNamAct;
    @FXML
    private TextField txtProBraAct;
    @FXML
    private TextField txtProQuaAct;
    @FXML
    private TextField txtProPriAct;
    @FXML
    private JFXTextField txtProNam;
    @FXML
    private ComboBox<?> cmbBrand;
    @FXML
    private JFXTextField txtProQua;
    @FXML
    private JFXTextField txtProPrice;
    @FXML
    private JFXButton btnUpdatePro;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXTextField txtSearchPro;
    @FXML
    private JFXTreeTableView<?> tableProducts;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        creatingTables();
//        tableProducts = null;
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

}
