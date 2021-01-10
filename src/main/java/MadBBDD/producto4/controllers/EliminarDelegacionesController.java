/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.SQL.SQLDelegacionDAO;
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
 * @author Raúl Gómez
 */
public class EliminarDelegacionesController implements Initializable {

    @FXML
    public Button buttonEliminar;
    @FXML
    public Button buttonAtras;
    @FXML
    public Button buttonSalir;
    
    @FXML
    public TextField txt_idDelegacion;
    
    
    public void handleEliminar(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) buttonEliminar.getScene().getWindow();
        try{
            String idDelegacion = this.txt_idDelegacion.getText();
            int codigo  = Integer.parseInt(idDelegacion);
            int respuestaQuery = 0;
                    
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodasDelegaciones.fxml"));
            DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
            SQLDelegacionDAO totalSQLDelegacionesDAO = DAOFactoryImpl.getDelegacionesDAOSQL();
            respuestaQuery = totalSQLDelegacionesDAO.checkidDelegacion(codigo);
            
            if (respuestaQuery != -1 || respuestaQuery != 0){
                totalSQLDelegacionesDAO.eliminar(codigo);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Eliminación de delegación");
                alert.setHeaderText("Delegación eliminada");
                alert.setContentText("La Delegación indicada ha sido eliminada correctamente");
                alert.showAndWait();
                
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage1.close();
                stage.show();
                
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No se ha podido eleminar la delegación");
                alert.setHeaderText("Id de delegación incorrecto");
                alert.setContentText("La ID especificada, no existe, por favor vuelva a repetirlo e indique la correcta.");
                alert.showAndWait(); 
            } 
        }
        
        catch (Exception e){
            e.printStackTrace();
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
