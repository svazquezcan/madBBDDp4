/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.XML;

import MadBBDD.producto4.DAO.VoluntarioDAO;
import MadBBDD.producto4.Voluntario;
import MadBBDD.producto4.Voluntarios;
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
public class XmlVoluntarioDAO implements VoluntarioDAO {

    private JAXBContext context;
    private String nombreFichero;

    public XmlVoluntarioDAO() throws JAXBException{
        
        this.context = JAXBContext.newInstance(Voluntarios.class);
	this.nombreFichero = "Voluntarios.xml";
        
    }
    @Override
    public void insertar(Voluntarios a) {
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
    public void obtenerTodos(Voluntarios voluntarios) throws PropertyException, JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(voluntarios, new FileWriter("Voluntarios.xml"));
        System.out.println("El archivo Voluntarios.xml ha sido creado correctamente ");
    }

}
