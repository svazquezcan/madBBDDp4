package MadBBDD.producto4;

import MadBBDD.producto4.DAO.DAOFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class EntreculturasApp extends Application{
    
   public static void main(final String[] args) throws SQLException {
        MadBBDD.producto4.SQL.SQLPersonalDAO personalDAO = new MadBBDD.producto4.SQL.SQLPersonalDAO();
        int num = personalDAO.lastCodigoDePersonal();
        Personal.inicializarAutoincrement(num+1);
        
        MadBBDD.producto4.SQL.SQLDelegacionDAO delegacionDAO = new MadBBDD.producto4.SQL.SQLDelegacionDAO();
        int id = delegacionDAO.lastIdDelegacion(); 
        Delegacion.inicializarAutoincrement(id+1);
        
        MadBBDD.producto4.SQL.SQLProyectoDAO proyectoDAO = new MadBBDD.producto4.SQL.SQLProyectoDAO();
        int codigo = proyectoDAO.lastidProyecto();
        Proyecto.inicializarAutoincrement(codigo+1);
        
        ONG miONG = new ONG("Calle Palomas", "66666666");
        
        ArrayList<Personal> totalPersonal = miONG.getListaPersonal();
        ArrayList<Proyecto> totalProyectos = miONG.getProyectos();
        ArrayList<Delegacion> totalDelegaciones = miONG.getDelegaciones();
        ArrayList<Voluntario> totalVoluntarios = miONG.getListaVoluntarios();
        ArrayList<VoluntarioInternacional> totalVoluntariosInternacionales = miONG.getListaVoluntariosInternacionales();
        ArrayList<Contratado> totalContratados = miONG.getListaContratados();
        
        PersonalList miPersonalList = new PersonalList(); //creo objeto que pasaremos al marshaller
        miPersonalList.setPersonal(totalPersonal); //relleno objeto con la info de miONG
        Proyectos listadoProyectos = new Proyectos(); //creo objeto que pasaremos al marshaller
        listadoProyectos.setProyectos(totalProyectos); //relleno objeto con la info de miONG
        Delegaciones listadoDelegaciones = new Delegaciones(); //creo objeto que pasaremos al marshaller
        listadoDelegaciones.setDelegaciones(totalDelegaciones);//relleno objeto con la info de miONG
        ArrayList<Voluntario> voluntarios = miONG.getListaVoluntarios(); //relleno arraylist con la info de miONG
        Voluntarios listadoVoluntarios = new Voluntarios(); //creo objeto que pasaremos al marshaller
        listadoVoluntarios.setVoluntarios(voluntarios); //relleno objeto con la info de miONG
        ArrayList<VoluntarioInternacional> voluntariosInternacionales = miONG.getListaVoluntariosInternacionales(); //relleno arraylist con la info de miONG
        VoluntariosInternacionales listadoVoluntariosInternacionales = new VoluntariosInternacionales(); //creo objeto que pasaremos al marshaller
        listadoVoluntariosInternacionales.setVoluntarios(voluntariosInternacionales); //relleno objeto con la info de miONG
        ArrayList<Contratado> contratados = miONG.getListaContratados();//relleno arraylist con la info de miONG
        Contratados listadoContratados = new Contratados(); //creo objeto que pasaremos al marshaller
        listadoContratados.setContratados(contratados);//relleno objeto con la info de miONG
        ArrayList<ONG> misONGs = new ArrayList<>(); 
        misONGs.add(miONG);
        ONGs ONGs = new ONGs(); 
        ONGs.setONGs(misONGs);
        
        launch(args);
    }
	

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            //Cargo la vista
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EntreculturasApp.class.getResource("/Views/LogIn.fxml"));
             
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();
             
            // Cargo el scene
            Scene scene = new Scene(ventana);
             
            // Seteo la scene y la muestro
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
