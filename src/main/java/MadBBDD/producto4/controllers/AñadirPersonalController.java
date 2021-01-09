/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.Personal;
import MadBBDD.producto4.PersonalList;
import MadBBDD.producto4.SQL.SQLPersonalDAO;
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

/**
 * FXML Controller class
 *
 * @author Sandra
 */
public class AñadirPersonalController implements Initializable {

    @FXML
    public Button buttonGuardar;
    @FXML
    public Button buttonAtras;
    @FXML
    public Button buttonSalir;
    @FXML
    public TextField txt_tipoDePersonal;
    @FXML
    public TextField txt_nombre;
    @FXML
    public TextField txt_apellidos;
    @FXML
    public TextField txt_usuario;
    @FXML
    public TextField txt_password;
    @FXML
    public TextField txt_delegacion;
   
    @FXML
    public void handleGuardar(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) buttonGuardar.getScene().getWindow();
        try {  
            String tipoDePersonal = this.txt_tipoDePersonal.getText();
            String nombre = this.txt_nombre.getText();
            String apellidos = this.txt_apellidos.getText();
            String usuario = this.txt_usuario.getText();
            String password = this.txt_password.getText();
            String delegacion = this.txt_delegacion.getText();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodoPersonal.fxml"));
            boolean isValid = true;
            
            if (tipoDePersonal.isEmpty()|| nombre.isEmpty() || apellidos.isEmpty() || usuario.isEmpty() || password.isEmpty() || delegacion.isEmpty()){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campo vacío");
                alert.setHeaderText("Campo vacío");
                alert.setContentText("No puede haber ningún campo vacío para crear un nuevo personal");
                alert.showAndWait();  
                isValid = false;

            }
            
            if (!"Entreculturas Francia".equals(delegacion) && !"Entreculturas Polonia".equals(delegacion) && !"Entreculturas Portugal".equals(delegacion) && !"".equals(delegacion)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campo incorrecto");
                alert.setHeaderText("Campo incorrecto");
                alert.setContentText("El campo delegacion solo puede ser: Entreculturas Francia, Entreculturas Polonia o Entreculturas Portugal");
                alert.showAndWait();    
                isValid = false;

                
            }
            
            if (!"Voluntario".equals(tipoDePersonal) && !"VoluntarioInternacional".equals(tipoDePersonal) && !"Contratado".equals(tipoDePersonal) && !"".equals(tipoDePersonal)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campo incorrecto");
                alert.setHeaderText("Campo incorrecto");
                alert.setContentText("El campo tipoDePersonal solo puede ser: Voluntario, VoluntarioInternacional o Contratado");
                alert.showAndWait();   
                isValid = false;
                
            }
            
            if (isValid){
            
                Personal nuevoPersonal = new Personal(tipoDePersonal, nombre, apellidos, usuario, password, delegacion);
                PersonalList personalList = new PersonalList();
                ArrayList <Personal> personal = new ArrayList<>();
                personal.add(nuevoPersonal);
                personalList.setPersonal(personal);
                DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
                SQLPersonalDAO SQLPersonalDAO = DAOFactoryImpl.getPersonalDAOSQL();
                SQLPersonalDAO.insertar(personalList);
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Personal guardado");
                alert.setHeaderText("Personal guardado");
                alert.setContentText("El nuevo personal ha sido guardado correctamente");
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
        }        
    }
    
      public void handleAtras(ActionEvent event1) throws Exception {
        Stage stage2 = (Stage) buttonAtras.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Personal.fxml"));
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
