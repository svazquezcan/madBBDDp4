/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="ONG")
@XmlAccessorType (XmlAccessType.NONE)
public class ONG {
    @XmlElement (name="CIF")
    private static String CIF; 
    @XmlElement (name="direccion")
    private String direccion; 
    @XmlElement (name="telefono")
    private String telefono; 
    private ArrayList<Delegacion> delegaciones;
    private ArrayList<Proyecto> proyectos;
    private ArrayList<Personal> listaPersonal; 
    private ArrayList<Voluntario> listaVoluntarios;
    private ArrayList<VoluntarioInternacional> listaVoluntariosInternacionales;
    private ArrayList<Contratado> listaContratados;
    
    /**Creo objeto Scanner para poder leer input por teclado*/
    public static Scanner leerDatos = new Scanner(System.in);

    /**Constructor
     * @param CIF
     * @param direccion
     * @param telefono*/
    
    public ONG(String direccion, String telefono){
        this.CIF = "A12345678"; //lo asignamos directamente, ya que solo va a haber un objeto ONG
        this.direccion = direccion; 
        this.telefono = telefono;     
        this.delegaciones = new ArrayList<>(); 
        this.proyectos = new ArrayList<>();
        this.listaPersonal = new ArrayList <>(); 
        this.listaVoluntarios = new ArrayList <>();
        this.listaVoluntariosInternacionales = new ArrayList <>(); 
        this.listaContratados = new ArrayList <>();
        
    }
    
    /*Constructor sin argumentos para JABX*/
    public ONG(){
    }
    
    /*Constructor sin argumentos para JABX*/
    public ONG(String CIF){
    }
    
     /**Getter
     * @return CIF*/
    public static String getCIF(){
        return CIF;
    }
    
     /**Getter
     * @return direccion*/
    public String getDireccion(){
        return this.direccion;
    }
    
     /**Getter
     * @return telefono*/
    public String getTelefono(){
        return this.telefono;
    }
    
     /**Getter
     * @return delegaciones*/
    public ArrayList<Delegacion> getDelegaciones(){
        return this.delegaciones;
    }
    
     /**Getter
     * @return proyectos*/
    public ArrayList<Proyecto> getProyectos(){
        return this.proyectos;
    }
    
     /**Getter
     * @return listaPersonal*/
    public ArrayList<Personal> getListaPersonal(){
        return this.listaPersonal;
    }
    
     /**Getter
     * @return listaVoluntarios*/
    public ArrayList<Voluntario> getListaVoluntarios(){
        return this.listaVoluntarios;
    }
    
     /**Getter
     * @return listaVoluntariosInternacionales*/
    public ArrayList<VoluntarioInternacional> getListaVoluntariosInternacionales(){
        return this.listaVoluntariosInternacionales;
    }
    
     /**Getter
     * @return listaContratados*/
    public ArrayList<Contratado> getListaContratados(){
        return this.listaContratados;
    }
    
     /**Setter
     * @param CIF, para añadir/modificar el CIF de la ONG*/
    public static void setCIF(String CIF){
        ONG.CIF = CIF; 
    }
    
      /**Setter
     * @param direccion, para añadir/modificar la direccion de la ONG*/
    public void setDireccion(String direccion){
        this.direccion = direccion; 
    }
    
      /**Setter
     * @param telefono, para añadir/modificar el telefono de la ONG*/
    public void setTelefono (String telefono){
        this.telefono = telefono; 
    }
    
      /**Setter
     * @param delegaciones, para añadir/modificar lista de delegaciones de la ONG*/
    public void setDelegaciones(ArrayList<Delegacion> delegaciones){
        this.delegaciones = delegaciones; 
    }
    
      /**Setter
     * @param proyectos, para añadir/modificar lista de proyectos de la ONG*/
    public void setProyectos(ArrayList<Proyecto> proyectos){
        this.proyectos = proyectos; 
    }
    
       /**Setter
     * @param listaPersonal, para añadir/modificar lista de personal de la ONG*/
    public void setListaPersonal(ArrayList<Personal> listaPersonal){
        this.listaPersonal = listaPersonal; 
    }
    
    /**Setter
     * @param listaVoluntarios, para añadir/modificar lista de voluntarios de la ONG*/
    public void setListaVoluntarios (ArrayList<Voluntario> listaVoluntarios){
        this.listaVoluntarios = listaVoluntarios; 
    }
    
