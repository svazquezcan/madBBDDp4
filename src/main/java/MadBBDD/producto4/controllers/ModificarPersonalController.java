/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.Menu;
import MadBBDD.producto4.Personal;
import MadBBDD.producto4.SQL.SQLPersonalDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sandra
 */
public class ModificarPersonalController implements Initializable {
    @FXML
    public Button buttonGuardar;
    @FXML
    public Button buttonAtras;
    @FXML
    public Button buttonSalir;
    @FXML
    public Button modificarPersonal;
    @FXML
    public TextField txt_tipoDePersonal;
    @FXML
    public Label lbl_codigoDePersonalDato;
    @FXML
    public TextField txt_nombre;
    @FXML
    public TextField txt_apellido;
    @FXML
    public TextField txt_usuario;
    @FXML
    public TextField txt_password;
    @FXML
    public TextField txt_delegacion;
    private Personal personal;
    
    public void handleGuardar(ActionEvent event) throws Exception {
        try {
            String tipoDePersonal = this.txt_tipoDePersonal.getText();
            String nombre = this.txt_nombre.getText();
            String apellido = this.txt_apellido.getText();
            String usuario = this.txt_usuario.getText();
            String password = this.txt_password.getText();
            String delegacion = this.txt_delegacion.getText();
            boolean isValid = true;
            
               if (tipoDePersonal.isEmpty()|| nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || password.isEmpty() || delegacion.isEmpty()){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campo vacío");
                alert.setHeaderText("Campo vacío");
                alert.setContentText("No puede haber ningún campo vacío para modificar un nuevo personal");
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
            
            if(isValid){
           
                DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
                SQLPersonalDAO SQLPersonalDAO = DAOFactoryImpl.getPersonalDAOSQL();
                int codigoPersonal = this.setPersonal(personal);
                SQLPersonalDAO.modificar("tipoDePersonal", tipoDePersonal, codigoPersonal);
                SQLPersonalDAO.modificar("nombre", nombre, codigoPersonal);
                SQLPersonalDAO.modificar("apellido", apellido, codigoPersonal);
                SQLPersonalDAO.modificar("usuario", usuario, codigoPersonal);
                SQLPersonalDAO.modificar("contraseña", password, codigoPersonal);
                SQLPersonalDAO.modificar("idDelegacion", delegacion, codigoPersonal);
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Personal guardado");
                alert.setHeaderText("Personal guardado");
                alert.setContentText("El nuevo personal ha sido modificado y guardado correctamente");
                alert.showAndWait();
           
            }
            
            Stage stage1 = (Stage) buttonGuardar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodoPersonal.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage1.close();
            stage.show();

            }
        catch (Exception e){
            e.printStackTrace();
        }  
    }
    
    public int setPersonal(Personal personal) {
        this.personal = personal;
        
        try {
            lbl_codigoDePersonalDato.setText(Integer.toString(personal.getCodigoDePersonal()));
            txt_tipoDePersonal.setText(personal.getTipoDePersonal());
            txt_nombre.setText(personal.getNombre());
            txt_apellido.setText(personal.getApellido());
            txt_usuario.setText(personal.getUsuario());
            txt_password.setText(personal.getPassword());
            txt_delegacion.setText(personal.getDelegacion());
       } 
       catch (Exception exception) {
            System.out.println(exception);
       }
       
       int codigoDePersonal = personal.getCodigoDePersonal();
       return codigoDePersonal;
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
