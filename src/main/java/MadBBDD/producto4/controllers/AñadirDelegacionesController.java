/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.Delegacion;
import MadBBDD.producto4.Delegaciones;
import MadBBDD.producto4.SQL.SQLDelegacionDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.bytebuddy.asm.Advice.This;

/**
 * FXML Controller class
 *
 * @author Raúl Gómez
 */
public class AñadirDelegacionesController implements Initializable {
    
    @FXML
    public Button buttonGuardar;
    @FXML
    public Button buttonAtras;
    @FXML
    public Button buttonSalir;
    @FXML
    public TextField txt_nombre;
    @FXML
    public TextField txt_direccion;
    @FXML
    public TextField txt_telefono;

    public void handleGuardar(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) buttonGuardar.getScene().getWindow();
        try{
            String cifOng = "A12345678";
            String nombre = this.txt_nombre.getText();
            String direccion = this.txt_direccion.getText();
            String telefono = this.txt_telefono.getText();
            boolean isValid = true;
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodasDelegaciones.fxml"));
            
            if (nombre.isEmpty()|| direccion.isEmpty() || telefono.isEmpty() ){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No se ha podido crear ningúna delegación");
                alert.setHeaderText("Campo vacío");
                alert.setContentText("No puede haber ningún campo vacío para crear una nueva delegación");
                alert.showAndWait();  
                isValid = false;
            }
            
              if (!telefono.matches("[0-9]*") ){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No se ha podido crear ningúna delegación");
                alert.setHeaderText("Campo teléfono incorrecto");
                alert.setContentText("No puede haber letras en el campo teléfono");
                alert.showAndWait();  
                isValid = false;
            }
              
            if (isValid){
            
                Delegacion nuevaDelegacion = new Delegacion(nombre, direccion, telefono, cifOng);
                Delegaciones listaDelegaciones = new Delegaciones();
                ArrayList <Delegacion> delegaciones = new ArrayList<>();
                delegaciones.add(nuevaDelegacion);
                listaDelegaciones.setDelegaciones(delegaciones);
                DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
                SQLDelegacionDAO SQLDelegacionDAO = DAOFactoryImpl.getDelegacionesDAOSQL();
                SQLDelegacionDAO.insertar(listaDelegaciones);
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Creación de la Delegacion");
                alert.setHeaderText("Delegacion creada correctamente");
                alert.setContentText("La nueva delegeación ha sido creada.");
                alert.showAndWait();
            
            }
            
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage1.close();
            stage.show();
        
        }
        
        catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No se ha podido crear ningúna delegación");
            alert.setHeaderText("Campo vacío");
            alert.setContentText("No puede haber ningún campo vacío para crear una nueva delegación");
            alert.showAndWait();  
        }
    }
    @FXML
    public void handleAtras(ActionEvent event1) throws Exception {
        Stage stage2 = (Stage) buttonAtras.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Delegaciones.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage2.close();
            stage.show();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }        
    }
      
    @FXML
    public void handleSalir(ActionEvent event) {
        Stage stage3 = (Stage) buttonSalir.getScene().getWindow();
        stage3.close();
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      
    
}