     /**Setter
     * @param listaVoluntariosInternacionales, para añadir/modificar lista de voluntariosInternacionales de la ONG*/
    public void setListaVoluntariosInternacionales (ArrayList<VoluntarioInternacional> listaVoluntariosInternacionales){
        this.listaVoluntariosInternacionales = listaVoluntariosInternacionales; 
    }
    
     /**Setter
     * @param listaContratados, para añadir/modificar lista de contratados de la ONG*/
    public void setListaContratados (ArrayList<Contratado> listaContratados){
        this.listaContratados = listaContratados; 
    }
 
     /**Funcion para crear un arraylist de proyectos libres
     * @return proyectosLibres (arrayList de proyectos libres*/
    
    public ArrayList<Proyecto> proyectosLibres(){
        
        ArrayList<Proyecto> nuevaListaProyectos = this.getProyectos();
        ArrayList<Proyecto> listaProyectosLibres = new ArrayList<Proyecto>();
        boolean isAssigned = true;
        
        for (int i = 0; i < nuevaListaProyectos.size(); i++){
            
            isAssigned = nuevaListaProyectos.get(i).isAssigned(); /*comprobamos cada objeto proyecto según método isAssigned*/
            
            if (isAssigned){
            }
            
            else {
                 listaProyectosLibres.add(nuevaListaProyectos.get(i)); /*guardamos cada proyecto sin asignar en el arraylist de proyectos libres creado*/
            }
            
        }
        
        return listaProyectosLibres;
        
    }
    
    /**Funcion para la entrada de datos por consola de un nuevo miembro del personal*/
    
