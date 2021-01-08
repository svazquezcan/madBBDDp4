/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Sandra
 */
public class LogInController {
    
    @FXML
    public Button personal; 
    @FXML
    public Button proyectos; 
    @FXML
    public Button delegaciones; 
    
    @FXML
    public void handlePersonal(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) personal.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Personal.fxml"));
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
    public void handleProyectos (ActionEvent event1) throws Exception {
        Stage stage2 = (Stage) proyectos.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Proyectos.fxml"));
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
    public void handleDelegaciones (ActionEvent event2) throws Exception {
        Stage stage3 = (Stage) proyectos.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Delegaciones.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage3.close();
            stage.show();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
    

