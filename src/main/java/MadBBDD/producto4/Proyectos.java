/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4;

import java.util.ArrayList;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="proyectos")
@XmlAccessorType (XmlAccessType.FIELD)

public class Proyectos {
    @XmlElement(name="proyecto")
    public ArrayList<Proyecto> proyectos;
    
      /*Getter*/
    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }
    
    /*Setter*/
    public void setProyectos (ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Marshaller createMarshaller() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