    public void entrarDatosPersonal(){
        /**Declaracion variables para guardar datos de personal nuevo*/
        String tipoDePersonalDelNuevo;
        String nuevoNombre; 
        String nuevoApellido; 
        String nuevoUsuario; 
        String nuevaContraseña; 
        String nuevaDelegacion;
        
        try {
        
            /**Solicitud por consola del tipo de personal y lectura por teclado de tipoDePersonalDelNuevo*/
           System.out.print("Introduce el tipo de personal del nuevo miembro del personal: Voluntario, VoluntarioInternacional o Contratado: ");
           tipoDePersonalDelNuevo = leerDatos.nextLine();

           /**Comprobacion para que campo nombre no esté vacío*/
            while (tipoDePersonalDelNuevo.isEmpty()){

               System.out.print("El tipo de personal del nuevo miembro no puede ser un campo vacío. Introduce el tipo de personal del nuevo miembro del personal: ");
               tipoDePersonalDelNuevo = leerDatos.nextLine();

           }              

            /**Comprobacion para que campo tipo de personal esté limitado a los tres tipos posibles y no se pueda introducir cualquier String*/

            while (!"Voluntario".equals(tipoDePersonalDelNuevo) && !"VoluntarioInternacional".equals(tipoDePersonalDelNuevo) && !"Contratado".equals(tipoDePersonalDelNuevo)){ /*comprobacion de campo para que solo se puedan introducir los tipos de habs que existen*/

                System.out.print("El tipo de personal indicado no es correcto. Por favor, vuelve a escribirlo:\n ");
                tipoDePersonalDelNuevo = leerDatos.nextLine(); 

            }

           /**Solicitud por consola del nombre de personal y lectura por teclado del nuevoNombre*/
           System.out.print("Introduce nombre del nuevo miembro del personal: ");
           nuevoNombre = leerDatos.nextLine();

           /**Comprobacion para que campo nombre no esté vacío*/
            while (nuevoNombre.isEmpty()){

               System.out.print("El nombre del nuevo miembro del personal no puede ser un campo vacío. Introduce el nombre del nuevo miembro del personal: ");
               nuevoNombre = leerDatos.nextLine();

           }

            /**Solicitud por consola del apellido de personal y lectura por teclado del nuevoApellido*/
           System.out.print("Introduce apellido del nuevo miembro del personal: ");
           nuevoApellido = leerDatos.nextLine();

           /**Comprobacion para que campo apellido no esté vacío*/
            while (nuevoApellido.isEmpty()){

               System.out.print("El apellido del nuevo miembro del personal no puede ser un campo vacío. Introduce el apellido del nuevo miembro del personal: ");
               nuevoApellido = leerDatos.nextLine();

           }

           /**Solicitud por consola del nuevo usuario de personal y lectura por teclado del nuevoUsuario*/
           System.out.print("Introduce usuario del nuevo miembro del personal: ");
           nuevoUsuario = leerDatos.nextLine();

           /**Comprobacion para que campo usuario no esté vacío*/
            while (nuevoUsuario.isEmpty()){

               System.out.print("El usuario del nuevo miembro del personal no puede ser un campo vacío. Introduce el usuario del nuevo miembro del personal: ");
               nuevoUsuario = leerDatos.nextLine();

           }  

           ArrayList<Personal> nuevaListaPersonal = this.getListaPersonal();/*usamos el getter de la clase ONG para conseguir listado de personal y almacenarlo en variable nuevaListaPersonal*/
           boolean newUser = true;

           for (int i = 0; i < nuevaListaPersonal.size(); i++){ /**hacemos un loop para recorrer los objetos personal del arraylist listado de personal de la ONG*/
              if (nuevaListaPersonal.get(i).getUsuario().equals(nuevoUsuario)){ /**comprobamos que el usuario no exista ya para no guardar un nuevo miembro de personal con el mismo user*/

                  System.out.println("El usuario ya existe. No se puede crear un usuario con el mismo nombre. Por favor, vuelve a iniciar el registro de nuevo miembro de personal ");
                  newUser = false;

               }

           }

           ArrayList<Proyecto> totalProyectos = this.getProyectos(); 

           if (totalProyectos.isEmpty()){

                System.out.println("No hay proyectos activos en la ONG en este momento, asi que no es posible registrar nuevo personal ");
            }

           else if (newUser){  /*como el usuario es nuevo, ahora pedimos que se guarden el resto de los datos de miembro de personal*/

               /**Solicitud por consola de password y lectura por teclado de password*/
               System.out.print("Introduce la password del usuario del nuevo miembro del personal: ");
               nuevaContraseña = leerDatos.nextLine();

               /**Comprobacion para que campo password no esté vacío*/
                while (nuevaContraseña.isEmpty()){

                   System.out.print("La password del nuevo usuario no puede ser un campo vacio. Introduce la password del nuevo miembro del personal y usuario: ");
                   nuevaContraseña = leerDatos.nextLine();

            }

            /**Solicitud por consola de la delegacion y lectura por teclado de la delegacion a la que pertenece el nuevo miembro*/
            System.out.print("Introduce la delegación a la que pertenece el nuevo miembro del personal: 'Entreculturas Polonia', 'Entreculturas Portugal' o 'Entreculturas Francia' ");
            nuevaDelegacion = leerDatos.nextLine();

            /**Comprobacion para que campo delegación no esté vacío*/
            while (nuevaDelegacion.isEmpty()){

               System.out.print("La delegación del nuevo miembro no puede ser un campo vacío. Introduce la delegación del nuevo miembro del personal: ");
               nuevaDelegacion = leerDatos.nextLine();

           }

            /**Comprobacion para que campo delegación esté limitado a los tres tipos posibles y no se pueda introducir cualquier String. Si se crean nuevas delegaciones hay que cambiar esto*/

            while (!"Entreculturas Polonia".equals(nuevaDelegacion) && !"Entreculturas Francia".equals(nuevaDelegacion) && !"Entreculturas Portugal".equals(nuevaDelegacion)){ /*comprobacion de campo para que solo se puedan introducir las delegaciones que existen*/

                System.out.print("La delegación indicada no es correcta. Por favor, vuelve a escribir el nombre:\n ");
                nuevaDelegacion = leerDatos.nextLine(); 

            }
            
            ArrayList<Proyecto> proyectosSinAsignar = this.proyectosLibres(); /*ArrayList de proyectos libres*/
            Proyecto proyectoAsignado; /*Proyecto que se asignará*/
            ArrayList<Proyecto> proyectosDelNuevo = new ArrayList<Proyecto>(); /*ArrayList de proyectos del miembro del personal nuevo*/
            Personal nuevoPersonal = new Personal ();            

            if (proyectosSinAsignar.isEmpty()){
                Collections.shuffle(totalProyectos);
                proyectoAsignado = totalProyectos.get(0);/*para asignación aleatoria, cojo el primer proyecto de entre todos los proyectos, ya que todos tienen miembros*/
                proyectosDelNuevo.add(proyectoAsignado);
                System.out.print("No hay proyectos sin personal asignado. El nuevo miembro de personal colaborará con otros miembros en el proyecto código " + proyectoAsignado.getCodigoDeProyecto());

            }

            else {
                proyectoAsignado = proyectosSinAsignar.get(0);
                proyectosDelNuevo.add(proyectoAsignado);
                System.out.println("Hay proyectos que todavía no tienen personal. El nuevo miembro de personal se asigna al proyecto código " + proyectoAsignado.getCodigoDeProyecto());

            }  /*guardamos miembro de personal nuevo*/
            
             nuevoPersonal.setNombre(nuevoNombre);
             nuevoPersonal.setApellido(nuevoApellido);
             nuevoPersonal.setTipoDePersonal(tipoDePersonalDelNuevo);
             nuevoPersonal.setUsuario(nuevoUsuario);
             nuevoPersonal.setPassword(nuevaContraseña);
             nuevoPersonal.setDelegacion(nuevaDelegacion);
             nuevoPersonal.setListadoProyectos(proyectosDelNuevo);
             nuevaListaPersonal.add(nuevoPersonal);

             if ("Voluntario".equals(tipoDePersonalDelNuevo)){

                String nuevoDNI; 

                System.out.print("Como el nuevo miembro de personal es un voluntario, guardaremos un par de datos más. Introduce el DNI del nuevo voluntario: ");
                nuevoDNI = leerDatos.nextLine();

                 /**Comprobacion para que campo nuevoDNI no esté vacío*/
                while (nuevoDNI.isEmpty()){

                   System.out.print("El DNI del nuevo voluntario no puede ser un campo vacío. Introduce DNI: ");
                   nuevoDNI = leerDatos.nextLine();

                }
                
                int nuevoCodigoDePersonal = nuevoPersonal.getCodigoDePersonal();
                Voluntario voluntario = new Voluntario ();
                voluntario.setCodigoDePersonal(nuevoCodigoDePersonal);
                voluntario.setNombre(nuevoNombre); 
                voluntario.setApellido(nuevoApellido);
                voluntario.setDNI(nuevoDNI); 
                
                ArrayList<Voluntario> listadoVoluntarios = this.getListaVoluntarios();
                listadoVoluntarios.add(voluntario);
                
             }

             else if ("VoluntarioInternacional".equals(tipoDePersonalDelNuevo)){

                String nuevoNIE; 

                System.out.print("Como el nuevo miembro de personal es un voluntario internacional, guardaremos un par de datos más. Introduce el NIE del nuevo voluntario: ");
                nuevoNIE = leerDatos.nextLine();

                /**Comprobacion para que campo nuevoNIE no esté vacío*/
                while (nuevoNIE.isEmpty()){

                   System.out.print("El NIE del nuevo voluntario internacional no puede ser un campo vacío. Introduce NIE: ");
                   nuevoNIE = leerDatos.nextLine();

                }
                int nuevoCodigoDePersonal = nuevoPersonal.getCodigoDePersonal();
                VoluntarioInternacional voluntarioInternacional = new VoluntarioInternacional ();
                voluntarioInternacional.setNombre(nuevoNombre);
                voluntarioInternacional.setApellido(nuevoApellido);
                voluntarioInternacional.setNIE(nuevoNIE);
                voluntarioInternacional.setCodigoDePersonal(nuevoCodigoDePersonal);
                
                ArrayList<VoluntarioInternacional> listadoVoluntariosInternacionales = this.getListaVoluntariosInternacionales();
                listadoVoluntariosInternacionales.add(voluntarioInternacional);

             }

             else {

                String nuevoDNI; 
                float nuevoCosteSalario;
                String nuevaFuncion;

                System.out.print("Como el nuevo miembro de personal es contratado, guardaremos algunos datos más. Introduce el DNI del nuevo personal contratado: ");
                nuevoDNI = leerDatos.nextLine();

                /**Comprobacion para que campo nuevoDNI no esté vacío*/
                while (nuevoDNI.isEmpty()){

                   System.out.print("El DNI del nuevo personal contratado no puede ser un campo vacío. Introduce DNI: ");
                   nuevoDNI = leerDatos.nextLine();

                }

                System.out.print("Introduce el nuevo coste de salario: ");
                nuevoCosteSalario = leerDatos.nextFloat();  

                /**Comprobacion para que campo nuevoCosteSalario no esté vacío*/
                while (nuevoCosteSalario == 0.0f){

                   System.out.print("El coste de salario del nuevo personal contratado no puede ser un campo vacío. Introduce el coste de salario: ");
                   nuevoCosteSalario = leerDatos.nextInt();
                   leerDatos.nextLine();/*Consume salto de línea no leido por nextInt*/

                }
                
                System.out.print("Introduce la nueva función: ");
                nuevaFuncion = leerDatos.nextLine();

                /**Comprobacion para que campo nuevaFuncion no esté vacío*/
                while (nuevaFuncion.isEmpty()){

                   System.out.print("La función del nuevo personal contratado no puede ser un campo vacío. Introduce la función: ");
                   nuevaFuncion = leerDatos.nextLine();

                }
                
                int nuevoCodigoDePersonal = nuevoPersonal.getCodigoDePersonal();
                Contratado contratado = new Contratado ();
                contratado.setNombre(nuevoNombre);
                contratado.setApellido(nuevoApellido);
                contratado.setCosteSalario(nuevoCosteSalario);
                contratado.setFuncion(nuevaFuncion);
                contratado.setCodigoDePersonal(nuevoCodigoDePersonal);
                
                ArrayList<Contratado> listadoContratados = this.getListaContratados();
                listadoContratados.add(contratado);
             }

             System.out.println("Nuevo miembro de personal guardado correctamente "); 

           }
           
        }
        
         catch(InputMismatchException e){ /*controlamos excepcion para que no devuelva error si introducen caracteres por teclado cuando se piden int o float*/
          
            System.out.print("No se ha introducido un número correcto. Por favor, vuelve a guardar los datos del nuevo miembro del personal desde el principio.\n ");
          
        }
        
    }  
    
