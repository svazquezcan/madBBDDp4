package MadBBDD.producto4;

import java.io.IOException;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class EntreculturasApp extends Application{
    
   public static void main(final String[] args) {
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
