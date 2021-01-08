/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.XML;

import MadBBDD.producto4.DAO.ProyectoDAO;
import MadBBDD.producto4.Proyecto;
import MadBBDD.producto4.Proyectos;
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
public class XmlProyectoDAO implements ProyectoDAO{
    
    private JAXBContext context;
    private String nombreFichero;
    
    public XmlProyectoDAO() throws JAXBException{

        this.context = JAXBContext.newInstance(Proyectos.class);
        this.nombreFichero = "Proyectos.xml";
        
    }

        @Override
        public void insertar(Proyectos a) {
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
        public void obtenerTodos(Proyectos proyectos) throws PropertyException, JAXBException, IOException {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(proyectos, new FileWriter("Proyectos.xml"));
            System.out.println("El archivo Proyectos.xml ha sido creado correctamente ");

        }
    
}
    

