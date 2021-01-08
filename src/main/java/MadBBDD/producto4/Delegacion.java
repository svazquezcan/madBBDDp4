/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="delegacion")
@XmlAccessorType (XmlAccessType.NONE)
public class Delegacion {
    private static AtomicInteger idDelegacionCount;
    @XmlElement(name="idDelegacion")
    private int idDelegacion;
    @XmlElement(name="nombre")
    private String nombre; 
    @XmlElement(name="direccion")
    private String direccion; 
    @XmlElement(name="telefono")
    private String telefono; 
    @XmlElement(name="cifOng")
    private String cifOng;
    private ArrayList<Personal> listaDePersonal;
    
    /**Constructor
     * @param nombre
     * @param direccion
     * @param telefono
     * @param cifOng*/
    
    /*Recordar que si creamos delegaciones hay que modificar método EntrarDatosPersonal() en clase ONG para que permita entrar personal en la nueva delegación*/
    public Delegacion(String nombre, String direccion, String telefono, String cifOng){
    this.idDelegacion = idDelegacionCount.getAndIncrement();
    this.nombre = nombre; 
    this.direccion = direccion; 
    this.telefono = telefono; 
    this.cifOng = cifOng;
    
    }
    
    /*Constructor sin argumentos para JAXB*/
    public Delegacion(int idDelegacion){
        this.idDelegacion = idDelegacionCount.getAndIncrement();
    }
    
    /*Constructor sin argumentos para JAXB*/
    public Delegacion(){
        this.idDelegacion = idDelegacionCount.getAndIncrement();
    }
    
    /**Getter
     * @return idDelegacion*/
    public int getIdDelegacion(){
        return this.idDelegacion;
    }
    
     /**Getter
     * @return nombre*/
    public String getNombre(){
        return this.nombre;
    }
    
     /**Getter
     * @return direccion*/
    public String getDireccion(){
        return this.direccion;
    }
    
     /**Getter
     * @return telefono*/
    public String getTelefono(){
        return this.telefono;
    }
    
     /**Getter
     * @return listaDePersonal*/
    public ArrayList<Personal> getListaDePersonal(){
        return this.listaDePersonal;
    }
    
     /**Getter
     * @return cifOng*/
    public String getCifOng(){
        return this.cifOng;
    }
    
     /**Setter
     * @param idDelegacion*/
    public void setIdDelegacion(int idDelegacion) {
        this.idDelegacion = idDelegacion;
    }
    
    
    /**Setter
     * @param nombre*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**Setter
     * @param direccion*/
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**Setter
     * @param telefono*/
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**Setter
     * @param listaDePersonal*/
    public void setListaDePersonal(ArrayList<Personal> listaDePersonal) {
        this.listaDePersonal = listaDePersonal;
    }
    
    /**Setter
     * @param cifOng*/
    public void setCifOng(String cifOng) {
        this.cifOng = cifOng;
    }
    
    public static void inicializarAutoincrement(int num){
        idDelegacionCount = new AtomicInteger(num++);
    }
    
}
