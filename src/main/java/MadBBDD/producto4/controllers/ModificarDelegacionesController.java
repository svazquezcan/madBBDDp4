/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.Delegacion;
import MadBBDD.producto4.Delegaciones;
import MadBBDD.producto4.Proyecto;
import MadBBDD.producto4.SQL.SQLDelegacionDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Raúl Gómez
 */
public class ModificarDelegacionesController implements Initializable {
    @FXML
    public Button buttonGuardar;
    @FXML
    public Button buttonAtras;
    @FXML
    public Button buttonSalir;
    @FXML
    public TextField txt_nombredelegacion;
    @FXML
    public TextField txt_direccion;
    @FXML
    public TextField txt_telefono;
    
    private Delegacion delegacion;
    
    public Label lbl_idDelegacion;
    

    public void handleGuardar(ActionEvent event) throws Exception {
        
        try{
            
            String nombre = this.txt_nombredelegacion.getText();
            String direccion = this.txt_direccion.getText();
            String telefono = this.txt_telefono.getText();
            
            DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
            SQLDelegacionDAO SQLDelegacionDAO = DAOFactoryImpl.getDelegacionesDAOSQL();
            int idDelegacion = this.setDelegacionesMI(delegacion);
            SQLDelegacionDAO.modificar("nombre", nombre, idDelegacion);
            SQLDelegacionDAO.modificar("direccion", direccion, idDelegacion);
            SQLDelegacionDAO.modificar("telefono", telefono, idDelegacion);
           
            Stage stage1 = (Stage) buttonGuardar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodasDelegaciones.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage1.close();
            stage.show();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public int setDelegacionesMI (Delegacion delegacion) {
        
        this.delegacion = delegacion;
        
        try {
            txt_nombredelegacion.setText(delegacion.getNombre());
            txt_direccion.setText(delegacion.getDireccion());
            txt_telefono.setText(delegacion.getTelefono());            
       } 
       catch (Exception exception) {
            System.out.println(exception);
       }
       
       int idDelegacion = delegacion.getIdDelegacion();
       return idDelegacion;
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
