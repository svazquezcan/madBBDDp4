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
@XmlRootElement(name="contratados")
@XmlAccessorType (XmlAccessType.FIELD)

public class Contratados {
    @XmlElement(name="contratado")
    public ArrayList<Contratado> contratados;
    
     /*Getter*/
    public ArrayList<Contratado> getContratados() {
        return contratados;
    }
    
    /*Setter*/
    public void setContratados(ArrayList<Contratado> contratados) {
        this.contratados = contratados;
    }
}

