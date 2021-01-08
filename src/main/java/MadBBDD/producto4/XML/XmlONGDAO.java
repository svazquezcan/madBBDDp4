
package MadBBDD.producto4.XML;

import MadBBDD.producto4.DAO.ONGDAO;
import MadBBDD.producto4.ONG;
import MadBBDD.producto4.ONGs;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class XmlONGDAO implements ONGDAO{
    
    private JAXBContext context;
    private String nombreFichero;
    
    public XmlONGDAO() throws JAXBException{
    
        this.context = JAXBContext.newInstance(ONGs.class);
	this.nombreFichero = "ONGs.xml";
}

    @Override
    public void insertar(ONGs a) {
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
    public void obtenerTodos(ONGs ONGs) throws PropertyException, JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(ONGs, new FileWriter("ONGs.xml"));
        System.out.println("El archivo ONGs.xml ha sido creado correctamente ");

    }
    
}
    
    

