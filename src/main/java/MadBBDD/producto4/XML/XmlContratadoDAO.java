/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.XML;

import MadBBDD.producto4.Contratado;
import MadBBDD.producto4.Contratados;
import MadBBDD.producto4.DAO.ContratadoDAO;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/**
 *
 * @author Sandra
 */
public class XmlContratadoDAO implements ContratadoDAO {
    private JAXBContext context;
    private String nombreFichero;

    public XmlContratadoDAO() throws JAXBException{
        
        this.context = JAXBContext.newInstance(Contratados.class);
	this.nombreFichero = "Contratados.xml";
        
    }
    @Override
    public void insertar(Contratados a) {
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
    public Contratados obtenerTodos(Contratados contratados) throws PropertyException, JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(contratados, new FileWriter("Contratados.xml"));
        System.out.println("El archivo Contratados.xml ha sido creado correctamente ");
        return null;
    }
    
}
