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
@XmlRootElement(name="voluntariointernacional")
@XmlAccessorType (XmlAccessType.NONE)

public class VoluntarioInternacional extends Personal {
    @XmlElement(name="nie")
    private String NIE; 
    
    /*Constructor para asignar proyectos al crear VoluntarioInternacional*/
    public VoluntarioInternacional(String tipoDePersonal, String nombre, String apellido, ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String delegacion, String NIE) {
        super(tipoDePersonal, nombre, apellido, listadoProyectos, usuario, contraseña, delegacion);
        this.NIE = NIE; 
    }
    
     /*Constructor para crear VoluntarioInternacional sin asignar proyecto*/
     public VoluntarioInternacional(String tipoDePersonal, String nombre, String apellido, String usuario, String contraseña, String delegacion, String NIE) {
        super(tipoDePersonal, nombre, apellido, usuario, contraseña, delegacion);
        this.NIE = NIE; 
    }
         
    /*Constructor sin args para JABX*/
     public VoluntarioInternacional(){
         
     }
    
     /**Getter
     * @return NIE*/
    public String getNIE(){
        return this.NIE;
    }
    
       /**Setter
     * @param NIE, para añadir/modificar el NIE de VoluntarioInternacional*/
    public void setNIE (String NIE){
        this.NIE = NIE; 
    } 
   
    
}
