/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.SQL;

import MadBBDD.producto4.DAO.ProyectoDAO;
import MadBBDD.producto4.utilidad.DataSourceJDBC;
import MadBBDD.producto4.Proyecto;
import MadBBDD.producto4.Proyectos;
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


public class SQLProyectoDAO implements ProyectoDAO {
    
    private DataSourceJDBC mySqlDataSource = new DataSourceJDBC();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());
    
    public SQLProyectoDAO() throws SQLException {
        this.mySqlDataSource = mySqlDataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void insertar(Proyectos a) {      
        try {  
            ArrayList<Proyecto> proyectos = a.getProyectos();
                for(int i = 0; i<proyectos.size(); i++){
                    jdbcTemplate.update(
                    "INSERT INTO proyecto(cifOng,pais,localizacion,lineaDeAccion,sublineaDeAccion,fechaDeInicio,fechadeFinalizacion,socioLocal,financiador,financiacionAportada,costeProyecto,accionesARealizar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",proyectos.get(i).getCifOng(),proyectos.get(i).getPais(),proyectos.get(i).getLocalizacion(),proyectos.get(i).getLineaDeAccion(), proyectos.get(i).getSublineaDeAccion(),proyectos.get(i).getFechaDeInicio(),proyectos.get(i).getFechaDeFinalizacion(),proyectos.get(i).getSocioLocal(),proyectos.get(i).getFinanciador(),proyectos.get(i).getFinanciacionAportada(),proyectos.get(i).getCosteProyecto(),proyectos.get(i).getAccionesARealizar());
                    System.out.println("El proyecto con id " + proyectos.get(i).getCodigoDeProyecto()+ " ha sido creado.");
               }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("DataIntegrityViolationException");
         
        }
    }
    

    @Override
    public void modificar(String a, String b, Integer c) {
        String sql = "UPDATE proyecto SET ";
        String sqlUpdate = sql.concat(a);
        String sqlLast = sqlUpdate + " = ? WHERE codigoDeProyecto = ?";
        jdbcTemplate.update(sqlLast,b,c);
        System.out.println("El atributo " + a + " del proyecto con id " + c + " pasa a ser ahora " + b);
    }

    @Override
    public void eliminar(Integer a) {
        jdbcTemplate.update(
        "DELETE FROM proyecto WHERE codigoDeProyecto = ?;",a);
        System.out.println("El proyecto con id " + a + " ha sido eliminado con éxito");

    }  

    @Override
    public Proyectos obtenerTodos(Proyectos a) throws JAXBException, IOException {
        List<Map<String,Object>> rows = (List<Map<String,Object>>)
        jdbcTemplate.queryForList("SELECT * FROM proyecto"); 
        rows.forEach(System.out::println);
        return a;
    } 
    
    public int lastidProyecto(){
        int lastidProyecto = jdbcTemplate.queryForObject("SELECT codigoDeProyecto FROM proyecto ORDER BY codigoDeProyecto DESC LIMIT 1", Integer.class);
        return lastidProyecto;
    }
    
    public void volcarDatosXML (Proyectos a) throws FileNotFoundException, JAXBException{
        InputStream inStream = new FileInputStream("Proyectos.xml");
        JAXBContext context = JAXBContext.newInstance(Proyectos.class); 
        Unmarshaller unmarshaller = context.createUnmarshaller(); 

        Proyectos datosProyectosXML = (Proyectos) unmarshaller.unmarshal(inStream);
        ArrayList<Proyecto> listaDeProyectosXML = datosProyectosXML.getProyectos();
        for(int i = 0; i<listaDeProyectosXML.size(); i++){

        jdbcTemplate.update(
            "INSERT INTO proyecto(cifOng,pais,localizacion,lineaDeAccion,sublineaDeAccion,fechaDeInicio,fechadeFinalizacion,socioLocal,financiador,financiacionAportada,costeProyecto,accionesARealizar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",listaDeProyectosXML.get(i).getCifOng(),listaDeProyectosXML.get(i).getPais(),listaDeProyectosXML.get(i).getLocalizacion(),listaDeProyectosXML.get(i).getLineaDeAccion(), listaDeProyectosXML.get(i).getSublineaDeAccion(),listaDeProyectosXML.get(i).getFechaDeInicio(),listaDeProyectosXML.get(i).getFechaDeFinalizacion(),listaDeProyectosXML.get(i).getSocioLocal(),listaDeProyectosXML.get(i).getFinanciador(),listaDeProyectosXML.get(i).getFinanciacionAportada(),listaDeProyectosXML.get(i).getCosteProyecto(),listaDeProyectosXML.get(i).getAccionesARealizar());
        }
        
        System.out.println("El xml de proyectos ha sido volcado con éxito");

     }
   

    
}