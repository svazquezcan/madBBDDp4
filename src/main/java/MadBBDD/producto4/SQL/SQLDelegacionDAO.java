/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.SQL;

import MadBBDD.producto4.DAO.DelegacionDAO;
import MadBBDD.producto4.utilidad.DataSourceJDBC;
import MadBBDD.producto4.Delegacion;
import MadBBDD.producto4.Delegaciones;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Sandra
 */
public class SQLDelegacionDAO implements DelegacionDAO {
    
    private DataSourceJDBC mySqlDataSource = new DataSourceJDBC();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());
    
    public SQLDelegacionDAO() throws SQLException {
        this.mySqlDataSource = mySqlDataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(Delegaciones a) {
        try { 
            
            ArrayList<Delegacion> listadoDelegacion = a.getDelegaciones();
                /*Recorremos arraylist de delegacion e insertamos uno a uno en BBDD*/
                for(int i = 0; i<listadoDelegacion.size(); i++){
                    jdbcTemplate.update(
                    "INSERT INTO delegacion(nombre,direccion,telefono,cifOng) VALUES (?,?,?,?)", listadoDelegacion.get(i).getNombre(),listadoDelegacion.get(i).getDireccion(),listadoDelegacion.get(i).getTelefono(), listadoDelegacion.get(i).getCifOng());
                    System.out.println("La delegación de id " + listadoDelegacion.get(i).getIdDelegacion()+ " ha sido creada.");
               }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("DataIntegrityViolationException");
            
        }
    }
    
    @Override
    public void modificar(String a, String b, Integer c) {
        String sql = "UPDATE delegacion SET ";
        String sqlUpdate = sql.concat(a);
        String sqlLast = sqlUpdate + " = ? WHERE idDelegacion = ?";
        jdbcTemplate.update(sqlLast,b,c);
        System.out.println("El atributo " + a + " de la delegacion de id " + c + " pasa a ser ahora " + b);
    }    

    @Override
    public void eliminar(Integer a) {
        jdbcTemplate.update(
        "DELETE FROM delegacion WHERE idDelegacion = ?;",a);
        System.out.println("La delegación de id " + a + " ha sido eliminada con éxito");

    }    

    @Override
    public Delegaciones obtenerTodos(Delegaciones a) throws JAXBException, IOException {
        System.out.println("Listado de Delegaciones");
        List<Map<String,Object>> rows = (List<Map<String,Object>>)
        jdbcTemplate.queryForList("SELECT * FROM delegacion"); 
        rows.forEach(System.out::println);
        ArrayList<Delegacion> listDelegaciones = new ArrayList<Delegacion>();
        Delegaciones miDelegacionesList = new Delegaciones();
        for (Map row : rows) {
            Delegacion p = new Delegacion();
            p.setIdDelegacion((int) row.get("idDelegacion"));
            p.setCifOng((String) row.get("cifOng"));
            p.setNombre((String) row.get("nombre"));
            p.setDireccion((String) row.get("direccion"));
            p.setTelefono((String) row.get("telefono"));
            listDelegaciones.add(p); 
        }
        miDelegacionesList.setDelegaciones(listDelegaciones);
        return miDelegacionesList;
    }    
    
    public int checkidDelegacion(int codigo){
        try{
            return jdbcTemplate.queryForObject("SELECT idDelegacion FROM delegacion WHERE idDelegacion = ?;",Integer.class,codigo);
        }
        catch(DataAccessException e){
            return -1;
        }
    }
     public int lastIdDelegacion(){
        int lastIdDelegacion = jdbcTemplate.queryForObject("SELECT idDelegacion FROM delegacion ORDER BY idDelegacion DESC LIMIT 1", Integer.class);
        return lastIdDelegacion;
    }
     
     public void volcarDatosXML (Delegaciones a) throws FileNotFoundException, JAXBException{
        InputStream inStream = new FileInputStream("Delegaciones.xml");
        JAXBContext context = JAXBContext.newInstance(Delegaciones.class); 
        Unmarshaller unmarshaller = context.createUnmarshaller(); 

        Delegaciones datosDelegacionesXML = (Delegaciones) unmarshaller.unmarshal(inStream);
        ArrayList<Delegacion> listaDelegacionesXML = datosDelegacionesXML.getDelegaciones();
        /*Recorremos arraylist de voluntariosInternacionales de unmarshaller y volcamos los de la primera BBDD en XML*/
        for(int i = 0; i<listaDelegacionesXML.size(); i++){

        jdbcTemplate.update(
        "INSERT INTO delegacion(cifOng,nombre,direccion,telefono) VALUES (?,?,?,?)", listaDelegacionesXML.get(i).getCifOng(),listaDelegacionesXML.get(i).getNombre(),listaDelegacionesXML.get(i).getDireccion(),listaDelegacionesXML.get(i).getTelefono());
        }
        
        System.out.println("El xml de delegaciones ha sido volcado con éxito");

     }
    
}
