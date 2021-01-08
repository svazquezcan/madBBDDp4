/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.SQL;

import MadBBDD.producto4.Contratado;
import MadBBDD.producto4.Contratados;
import MadBBDD.producto4.DAO.PersonalDAO;
import MadBBDD.producto4.utilidad.DataSourceJDBC;
import MadBBDD.producto4.Personal;
import MadBBDD.producto4.PersonalList;
import MadBBDD.producto4.Proyecto;
import MadBBDD.producto4.Voluntario;
import MadBBDD.producto4.VoluntarioInternacional;
import MadBBDD.producto4.Voluntarios;
import MadBBDD.producto4.VoluntariosInternacionales;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Sandra
 */
public class SQLPersonalDAO implements PersonalDAO {
    
    private DataSourceJDBC mySqlDataSource = new DataSourceJDBC();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());
    
    public SQLPersonalDAO() throws SQLException {
        this.mySqlDataSource = mySqlDataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(PersonalList a) {
        try {                   
            ArrayList<Personal> listadoPersonal = a.getPersonalList();
            /*Recorremos arraylist de personal e insertamos uno a uno en BBDD*/
            for(int i = 0; i<listadoPersonal.size(); i++){
                String delegacion = listadoPersonal.get(i).getDelegacion();
                int idDelegacion = listadoPersonal.get(i).obtenerIdDelegacion(delegacion);

                jdbcTemplate.update(
                "INSERT INTO personal(idDelegacion,nombre,apellido,usuario,contraseña,tipoDePersonal) VALUES (?,?,?,?,?,?)", idDelegacion,listadoPersonal.get(i).getNombre(),listadoPersonal.get(i).getApellido(),listadoPersonal.get(i).getUsuario(),listadoPersonal.get(i).getPassword(),listadoPersonal.get(i).getTipoDePersonal());
                System.out.println("El personal de id " + listadoPersonal.get(i).getCodigoDePersonal()+ " ha sido creado.");
                
                ArrayList<Proyecto> proyectosAsignados = listadoPersonal.get(i).getListadoProyectos();
                
                if(proyectosAsignados==null ||proyectosAsignados.isEmpty()){
                } else {
                    for (Proyecto proyecto : proyectosAsignados){
                        
                        jdbcTemplate.update(
                                "INSERT INTO proyecto_personal(codigoDePersonal,codigoDeProyecto) VALUES (?,?)",listadoPersonal.get(i).getCodigoDePersonal(),proyecto.getCodigoDeProyecto());
                        
                    }
                }
            }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("Este personal ya existe. No se puede volver a crear.");
            
        }        
        
    }
    
    public void insertarVoluntario(ArrayList<Voluntario>listadoVoluntarios){
         try {                   
            /*Recorremos arraylist de voluntarios e insertamos uno a uno en BBDD*/
            for(int i = 0; i<listadoVoluntarios.size(); i++){

                jdbcTemplate.update(
                "INSERT INTO voluntario(dni,codigoDePersonal) VALUES (?,?)", listadoVoluntarios.get(i).getDNI(), listadoVoluntarios.get(i).getCodigoDePersonal());
                System.out.println("El voluntario de id " + listadoVoluntarios.get(i).getCodigoDePersonal()+ " ha sido creado.");
      
            }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("DataIntegrityViolationException");
            
        }       
    }
    
    public void insertarVoluntarioInternacional(ArrayList<VoluntarioInternacional>listadoVoluntariosInternacionales){
         try {                   
            /*Recorremos arraylist de voluntarios internacionales e insertamos uno a uno en BBDD*/
            for(int i = 0; i<listadoVoluntariosInternacionales.size(); i++){

                jdbcTemplate.update(
                "INSERT INTO voluntariointernacional(nie,codigoDePersonal) VALUES (?,?)", listadoVoluntariosInternacionales.get(i).getNIE(), listadoVoluntariosInternacionales.get(i).getCodigoDePersonal());
                System.out.println("El voluntario internacional de id " + listadoVoluntariosInternacionales.get(i).getCodigoDePersonal()+ " ha sido creado.");
      
            }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("DataIntegrityViolationException");
            
        }       
    }
    
     public void insertarContratado (ArrayList<Contratado>listadoContratados){
         try {                   
            /*Recorremos arraylist de contratados e insertamos uno a uno en BBDD*/
            for(int i = 0; i<listadoContratados.size(); i++){

                jdbcTemplate.update(
                "INSERT INTO contratado(dni,codigoDePersonal, funcion, costeSalario) VALUES (?,?,?,?)", listadoContratados.get(i).getDNI(), listadoContratados.get(i).getCodigoDePersonal(),listadoContratados.get(i).getFuncion(),listadoContratados.get(i).getCosteSalario());
                System.out.println("El contratado de id " + listadoContratados.get(i).getCodigoDePersonal()+ " ha sido creado.");
      
            }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("DataIntegrityViolationException");
            
        }       
    }

    @Override
    public void modificar(String a, String b, Integer c) {
        if(!"funcion".equals(a) && !"costeSalario".equals(a)){
            String sql = "UPDATE personal SET ";
            String sqlUpdate = sql.concat(a);
            String sqlLast = sqlUpdate + " = ? WHERE codigoDePersonal = ?";
            jdbcTemplate.update(sqlLast,b,c);
            System.out.println("El atributo " + a + " del personal de código " + c + " pasa a ser ahora " + b);
        }
        else{
            String SQL = "UPDATE contratado SET ";
            String SQLUpdate = SQL.concat(a);
            String SQLLast = SQLUpdate + " = ? WHERE codigoDePersonal = ?";
            jdbcTemplate.update(SQLLast,b,c);
            System.out.println("El atributo " + a + " del personal contratado de código " + c + " pasa a ser ahora " + b);
        }
       
    }

    @Override
    public void eliminar(Integer a) {
        jdbcTemplate.update(
        "DELETE FROM personal WHERE codigoDePersonal = ?;",a);
        System.out.println("El personal de código " + a + " ha sido eliminado con éxito");

    }

    @Override
    /*En realidad no necesita el parámetro de entrada PersonalList pero lo mantenemos porque es función CRUD y las clases XML del anterior producto sí lo necesitan*/
    public void obtenerTodos(PersonalList a) throws JAXBException, IOException {
        System.out.println("Este es el listado de personal:");
        List<Map<String,Object>> rows = (List<Map<String,Object>>)
        jdbcTemplate.queryForList("SELECT * FROM personal"); 
        rows.forEach(System.out::println);
        System.out.println("Este es el listado de voluntarios:");
        List<Map<String,Object>> filas = (List<Map<String,Object>>)
        jdbcTemplate.queryForList("SELECT * FROM voluntario"); 
        filas.forEach(System.out::println);
        System.out.println("Este es el listado de voluntarios internacionales:");
        List<Map<String,Object>> atributos = (List<Map<String,Object>>)
        jdbcTemplate.queryForList("SELECT * FROM voluntariointernacional"); 
        atributos.forEach(System.out::println);
        System.out.println("Este es el listado de contratados:");
        List<Map<String,Object>> tuplas = (List<Map<String,Object>>)
        jdbcTemplate.queryForList("SELECT * FROM contratado"); 
        tuplas.forEach(System.out::println);
        
    }
    
    public int lastCodigoDePersonal(){
        int lastCodigoDePersonal = jdbcTemplate.queryForObject("SELECT codigoDePersonal FROM personal ORDER BY codigoDePersonal DESC LIMIT 1", Integer.class);
        return lastCodigoDePersonal;
    }
    
    
    public void volcarDatosXML (PersonalList a) throws FileNotFoundException, JAXBException{
        InputStream inStream = new FileInputStream("Personal.xml");
        JAXBContext context = JAXBContext.newInstance(PersonalList.class); 
        Unmarshaller unmarshaller = context.createUnmarshaller(); 

        PersonalList datosPersonalListXML = (PersonalList) unmarshaller.unmarshal(inStream);
        ArrayList<Personal> listaPersonalXML = datosPersonalListXML.getPersonalList();
        /*Recorremos arraylist de personal de unmarshaller y volcamos los miembros de personal en la BBDD*/
        for(int i = 0; i<listaPersonalXML.size(); i++){
            String delegacion = listaPersonalXML.get(i).getDelegacion();
            int idDelegacion = listaPersonalXML.get(i).obtenerIdDelegacion(delegacion);

            jdbcTemplate.update(
            "INSERT INTO personal(idDelegacion,nombre,apellido,usuario,contraseña,tipoDePersonal) VALUES (?,?,?,?,?,?)", idDelegacion,listaPersonalXML.get(i).getNombre(),listaPersonalXML.get(i).getApellido(),listaPersonalXML.get(i).getUsuario(),listaPersonalXML.get(i).getPassword(),listaPersonalXML.get(i).getTipoDePersonal());
        
        }
        
        System.out.println("El XML del listado de personal ha sido volcado con éxito");
        
        /*Volvemos a recorrer arraylist de personal de unmarshaller y esta vez vamos detectando las subclases
        y recorriendo a su vez los unmarshaller de las subclases para volcar los tipos de personal en sus respectivas tablas también*/


        InputStream inStream2 = new FileInputStream("Voluntarios.xml");
        JAXBContext context2 = JAXBContext.newInstance(Voluntarios.class); 
        Unmarshaller unmarshaller2 = context2.createUnmarshaller(); 

        Voluntarios datosVoluntariosXML = (Voluntarios) unmarshaller2.unmarshal(inStream2);
        ArrayList<Voluntario> listaVoluntariosXML = datosVoluntariosXML.getVoluntarios();

        for(int x = 0; x>listaVoluntariosXML.size();x++){
          jdbcTemplate.update(
          "INSERT INTO voluntario(dni, codigoDePersonal) VALUES (?, ?)",listaVoluntariosXML.get(x).getDNI(), listaVoluntariosXML.get(x).getCodigoDePersonal());

        }
        
        System.out.println("El XML de la clase voluntario ha sido volcado con éxito");


        InputStream inStream3 = new FileInputStream("VoluntariosInternacionales.xml");
        JAXBContext context3 = JAXBContext.newInstance(VoluntariosInternacionales.class); 
        Unmarshaller unmarshaller3 = context3.createUnmarshaller(); 

        VoluntariosInternacionales datosVoluntariosInternacionalesXML = (VoluntariosInternacionales) unmarshaller3.unmarshal(inStream3);
        ArrayList<VoluntarioInternacional> listaVoluntariosInternacionalesXML = datosVoluntariosInternacionalesXML.getVoluntariosInternacionales();

        for(int y=0; y>listaVoluntariosInternacionalesXML.size(); y++){
          jdbcTemplate.update(
          "INSERT INTO voluntariointernacional(nie, codigoDePersonal) VALUES (?, ?)",listaVoluntariosInternacionalesXML.get(y).getNIE(),listaVoluntariosInternacionalesXML.get(y).getCodigoDePersonal());

        }

        System.out.println("El XML de la clase voluntario internacional ha sido volcado con éxito");


        InputStream inStream4 = new FileInputStream("Contratados.xml");
        JAXBContext context4 = JAXBContext.newInstance(Contratados.class); 
        Unmarshaller unmarshaller4 = context4.createUnmarshaller(); 

        Contratados datosContratadosXML = (Contratados) unmarshaller4.unmarshal(inStream4);
        ArrayList<Contratado> listaContratadosXML = datosContratadosXML.getContratados();

        for(int z=0;z>listaContratadosXML.size();z++){
          jdbcTemplate.update(
          "INSERT INTO contratados(dni, costeSalario, funcion, codigoDePersonal) VALUES (?,?,?,?)",listaContratadosXML.get(z).getDNI(),listaContratadosXML.get(z).getCosteSalario(),listaContratadosXML.get(z).getFuncion(),listaContratadosXML.get(z).getCodigoDePersonal()    );

        } 
            
        System.out.println("El XML de la clase contratado ha sido volcado con éxito");

    }

}
