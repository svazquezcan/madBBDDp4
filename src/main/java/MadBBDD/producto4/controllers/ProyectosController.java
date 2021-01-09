/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sandra
 */
public class ProyectosController implements Initializable {

    @FXML
    public Button buttonAñadir; 
    @FXML
    public Button buttonEliminar; 
    @FXML
    public Button buttonEditar; 
    @FXML
    public Button buttonVerTodo;
    @FXML
    public Button atras;
    
    @FXML
    public void handleAtras(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) atras.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/LogIn.fxml"));
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
    
     @FXML
    public void handleVerTodo(ActionEvent event1) throws Exception {
        Stage stage2 = (Stage) buttonVerTodo.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodosLosProyectos.fxml"));
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