     public void entrarDatosDelegacion(){
        /**Declaracion variables**/
        String newName_Delegacion; 
        String newName_Direccion; 
        String newName_Telefono;
        boolean newDelegacion = true;
   
       /**Solicitud por consola del nombre de la delegacion y lectura por teclado de newName_Delegacion**/
       System.out.print("Introduce la nueva delegación a registrar: ");
       newName_Delegacion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Delegacion no esté vacío*/
        while (newName_Delegacion.isEmpty()){

           System.out.print("Para registrar una nueva delegación, este campo es totalmente obligatorio:");
           newName_Delegacion = leerDatos.nextLine();

       }
        
       

       /**Solicitud por consola de la Dirección y lectura por teclado denewName_Direccion**/
       System.out.print("Introduce la dirección de la Delegación que desee registrar: ");
       newName_Direccion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Direccion no esté vacío**/
        while (newName_Direccion.isEmpty()){

           System.out.print("Para registrar una nueva delegación, este campo es totalmente obligatorio:");
           newName_Direccion = leerDatos.nextLine();

       }

       /**Solicitud por consola del Telefono y lectura por teclado del newName_Telefono**/
       System.out.print("Introduce un número de telefono para poder contactar con usted: ");
       newName_Telefono = leerDatos.nextLine();

  
       /*Comprobacion para que campo newName_Telefono no esté vacío*/
       
       while (newName_Telefono.isEmpty()){
	   System.out.print("Para registrar una nueva delegación, este campo es totalmente obligatorio:");
           newName_Telefono = leerDatos.nextLine();
       }

       /** INICIO - Bloqueo de código de la verificación de las delegaciones, 
           en caso de que la Delegación sea existente, volverá a empezar de nuevo el formulario.
           En caso contrario, se añadirá la Delegación y volverá al menú inicial**/
       ArrayList<Delegacion> nuevaListaDelegaciones = this.getDelegaciones();

       for (int i = 0; i < nuevaListaDelegaciones.size(); i++){ /**hacemos un loop para recorrer los objetos personal del arraylist listado de personal de la ONG*/
          if (nuevaListaDelegaciones.get(i).getNombre().equals(newName_Delegacion)){ /**comprobamos que el usuario no exista ya para no guardar un nuevo miembro de personal con el mismo user*/

              System.out.println("Esta Delegación ya existe. No se puede crear un con el mismo nombre. Por favor, vuelve formular la nueva Delegacion correctamente");
              newDelegacion = false;
           }
       }
       
       if (newDelegacion) {
 
        Delegacion nuevaDelegacion = new Delegacion (); 
        nuevaDelegacion.setNombre(newName_Delegacion);
        nuevaDelegacion.setDireccion(newName_Direccion);
        nuevaDelegacion.setTelefono(newName_Telefono);
        nuevaDelegacion.setCifOng(CIF);
        nuevaListaDelegaciones.add(nuevaDelegacion);
        System.out.print("Nueva Delegacion guardada correctamente ");  
        
       }
    }
     
     
    public void entrarDatosProyecto(){
        /**Declaracion variables para guardar datos de proyecto nuevo*/
        String nuevoPais;
        String nuevaLocalizacion; 
        String nuevaLineaDeAccion; 
        String nuevaSublineaDeAccion; 
        LocalDate nuevaFechaDeInicio; 
        LocalDate nuevaFechaDeFinalizacion;
        String nuevoSocioLocal; 
        String nuevoFinanciador; 
        float nuevaFinanciacionAportada;
        float nuevoCosteProyecto;
        String nuevasAccionesARealizar; 
        
        
        /**Solicitud por consola del pais de Proyecto y lectura por teclado de nuevoPais*/
       System.out.print("Introduce el pais del proyecto: ");
       nuevoPais = leerDatos.nextLine();

       /**Comprobacion para que campo país no esté vacío*/
        while (nuevoPais.isEmpty()){

           System.out.print("El campo país no puede quedar vacío, introduce el país del Proyecto: ");
           nuevoPais = leerDatos.nextLine();

       }

       /**Solicitud por consola de la l�nea de localizacion y lectura por teclado de nuevaLocalizacion*/
       System.out.print("Introduce nombre de la nueva localización: ");
       nuevaLocalizacion = leerDatos.nextLine();

       /**Comprobacion para que campo localizacion no esta vacio*/
        while (nuevaLocalizacion.isEmpty()){

           System.out.print("El nombre de la localización no puede quedar vacío. Introduce el nombre de la localización: ");
           nuevaLocalizacion = leerDatos.nextLine();

       }

        /**Solicitud por consola de la linea de acción del proyecto y lectura por teclado de nuevaLineaDeAccion*/
       System.out.print("Introduce la línea de acción: ");
       nuevaLineaDeAccion = leerDatos.nextLine();

       /**Comprobacion para que campo apellido no está vacío*/
        while (nuevaLineaDeAccion.isEmpty()){

           System.out.print("La línea de acción no puede ser un campo vacío. Introduce la línea de acción: ");
           nuevaLineaDeAccion = leerDatos.nextLine();

       }

       /**Solicitud por consola la sublínea y lectura por teclado de nuevaSublineaDeAccion*/
       System.out.print("Introduce la sublínea de acción: ");
       nuevaSublineaDeAccion = leerDatos.nextLine();

       /**Comprobacion para que campo sublínea de acción no está vacío*/
        while (nuevaSublineaDeAccion.isEmpty()){

           System.out.print("La sublínea de acción no puede quedar vacía. Introduce la sublínea de acción: ");
           nuevaSublineaDeAccion = leerDatos.nextLine();

       }  
      
      try{
      
            /**Solicitud por consola de la fecha de inicio y lectura por teclado de fechaDeInicio*/
           System.out.print("Introduce la fecha de inicio del proyecto: ");
           String newFechaInicio = leerDatos.nextLine();
           nuevaFechaDeInicio = LocalDate.parse(newFechaInicio);

           /**Comprobacion para que campo fecha de inicio no está vacío*/
            while (newFechaInicio.isEmpty()){

               System.out.print("La fecha de inicio no puede quedar vacía, introduce la fecha de inicio del Proyecto: ");
               newFechaInicio = leerDatos.nextLine();
               nuevaFechaDeInicio = LocalDate.parse(newFechaInicio);
           }

           /**Solicitud por consola de la fecha de finalización y lectura por teclado de nuevaFechaDeFinalizacion*/
           System.out.print("Introduce fecha de finalización: ");
           String newFechaFin = leerDatos.nextLine();
           nuevaFechaDeFinalizacion = LocalDate.parse(newFechaFin);

           /**Comprobacion para que campo fecha de finalización no está vacío*/
            while (newFechaFin.isEmpty()){

               System.out.print("La fecha de finalización no puede quedar vacía. Introduce la fecha de finalización: ");
               newFechaFin = leerDatos.nextLine();
               nuevaFechaDeFinalizacion = LocalDate.parse(newFechaFin);
           }
      
            /**Solicitud por consola de socio local y lectura por teclado de nuevoSocioLocal*/
           System.out.print("Introduce el socio local: ");
           nuevoSocioLocal = leerDatos.nextLine();

           /**Comprobacion para que campo socio local no está vacío*/
            while (nuevoSocioLocal.isEmpty()){

               System.out.print("Socio local no puede ser un campo vacío. Introduce el socio local: ");
               nuevoSocioLocal = leerDatos.nextLine();

           }

           /**Solicitud por consola del financiador y lectura por teclado de nuevoFinanciador*/
           System.out.print("Introduce el financiador: ");
           nuevoFinanciador = leerDatos.nextLine();

           /**Comprobacion para que campo financiador no está vacío*/
            while (nuevoFinanciador.isEmpty()){

               System.out.print("El financiador no puede quedar vacío. Introduce el financiador: ");
               nuevoFinanciador = leerDatos.nextLine();

           }

            /**Solicitud por consola de la financiación aportada y lectura por teclado de nuevaFinanciacionAportada*/
           System.out.print("Introduce la financiación: ");
           nuevaFinanciacionAportada = leerDatos.nextFloat();

           /**Comprobacion para que campo financiación aportada no está vacía*/
            while (nuevaFinanciacionAportada == 0.0f){

               System.out.print("La financiación aportada no puede quedar vacía. Introduce un importe: ");
               nuevaFinanciacionAportada = leerDatos.nextFloat();

           }  

            /**Solicitud por consola del coste del proyecto y lectura por teclado de nuevoCosteProyecto*/
           System.out.print("Introduce el coste del proyecto: ");
           nuevoCosteProyecto = leerDatos.nextFloat();

           /**Comprobacion para que campo coste del proyecto no está vacío*/
            while (nuevoCosteProyecto == 0.0f){

               System.out.print("El coste del proyecto no puede quedar vacío. Introduce un importe: ");
               nuevoCosteProyecto = leerDatos.nextFloat();
               leerDatos.nextLine();/*Consume salto de línea no leido por nextFloat*/

           }  

            /**Solicitud por consola de las acciones a realizar por el proyecto y lectura por teclado de nuevasAccionesARealizar*/
           System.out.print("Introduce las acciones a realizar: ");
           nuevasAccionesARealizar = leerDatos.nextLine();

           /**Comprobacion para que campo acciones a realizar no está vacío*/
            while (nuevasAccionesARealizar.isEmpty()){

               System.out.print("Debe especificar las acciones a realizar. Por favor, escríbalas: ");
               nuevasAccionesARealizar = leerDatos.nextLine();
           }
            
            String nuevoCifOng = ONG.getCIF();
            

            Proyecto nuevoProyecto = new Proyecto (nuevoPais, nuevaLocalizacion, nuevaLineaDeAccion, nuevaSublineaDeAccion, nuevaFechaDeInicio, nuevaFechaDeFinalizacion, nuevoSocioLocal, nuevoFinanciador, nuevaFinanciacionAportada, nuevoCosteProyecto, nuevasAccionesARealizar, nuevoCifOng);
            nuevoProyecto.setCifOng(nuevoCifOng);
            nuevoProyecto.setPais(nuevoPais);
            nuevoProyecto.setLineaDeAccion(nuevaLineaDeAccion);
            nuevoProyecto.setSublineaDeAccion(nuevaLineaDeAccion);
            nuevoProyecto.setFechaDeInicio(nuevaFechaDeInicio);
            nuevoProyecto.setFechaDeFinalizacion(nuevaFechaDeFinalizacion);
            nuevoProyecto.setSocioLocal(nuevoSocioLocal);
            nuevoProyecto.setFinanciador(nuevoFinanciador);
            nuevoProyecto.setFinanciacionAportada(nuevaFinanciacionAportada);
            nuevoProyecto.setCosteProyecto(nuevoCosteProyecto);
            nuevoProyecto.setAccionesARealizar(nuevasAccionesARealizar);
            ArrayList<Proyecto>nuevoListadoProyectos = this.getProyectos();
            nuevoListadoProyectos.add(nuevoProyecto);
            System.out.print("El proyecto ha sido guardado correctamente.\n");
            
      }
      
       catch(DateTimeParseException e){ /*controlamos excepcion sobre LocalDate para que se siga el formato especificado*/
          
          System.out.print("Alguna fecha introducida no es correcta o no sigue el formato indicado, por favor, vuelve a empezar a guardar los datos del proyecto de nuevo.\n ");
                  
      }
      
      catch(InputMismatchException e){ /*controlamos excepcion para que no devuelva error si introducen caracteres por teclado cuando se piden int o float*/
          
          System.out.print("No se ha introducido un número correcto. Por favor, vuelve a guardar los datos del proyecto desde el principio.\n ");
          
      }
    } 
    
