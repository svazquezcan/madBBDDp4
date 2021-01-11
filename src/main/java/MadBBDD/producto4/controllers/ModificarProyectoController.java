/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.controllers;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.Proyecto;
import MadBBDD.producto4.SQL.SQLProyectoDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sandra
 */
public class ModificarProyectoController implements Initializable {

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
    @FXML
    public Label lbl_codigoDeProyectoDato;
    private Proyecto proyecto;

    
    public void handleGuardar(ActionEvent event) throws Exception {
        try {
            String cifOng = "A12345678";
            String pais = this.txt_pais.getText();
            String localizacion = this.txt_localizacion.getText();
            String lineaDeAccion = this.txt_lineaDeAccion.getText();
            String sublineaDeAccion = this.txt_sublineaDeAccion.getText();
            String financiador = this.txt_financiador.getText();
            String financiacion = this.txt_financiacionAportada.getText(); 
            Float financiacionAportada = Float.parseFloat(financiacion);
            String accionesARealizar = this.txt_accionesARealizar.getText();
            String socioLocal = this.txt_socioLocal.getText();
            String coste = this.txt_costeProyecto.getText();
            Float costeProyecto = Float.parseFloat(coste);
            String fechaInicio = this.fechaDeInicio.getEditor().getText();
            String dayI = fechaInicio.substring(0,2);
            String monthI = fechaInicio.substring(3,5);
            String yearI = fechaInicio.substring(6,10);
            String fechaInicial = yearI + "-" + monthI + "-" + dayI;
            String fechaFinalizacion = this.fechaDeFinalizacion.getEditor().getText();
            String dayF = fechaFinalizacion.substring(0,2);
            String monthF = fechaFinalizacion.substring(3,5);
            String yearF = fechaFinalizacion.substring(6,10);
            String fechaFinal = yearF + "-" + monthF + "-" + dayF;
            boolean isValid = true;
            
            if (pais.isEmpty()|| localizacion.isEmpty() || lineaDeAccion.isEmpty() || sublineaDeAccion.isEmpty() || fechaInicio.isEmpty() || fechaFinalizacion.isEmpty() || financiador.isEmpty() || financiador.isEmpty() || coste.isEmpty() || socioLocal.isEmpty() || accionesARealizar.isEmpty() || financiacion.isEmpty()){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campo vacío");
                alert.setHeaderText("Campo vacío");
                alert.setContentText("No puede haber ningún campo vacío para modificar un nuevo proyecto");
                alert.showAndWait();  
                isValid = false;

            }
            
            if(isValid){
           
                DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
                SQLProyectoDAO SQLProyectoDAO = DAOFactoryImpl.getProyectosDAOSQL();
                int codigoProyecto = this.setProyectos(proyecto);
                SQLProyectoDAO.modificar("pais", pais, codigoProyecto);
                SQLProyectoDAO.modificar("localizacion", localizacion, codigoProyecto);
                SQLProyectoDAO.modificar("lineaDeAccion", lineaDeAccion, codigoProyecto);
                SQLProyectoDAO.modificar("sublineaDeAccion", sublineaDeAccion, codigoProyecto);
                SQLProyectoDAO.modificar("fechaDeInicio", fechaInicial, codigoProyecto);
                SQLProyectoDAO.modificar("fechaDefinalizacion", fechaFinal, codigoProyecto);
                SQLProyectoDAO.modificar("socioLocal", socioLocal, codigoProyecto);
                SQLProyectoDAO.modificar("financiador", financiador, codigoProyecto);
                SQLProyectoDAO.modificar("financiacionAportada", financiacion, codigoProyecto);
                SQLProyectoDAO.modificar("costeProyecto", coste, codigoProyecto);
                SQLProyectoDAO.modificar("accionesARealizar", accionesARealizar, codigoProyecto);
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Proyecto guardado");
                alert.setHeaderText("Proyecto guardado");
                alert.setContentText("El nuevo proyecto ha sido modificado y guardado correctamente");
                alert.showAndWait();
                
            }

            Stage stage1 = (Stage) buttonGuardar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/VerTodosLosProyectos.fxml"));
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
    
    public int setProyectos (Proyecto proyecto) {
        
        this.proyecto = proyecto;
        
        try {
            lbl_codigoDeProyectoDato.setText(Integer.toString(proyecto.getCodigoDeProyecto()));
            txt_pais.setText(proyecto.getPais());
            txt_localizacion.setText(proyecto.getLocalizacion());
            txt_lineaDeAccion.setText(proyecto.getLineaDeAccion());
            txt_sublineaDeAccion.setText(proyecto.getSublineaDeAccion());
            LocalDate fechaIni  = proyecto.getFechaDeInicio();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaInicio = formatter.format(fechaIni);
            fechaDeInicio.getEditor().setText(fechaInicio);
            LocalDate fechaFin = proyecto.getFechaDeFinalizacion();
            String fechaFinalizacion = formatter.format(fechaFin);
            fechaDeFinalizacion.getEditor().setText(fechaFinalizacion);
            txt_socioLocal.setText(proyecto.getSocioLocal());
            txt_costeProyecto.setText(Float.toString(proyecto.getCosteProyecto()));
            txt_accionesARealizar.setText(proyecto.getAccionesARealizar());
            txt_financiador.setText(proyecto.getFinanciador());
            txt_financiacionAportada.setText(Float.toString(proyecto.getFinanciacionAportada()));
            
       } 
       catch (Exception exception) {
            System.out.println(exception);
       }
       
       int codigoDeProyecto = proyecto.getCodigoDeProyecto();
       return codigoDeProyecto;
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
