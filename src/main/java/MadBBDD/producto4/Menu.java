/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sandra
 */
public class Menu {
    
    /**
     *
     * @return opcionLeida
     */
    public static int OpcionMenu(){
            
    int opcionLeida = 0;

    Scanner leerOpcion = new Scanner (System.in);
    System.out.print("Introduce el numero indicado para realizar una de las siguientes opciones:\n " +
    "Numero 1. Introducir nuevo miembro del personal de la ONG.\n " +
    "Numero 2. Introducir nueva delegación.\n " +  
    "Numero 3. Introducir nuevo proyecto.\n " +
     /*Opciones producto 2: persistencia XML*/
    "Numero 4. XML de la clase ONG.\n " +
    "Numero 5. XML de la clase Delegación.\n " +
    "Numero 6. XML de la clase Proyecto.\n " +
    "Numero 7. XML de la clase Personal.\n" +
    "Número 8. XML de la clase Voluntario.\n" +
    "Número 9. XML de la clase VoluntarioInternacional.\n" +
    "Numero 10. XML de la clase Contratado.\n" +
     /*Opciones producto 3: persistencia BBDD*/
    "Numero 11. Guardar el personal y sus subclases que se introduce por consola en BBDD.\n" +
    "Numero 12. Volcar los datos del XML de Personal y sus subclases en la BBDD.\n" +
    "Numero 13. Eliminar personal y sus subclases de la BBDD.\n" + /*no hay método para las subclases ya que por integridad referencial (cascade) se borran las clases hijas al borrarse el padre*/
    "Numero 14. Obtener todo el personal y sus subclases de la BBDD.\n" +
    "Numero 15. Modificar personal y subclase contratado en la BBDD.\n" + /*El resto de las subclases no se pueden modificar porque solo se componen de PK y FK y se modifican al modificarse la clase padre*/
    "Numero 16. Guardar las delegaciones que se introduzcan por consola en la BBDD\n" +
    "Numero 17. Volcar los datos del XML de Delegacion en la BBDD.\n" +
    "Numero 18. Eliminar delegaciones de la BBDD.\n" +
    "Numero 19. Modificar delegaciones en la BBDD.\n" +
    "Numero 20. Obtener todas las delegaciones de la BBDD.\n" +
    "Numero 21. Guardar los proyectos que se introduzcan por consola en la BBDD.\n" +
    "Numero 22. Volcar los datos del XML de Proyectos de la BBDD.\n" +
    "Numero 23. Eliminar proyectos de la BBDD.\n" +
    "Numero 24. Modificar proyectos de la BBDD.\n" +
    "Numero 25. Obtener todos los proyectos de la BBDD.\n");

    try {
        
        opcionLeida = leerOpcion.nextInt();
        leerOpcion.nextLine();  //elimina salto de línea 
        
    }
    
    catch (InputMismatchException e){
        
        System.out.print("No has introducido una de las opciones indicadas. Vuelve a intentarlo\n");
        
    }
     
    
    return (opcionLeida);
    
    }
    
}