    /*Función para recoger por teclado el código de Personal del personal que se desea eliminar en la BBDD*/
    
    int codigoDePersonalAEliminar(){
        System.out.println("Escribe el código de personal del personal que deseas modificar o eliminar");
        int codigoDePersonalAEliminar = leerDatos.nextInt(); 
        leerDatos.nextLine();
        return codigoDePersonalAEliminar;
    }
    
    /*Función para recoger por teclado el String que corresponderá a uno de los atributos String del personal(o personal contratado) que se desea modificar en la BBDD*/
    
    String atributoDePersonalAModificar(){
        System.out.println("¿Qué clase quieres modificar: Personal o Contratado?");
        String clase = leerDatos.nextLine();
        String atributoViejo= "";
        if (!"Contratado".equals(clase)){
            System.out.println("Escribe el nombre del atributo del personal que deseas modificar: nombre, apellido, usuario o password.");
            atributoViejo = leerDatos.nextLine();       
            while (!"nombre".equals(atributoViejo) && !"apellido".equals(atributoViejo) && !"usuario".equals(atributoViejo) && !"password".equals(atributoViejo)){ /*comprobacion de campo para que solo se puedan introducir los abributos que existen*/
                System.out.println("El nombre del atributo que deseas modificar es incorrecto. Vuelve a introducirlo");
                atributoViejo = leerDatos.nextLine();       
            }
        }
        else{
            System.out.println("Escribe el nombre del atributo del personal contratado que deseas modificar: funcion, costeSalario.");
            atributoViejo = leerDatos.nextLine();       
            while (!"funcion".equals(atributoViejo) && !"costeSalario".equals(atributoViejo)){ /*comprobacion de campo para que solo se puedan introducir los abributos que existen*/
                System.out.println("El nombre del atributo que deseas modificar es incorrecto. Vuelve a introducirlo");
                atributoViejo = leerDatos.nextLine();       
            }
            
        }
        return atributoViejo;
       
    }
    
