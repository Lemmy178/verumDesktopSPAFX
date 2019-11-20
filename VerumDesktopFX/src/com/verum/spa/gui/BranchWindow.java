
package com.verum.spa.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.verum.spa.consume.controller.BranchController;
import com.verum.spa.model.Branch;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author moi_3
 */
public class BranchWindow implements Initializable{  
    
    @FXML TableView<Branch> tblList;    
    @FXML JFXTextField txtAddress;
    @FXML JFXTextField txtLatitude;
    @FXML JFXTextField txtLongitude;
    @FXML JFXTextField txtName;
    @FXML JFXComboBox cmbStatus;
    
    @FXML JFXButton btnSearch;
    @FXML JFXButton btnList;
    @FXML JFXButton btnAddBranch;
    @FXML JFXButton btnUpdateData;
    @FXML JFXButton btnDeleteBranch;        
    
    @FXML JFXButton btnSave;
           
    FXMLLoader fxmll;
    Stage window;
    Scene scene;
    
    BranchController branchCtrl;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListeners();
        fillComboBoxes();
        fillTableView();        
    }
    
    private void addListeners(){            
        btnSearch.setOnAction(evt -> {});
        
        btnList.setOnAction(evt -> {});
        
        btnAddBranch.setOnAction(evt -> {
            enableFields();
            btnSave.setVisible(true);
            btnSave.setDisable(false);            
        });
        
        btnUpdateData.setOnAction(evt -> {
            enableFields();
            if(checkFields()){
            
            
            }
        });
    
        btnDeleteBranch.setOnAction(evt -> {
//            branchCtrl.modifyBranchController(txtName.getText(),txtAddress.getText(), Double.parseDouble(txtLatitude.getText()), Double.parseDouble(txtLongitude.getText()), true);
//            btnSave.setDisable(true);
//            btnSave.setVisible(false);
//            disableFields();
        
        });
        
        btnSave.setOnAction(evt -> {
            if(checkFields()){
                //String branchName, String branchAddress, double latitude, double longitude, boolean branchStatus
                branchCtrl.addBranchController(txtName.getText(),txtAddress.getText(), Double.parseDouble(txtLatitude.getText()), Double.parseDouble(txtLongitude.getText()), true);
                btnSave.setDisable(true);
                btnSave.setVisible(false);
                disableFields();
            }else{
                String error = "Por favor llene todos los campos";
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error en los campos");
                alert.setContentText(error);
                alert.showAndWait();
            }
        });
        
        tblList.setOnMouseClicked(evt ->{
            int index = tblList.getSelectionModel().getSelectedIndex();
            Branch selectedBranch = tblList.getItems().get(index);       
            
            txtAddress.setText(selectedBranch.getBranchAddress());
            txtLatitude.setText(String.valueOf(selectedBranch.getLatitude()));
            txtLongitude.setText(String.valueOf(selectedBranch.getLongitude()));
            txtName.setText(selectedBranch.getBranchName());            
            int status = 0;
            if(!selectedBranch.isBranchStatus())
                status = 1;
            cmbStatus.getSelectionModel().select(status);
            
        
        });
        
        
    }
    
    private void fillComboBoxes(){
        cmbStatus.getItems().addAll("Activo","Inactivo");    
    }
    
    private void fillTableView(){       
        
        TableColumn<Integer,Branch> branchIdColumn = new TableColumn<>("Clave"); 
        TableColumn<String,Branch> branchNameColumn = new TableColumn<>("Nombre"); 
        TableColumn<String,Branch> branchAddressColumn = new TableColumn<>("Dirección"); 
        TableColumn<Double,Branch> latitudeColumn = new TableColumn<>("Latitud"); 
        TableColumn<Double,Branch> longitudeColumn = new TableColumn<>("Longitud"); 
        TableColumn<String,Branch> branchStatusColumn = new TableColumn<>("Estatus"); 
        
        branchIdColumn.setCellValueFactory(new PropertyValueFactory<>("branchId"));
        branchNameColumn.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        branchAddressColumn.setCellValueFactory(new PropertyValueFactory<>("branchAddress"));
        latitudeColumn.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        longitudeColumn.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        branchStatusColumn.setCellValueFactory(new PropertyValueFactory<>("latitude"));

        tblList.setPlaceholder(new Label("No hay sucursales que mostrar"));
        
        ArrayList<Branch> branchList = branchCtrl.branchList();  
        
        if(branchList!=null){
            for (Iterator<Branch> it = branchList.iterator(); it.hasNext();) {
                Branch branch = it.next();
                tblList.getItems().add(branch);
            }                                
        }

    }
    
    private void enableFields(){        
        txtAddress.setDisable(false);
        txtLatitude.setDisable(false);
        txtLongitude.setDisable(false);
        txtName.setDisable(false);
        cmbStatus.setDisable(false);
    }
    
    private void disableFields(){        
        txtAddress.setDisable(true);
        txtLatitude.setDisable(true);
        txtLongitude.setDisable(true);
        txtName.setDisable(true);
        cmbStatus.setDisable(true);
    }
    private void cleanFields(){        
        txtAddress.setText("");
        txtLatitude.setText("");
        txtLongitude.setText("");
        txtName.setText("");
        cmbStatus.getSelectionModel().clearSelection();
    }
    
    private boolean checkFields(){
        if(txtAddress.getText().equals(""))
            if(txtName.getText().equals(""))
                if(!txtLatitude.getText().equals(""))
                    if(!txtLongitude.getText().equals(""))
                        if(cmbStatus.getSelectionModel().getSelectedIndex()>0)
                            return true;               
        return false;
    }    
    
}
