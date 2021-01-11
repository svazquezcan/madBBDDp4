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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Raúl Gómez
 */
public class VerTodasDelegacionesController implements Initializable {
    @FXML
    public TableView<Delegacion> verTodasDelegaciones;
    @FXML
    public TableColumn idDelegacion;
    @FXML
    public TableColumn direccion;
    @FXML
    public TableColumn nombre;
    @FXML
    public TableColumn telefono;
    @FXML
    public TableColumn cifOng;
    
    @FXML
    public Button atras;
    @FXML
    public Button modificarDelegacion;
    @FXML
    public Button buttonSalir;
    
    @FXML
    public void handleModificar (ActionEvent event1) throws Exception {
        Delegacion delegacion = verTodasDelegaciones.getSelectionModel().getSelectedItem();
        if (delegacion != null) {
            Stage stage2 = (Stage) modificarDelegacion.getScene().getWindow();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/ModificarDelegaciones.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ModificarDelegacionesController modificarDelegacionesController = fxmlLoader.getController();
                modificarDelegacionesController.setDelegacionesMI(verTodasDelegaciones.getSelectionModel().getSelectedItem());
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage2.close();
                stage.show();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }   
            
            } 
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No se ha seleccionado Delegación");
                alert.setHeaderText("No se ha seleccionado ninguna delegación para modificar");
                alert.setContentText("Por favor, selecciona una delegación.");
                alert.showAndWait();
            }

    }
    
   @FXML
    public void handleAtras(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) atras.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Delegaciones.fxml"));
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
    public void handleSalir(ActionEvent event) {
        Stage stage3 = (Stage) buttonSalir.getScene().getWindow();
        stage3.close();
    }
    
    /**
     * Initializes the controller class.
     */
         @FXML
         
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
            Delegaciones delegacion = new Delegaciones();
            Delegaciones listaDelegaciones = new Delegaciones();
            SQLDelegacionDAO totalSQLDelegacionesDAO = DAOFactoryImpl.getDelegacionesDAOSQL();
            listaDelegaciones = totalSQLDelegacionesDAO.obtenerTodos(delegacion);
            ObservableList<Delegacion> infoDelegaciones = FXCollections.observableArrayList(listaDelegaciones.getDelegaciones());
            idDelegacion.setCellValueFactory(new PropertyValueFactory<>("idDelegacion"));
            direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            cifOng.setCellValueFactory(new PropertyValueFactory<>("cifOng"));
            verTodasDelegaciones.setItems(infoDelegaciones);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        // TODO
    }    
    
}
