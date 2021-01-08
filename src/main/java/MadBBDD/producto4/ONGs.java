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
@XmlRootElement(name="ONGs")
@XmlAccessorType (XmlAccessType.FIELD)

public class ONGs {
    @XmlElement(name="ONG")
    public ArrayList<ONG> ONGs;
    
    /*Getter*/
    public ArrayList<ONG> getONGs() {
        return ONGs;
    }
    
    /*Setter*/
    public void setONGs (ArrayList<ONG> ONGs) {
        this.ONGs = ONGs;
    }
}
