/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="voluntariosInternacionales")
@XmlAccessorType (XmlAccessType.NONE)

public class VoluntariosInternacionales {
    @XmlElement(name="voluntarioInternacional")
    public ArrayList<VoluntarioInternacional> voluntariosInternacionales;
    
     /*Getter*/
    public ArrayList<VoluntarioInternacional> getVoluntariosInternacionales() {
        return voluntariosInternacionales;
    }
    
    /*Setter*/
    public void setVoluntarios (ArrayList<VoluntarioInternacional> voluntariosInternacionales) {
        this.voluntariosInternacionales = voluntariosInternacionales;
    }
}
