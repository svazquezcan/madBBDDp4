package MadBBDD.producto4.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.Personal;
import MadBBDD.producto4.PersonalList;
import MadBBDD.producto4.Proyecto;
import MadBBDD.producto4.Proyectos;
import MadBBDD.producto4.SQL.SQLPersonalDAO;
import MadBBDD.producto4.SQL.SQLProyectoDAO;
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
 * @author Sandra
 */
public class VerTodosLosProyectosController implements Initializable {

    
    @FXML
    public TableView<Proyecto> verTodosLosProyectos;
    @FXML
    public TableColumn codigoDeProyecto;
    @FXML
    public TableColumn pais;
    @FXML
    public TableColumn localizacion;
    @FXML
    public TableColumn lineaDeAccion;
    @FXML
    public TableColumn sublineaDeAccion;
    @FXML
    public TableColumn fechaDeInicio;
    @FXML
    public TableColumn fechaDeFinalizacion;  
    @FXML
    public TableColumn socioLocal;  
    @FXML
    public TableColumn financiador;  
    @FXML
    public TableColumn financiacionAportada;  
    @FXML
    public TableColumn costeProyecto;  
    @FXML
    public TableColumn accionesARealizar;  
    @FXML
    public Button atras;
    @FXML
    public Button modificarProyecto;
    @FXML
    public Button buttonSalir;
    
    
   @FXML
    public void handleAtras(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) atras.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Proyectos.fxml"));
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
    public void handleModificar (ActionEvent event1) throws Exception {
        Proyecto proyecto = verTodosLosProyectos.getSelectionModel().getSelectedItem();
        if (proyecto != null) {
            Stage stage2 = (Stage) modificarProyecto.getScene().getWindow();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/ModificarProyecto.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ModificarProyectoController modificarProyectoController = fxmlLoader.getController();
                modificarProyectoController.setProyectos(verTodosLosProyectos.getSelectionModel().getSelectedItem());
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
                alert.setTitle("No se ha seleccionado proyecto");
                alert.setHeaderText("No se ha seleccionado proyecto");
                alert.setContentText("Por favor, selecciona un proyecto.");
                alert.showAndWait();
            }

    }
    
    @FXML
    public void handleSalir(ActionEvent event) {
        Stage stage3 = (Stage) buttonSalir.getScene().getWindow();
        stage3.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
            Proyectos proyectos = new Proyectos();
            Proyectos listaDeProyectos = new Proyectos(); 
            SQLProyectoDAO SQLproyectoDAO = DAOFactoryImpl.getProyectosDAOSQL();
            listaDeProyectos = SQLproyectoDAO.obtenerTodos(proyectos);
            ObservableList<Proyecto> infoProyectos = FXCollections.observableArrayList(listaDeProyectos.getProyectos());
            codigoDeProyecto.setCellValueFactory(new PropertyValueFactory<>("codigoDeProyecto"));
            pais.setCellValueFactory(new PropertyValueFactory<>("pais"));
            localizacion.setCellValueFactory(new PropertyValueFactory<>("localizacion"));
            lineaDeAccion.setCellValueFactory(new PropertyValueFactory<>("lineaDeAccion"));
            sublineaDeAccion.setCellValueFactory(new PropertyValueFactory<>("sublineaDeAccion"));
            fechaDeInicio.setCellValueFactory(new PropertyValueFactory<>("fechaDeInicio"));
            fechaDeFinalizacion.setCellValueFactory(new PropertyValueFactory<>("fechaDeFinalizacion"));
            socioLocal.setCellValueFactory(new PropertyValueFactory<>("socioLocal"));
            financiador.setCellValueFactory(new PropertyValueFactory<>("financiador"));
            financiacionAportada.setCellValueFactory(new PropertyValueFactory<>("financiacionAportada"));
            costeProyecto.setCellValueFactory(new PropertyValueFactory<>("costeProyecto"));
            accionesARealizar.setCellValueFactory(new PropertyValueFactory<>("accionesARealizar"));
            verTodosLosProyectos.setItems(infoProyectos);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
