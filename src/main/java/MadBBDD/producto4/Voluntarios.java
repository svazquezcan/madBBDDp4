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
@XmlRootElement(name="voluntarios")
@XmlAccessorType (XmlAccessType.FIELD)

public class Voluntarios {
    @XmlElement(name="voluntario")
    public ArrayList<Voluntario> voluntarios;
    
    /*Getter*/
    public ArrayList<Voluntario> getVoluntarios() {
        return voluntarios;
    }
    
    /*Setter*/
    public void setVoluntarios (ArrayList<Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }
}