    String atributoModicado(String atributoViejo){
         System.out.println("¿Cuál es el nuevo " + atributoViejo + " que quieres poner?");
         String atributoModificado = leerDatos.nextLine();
        return atributoModificado;
    }
    
      /*Función para recoger por teclado el id de Delegación de la delegación que se desea eliminar o modificar en la BBDD*/
    
    int idDeDelegacionAEliminar(){
        System.out.println("Escribe el id de la delegación que deseas modificar o eliminar");
        int idDeDelegacionAEliminar = leerDatos.nextInt(); 
        leerDatos.nextLine();
        return idDeDelegacionAEliminar;
    }
    
    /*Función para recoger por teclado el String que corresponderá a uno de los atributos String de la delegación que se desea modificar en la BBDD*/
    
    String atributoDeDelegacionAModificar(){
        System.out.println("Escribe el nombre del atributo de la delegación que deseas modificar: nombre, direccion o telefono.");
        String atributoViejo = leerDatos.nextLine();       
        while (!"nombre".equals(atributoViejo) && !"direccion".equals(atributoViejo) && !"telefono".equals(atributoViejo)){ /*comprobacion de campo para que solo se puedan introducir los abributos que existen*/
            System.out.println("El nombre del atributo que deseas modificar es incorrecto. Vuelve a introducirlo");
            atributoViejo = leerDatos.nextLine();       
        }
        return atributoViejo;
    }
    
