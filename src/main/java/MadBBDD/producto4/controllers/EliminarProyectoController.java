/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.SQL.SQLPersonalDAO;
import MadBBDD.producto4.SQL.SQLProyectoDAO;
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
public class EliminarProyectoController implements Initializable {

    @FXML
    public Button buttonEliminar;
    @FXML
    public Button buttonAtras;
    @FXML
    public Button buttonSalir;
    @FXML
    public TextField txt_codigoDeProyecto;
    
      @FXML
    public void handleEliminar(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) buttonEliminar.getScene().getWindow();
        try {
            String codigoDeProyecto = this.txt_codigoDeProyecto.getText();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodosLosProyectos.fxml"));
            int codigo = Integer.parseInt(codigoDeProyecto);
            DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
            SQLProyectoDAO totalSQLProyectosDAO = DAOFactoryImpl.getProyectosDAOSQL();
            int respuestaQuery = 0;
            respuestaQuery = totalSQLProyectosDAO.checkCodigoDeProyecto(codigo);
            
            if (respuestaQuery!=-1){
                totalSQLProyectosDAO.eliminar(codigo);
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Proyecto eliminado");
                alert.setHeaderText("Proyecto eliminado");
                alert.setContentText("El proyecto indicado ha sido eliminado correctamente");
                alert.showAndWait();
                
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage1.close();
                stage.show();
            }
            
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("CodigoDeProyecto incorrecto");
                alert.setHeaderText("CodigoDeProyecto incorrecto");
                alert.setContentText("El CodigoDeProyecto no existe en la base de datos");
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
    public void handleSalir(ActionEvent event) {
        Stage stage3 = (Stage) buttonSalir.getScene().getWindow();
        stage3.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
