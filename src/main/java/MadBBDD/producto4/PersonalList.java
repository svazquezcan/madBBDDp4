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
@XmlRootElement(name="personalList")
@XmlAccessorType (XmlAccessType.FIELD)

public class PersonalList {
    @XmlElement(name="personal")
    public ArrayList<Personal> personalList;
    
    /*Getter*/
    public ArrayList<Personal> getPersonalList() {
        return personalList;
    }
    
    /*Setter*/
    public void setPersonal(ArrayList<Personal> personalList) {
        this.personalList = personalList;
    }

}