       /*Función para recoger por teclado el codigoDeProyecto del proyecto que se desea eliminar o modificar en la BBDD*/
    
    int codigoDeProyectoAEliminar(){
        System.out.println("Escribe el codigoDeProyecto del proyecto que desees modificar o eliminar");
        int codigoDeProyectoAEliminar = leerDatos.nextInt(); 
        leerDatos.nextLine();
        return codigoDeProyectoAEliminar;
    }
    
    /*Función para recoger por teclado el String que corresponderá a uno de los atributos String del proyecto que se desea modificar en la BBDD*/
    
    String atributoDeProyectoAModificar(){
        System.out.println("Escribe el nombre del atributo del proyecto que deseas modificar: pais, localizacion, lineaDeAccion, sublineaDeAccion, socioLocal, financiador, accionesARealizar");
        String atributoViejo = leerDatos.nextLine();       
        while (!"pais".equals(atributoViejo) && !"localizacion".equals(atributoViejo) && !"lineaDeAccion".equals(atributoViejo) && !"sublineaDeAccion".equals(atributoViejo) && !"socioLocal".equals(atributoViejo) && !"financiador".equals(atributoViejo) && !"accionesARealizar".equals(atributoViejo)){ /*comprobacion de campo para que solo se puedan introducir los abributos que existen*/
            System.out.println("El nombre del atributo que deseas modificar es incorrecto. Vuelve a introducirlo");
            atributoViejo = leerDatos.nextLine();       
        }
        return atributoViejo;
    }
 
}