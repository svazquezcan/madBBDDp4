/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.XML;

import MadBBDD.producto4.DAO.DelegacionDAO;
import MadBBDD.producto4.utilidad.DataSourceJDBC;
import MadBBDD.producto4.Delegaciones;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Sandra
 */
public class XmlDelegacionDAO implements DelegacionDAO{
    
    private JAXBContext context;
    private String nombreFichero;
 
    public XmlDelegacionDAO() throws JAXBException{
    
        this.context = JAXBContext.newInstance(Delegaciones.class);
	this.nombreFichero = "Delegaciones.xml";

}

    @Override
    public void insertar(Delegaciones a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(String a, String b, Integer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obtenerTodos(Delegaciones delegaciones) throws PropertyException, JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(delegaciones, new FileWriter("Delegaciones.xml"));
        System.out.println("El archivo Delegaciones.xml ha sido creado correctamente ");

    }
    
}
