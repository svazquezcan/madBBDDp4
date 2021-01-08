/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.XML;

import MadBBDD.producto4.DAO.VoluntarioInternacionalDAO;
import MadBBDD.producto4.VoluntarioInternacional;
import MadBBDD.producto4.VoluntariosInternacionales;
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
public class XmlVoluntarioInternacionalDAO implements VoluntarioInternacionalDAO{
    private JAXBContext context;
    private String nombreFichero;

    public XmlVoluntarioInternacionalDAO() throws JAXBException{
        
        this.context = JAXBContext.newInstance(VoluntariosInternacionales.class);
	this.nombreFichero = "VoluntariosInternacionales.xml";
        
    }

    @Override
    public void insertar(VoluntariosInternacionales a) {
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
    public VoluntariosInternacionales obtenerTodos(VoluntariosInternacionales voluntariosInternacionales) throws PropertyException, JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(voluntariosInternacionales, new FileWriter("VoluntariosInternacionales.xml"));
        System.out.println("El archivo VoluntariosInternacionales.xml ha sido creado correctamente ");
        return voluntariosInternacionales;
    }

}
