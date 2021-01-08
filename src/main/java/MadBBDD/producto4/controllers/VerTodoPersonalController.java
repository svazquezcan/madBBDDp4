/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.ONG;
import MadBBDD.producto4.Personal;
import MadBBDD.producto4.PersonalList;
import MadBBDD.producto4.SQL.SQLPersonalDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sandra
 */
public class VerTodoPersonalController implements Initializable {
  
    @FXML
    public TableView<Personal> verTodoPersonal;
    @FXML
    public TableColumn codigoDePersonal;
    @FXML
    public TableColumn tipoDePersonal;
    @FXML
    public TableColumn nombre;
    @FXML
    public TableColumn apellidos;
    @FXML
    public TableColumn usuario;
    @FXML
    public TableColumn password;
    @FXML
    public TableColumn delegacion;  
    @FXML
    public Button atras;

   @FXML
    public void handleAtras(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) atras.getScene().getWindow();
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
        DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
        PersonalList personal = new PersonalList();
        PersonalList listaDePersonal = new PersonalList(); 
        SQLPersonalDAO totalSQLPersonalDAO = DAOFactoryImpl.getPersonalDAOSQL();
        listaDePersonal = totalSQLPersonalDAO.obtenerTodos(personal);
        ObservableList<Personal> infoPersonal = FXCollections.observableArrayList(listaDePersonal.getPersonalList());
        codigoDePersonal.setCellValueFactory(new PropertyValueFactory<>("CodigoDePersonal"));
        delegacion.setCellValueFactory(new PropertyValueFactory<>("delegacion"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        tipoDePersonal.setCellValueFactory(new PropertyValueFactory<>("tipoDePersonal"));
        verTodoPersonal.setItems(infoPersonal);
    } 
    catch (Exception e) {
        e.printStackTrace();
    }
    }
 
    
}
