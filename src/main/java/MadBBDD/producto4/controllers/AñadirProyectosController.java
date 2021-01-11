/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.Personal;
import MadBBDD.producto4.PersonalList;
import MadBBDD.producto4.Proyecto;
import MadBBDD.producto4.Proyectos;
import MadBBDD.producto4.SQL.SQLPersonalDAO;
import MadBBDD.producto4.SQL.SQLProyectoDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sandra
 */
public class AñadirProyectosController implements Initializable {
    @FXML
    public Button buttonGuardar;
    @FXML
    public Button buttonAtras;
    @FXML
    public Button buttonSalir;
    @FXML
    public TextField txt_pais;
    @FXML
    public TextField txt_localizacion;
    @FXML
    public TextField txt_lineaDeAccion;
    @FXML
    public TextField txt_sublineaDeAccion;
    @FXML
    public TextField txt_socioLocal;
    @FXML
    public TextField txt_financiador;
    @FXML
    public TextField txt_financiacionAportada;
    @FXML
    public TextField txt_costeProyecto; 
    @FXML
    public TextField txt_accionesARealizar;
    @FXML
    public DatePicker fechaDeInicio;
    @FXML
    public DatePicker fechaDeFinalizacion;
    
    public void handleGuardar(ActionEvent event) throws Exception {
        Stage stage1 = (Stage) buttonGuardar.getScene().getWindow();
        try {  
            String cifOng = "A12345678";
            String pais = this.txt_pais.getText();
            String localizacion = this.txt_localizacion.getText();
            String lineaDeAccion = this.txt_lineaDeAccion.getText();
            String sublineaDeAccion = this.txt_sublineaDeAccion.getText();
            String financiador = this.txt_financiador.getText();
            String financiacionAportada = this.txt_financiacionAportada.getText(); 
            Float financiacion = Float.parseFloat(financiacionAportada);
            String socioLocal = this.txt_socioLocal.getText();
            String costeProyecto = this.txt_costeProyecto.getText();
            Float coste = Float.parseFloat(costeProyecto);
            String accionesARealizar = this.txt_accionesARealizar.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaInicio = this.fechaDeInicio.getEditor().getText();
            LocalDate fechaIni  = LocalDate.parse(fechaInicio, formatter);
            String fechaFinalizacion = this.fechaDeFinalizacion.getEditor().getText();
            LocalDate fechaFin = LocalDate.parse(fechaFinalizacion, formatter);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodosLosProyectos.fxml"));
            boolean isValid = true;
            
            if (pais.isEmpty()|| localizacion.isEmpty() || lineaDeAccion.isEmpty() || sublineaDeAccion.isEmpty() || fechaInicio.isEmpty() || fechaFinalizacion.isEmpty() || financiador.isEmpty() || financiador.isEmpty() || coste == 0|| socioLocal.isEmpty() || accionesARealizar.isEmpty() || financiacion == 0){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campo vacío");
                alert.setHeaderText("Campo vacío");
                alert.setContentText("No puede haber ningún campo vacío para crear un nuevo proyecto");
                alert.showAndWait();  
                isValid = false;

            }
           
            
            if (isValid){
            
                Proyecto nuevoProyecto = new Proyecto(pais, localizacion, lineaDeAccion, sublineaDeAccion, fechaIni, fechaFin, socioLocal, financiador, financiacion, coste, accionesARealizar, cifOng);
                Proyectos listaProyectos = new Proyectos();
                ArrayList <Proyecto> proyectos = new ArrayList<>();
                proyectos.add(nuevoProyecto);
                listaProyectos.setProyectos(proyectos);
                DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
                SQLProyectoDAO SQLProyectoDAO = DAOFactoryImpl.getProyectosDAOSQL();
                SQLProyectoDAO.insertar(listaProyectos);
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Proyecto guardado");
                alert.setHeaderText("Proyecto guardado");
                alert.setContentText("El nuevo proyecto ha sido guardado correctamente");
                alert.showAndWait();
            
            }
                       
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage1.close();
            stage.show();
        } 
        catch (IOException | NumberFormatException | SQLException e) {
            e.printStackTrace();   
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campo vacío o incorrecto");
            alert.setHeaderText("Campo vacío o incorrecto");
            alert.setContentText("No puede haber ningún campo vacío para crear un nuevo proyecto o los campos financiacion y costeProyecto no son números");
            alert.showAndWait();  
        }        
    }
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
