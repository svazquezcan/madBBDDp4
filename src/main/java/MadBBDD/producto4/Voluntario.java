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
@XmlRootElement(name="voluntario")
@XmlAccessorType (XmlAccessType.NONE)
public class Voluntario extends Personal {
    
    @XmlElement(name="dni")
    private String DNI; 

    
    /*Constructor para crear voluntario y asignarle un proyecto a la vez*/
    public Voluntario(int CodigoDePersonal, String tipoDePersonal, String nombre, String apellido, ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String delegacion, String DNI) {
        super(tipoDePersonal, nombre, apellido, listadoProyectos, usuario, contraseña, delegacion);
        this.DNI = DNI; 
    }
    
    /*Constructor para crear voluntario sin asignar proyecto*/
    public Voluntario(int CodigoDePersonal, String tipoDePersonal, String nombre, String apellido, String usuario, String contraseña, String delegacion, String DNI) {
        super(tipoDePersonal, nombre, apellido, usuario, contraseña, delegacion);
        this.DNI = DNI; 
    }
       
    /*Constructor sin args para JAXB*/
    public Voluntario(){
        
    }
    
   /**Getter
     * @return DNI*/   
    public String getDNI(){
        return this.DNI;
    }
   
       /**Setter
     * @param DNI, para añadir/modificar el DNI de Voluntario*/
    public void setDNI (String DNI){
        this.DNI = DNI; 
    } 
   
}
