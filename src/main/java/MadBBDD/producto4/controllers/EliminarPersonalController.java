/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.SQL.SQLPersonalDAO;
import java.net.URL;
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
public class EliminarPersonalController implements Initializable {

    @FXML
    public Button buttonEliminar;
    @FXML
    public Button buttonAtras;
    @FXML
    public Button buttonSalir;
    @FXML
    public TextField txt_codigoDePersonal;
    
    @FXML
    public void handleEliminar(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) buttonEliminar.getScene().getWindow();
        try {
            String codigoDePersonal = this.txt_codigoDePersonal.getText();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodoPersonal.fxml"));
            int codigo = Integer.parseInt(codigoDePersonal);
            DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
            SQLPersonalDAO totalSQLPersonalDAO = DAOFactoryImpl.getPersonalDAOSQL();
            int respuestaQuery = 0;
            respuestaQuery = totalSQLPersonalDAO.checkCodigoDePersonal(codigo);
            
            if (respuestaQuery!=-1){
                totalSQLPersonalDAO.eliminar(codigo);
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Personal eliminado");
                alert.setHeaderText("Personal eliminado");
                alert.setContentText("El personal indicado ha sido eliminado correctamente");
                alert.showAndWait();
                
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage1.close();
                stage.show();
            }
            
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("CodigoDePersonal incorrecto");
                alert.setHeaderText("CodigoDePersonal incorrecto");
                alert.setContentText("El CodigoDePersonal no existe en la base de datos");
                alert.showAndWait();   
            }

        }
        
       catch (Exception e) {
            e.printStackTrace();
        }   
            
    }
    
    
    @FXML
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
