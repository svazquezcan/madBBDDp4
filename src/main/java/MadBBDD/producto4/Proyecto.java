/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="proyecto")
@XmlAccessorType (XmlAccessType.NONE)

public class Proyecto {
    private static AtomicInteger codigoDeProyectoCount;
    @XmlElement (name="codigoDeProyecto")
    private int codigoDeProyecto; 
    @XmlElement (name="cifOng")
    private String cifOng;
    @XmlElement (name="pais")
    private String pais; 
    @XmlElement (name="localizacion")
    private String localizacion; 
    @XmlElement (name="lineaDeAccion")
    private String lineaDeAccion; 
    @XmlElement (name="sublineaDeAccion")
    private String sublineaDeAccion;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate fechaDeInicio; 
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate fechaDeFinalizacion;
    @XmlElement (name="socioLocal")
    private String socioLocal; 
    @XmlElement (name="financiador")
    private String financiador; 
    @XmlElement (name="financiacionAportada")
    private float financiacionAportada;
    @XmlElement (name="costeProyecto")
    private float costeProyecto;
    @XmlElement (name="accionesARealizar")
    private String accionesARealizar; 
    private ArrayList<Personal> personalAsignado; 
    
    /**Constructor
     * @param pais
     * @param localizacion
     * @param lineaDeAccion
     * @param sublineaDeAccion
     * @param fechaDeInicio
     * @param fechaDeFinalizacion
     * @param socioLocal
     * @param financiador
     * @param financiacionAportada
     * @param accionesARealizar
     * @param costeProyecto
     * @param cifOng
     */
    
    public Proyecto(String pais, String localizacion, String lineaDeAccion, String sublineaDeAccion, LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion, String socioLocal, String financiador, float financiacionAportada, float costeProyecto, String accionesARealizar, String cifOng){
        this.codigoDeProyecto = codigoDeProyectoCount.getAndIncrement(); 
        this.pais = pais; 
        this.localizacion = localizacion; 
        this.lineaDeAccion = lineaDeAccion; 
        this.sublineaDeAccion = sublineaDeAccion; 
        this.fechaDeInicio = fechaDeInicio; 
        this.fechaDeFinalizacion = fechaDeFinalizacion; 
        this.socioLocal = socioLocal; 
        this.financiador = financiador; 
        this.financiacionAportada = financiacionAportada; 
        this.accionesARealizar = accionesARealizar; 
        this.cifOng = cifOng;
    }
    
    /*constructor sin argumentos*/
    public Proyecto(){ 
    }
    
    /**Getter
     * @return pais*/
    public String getPais(){
        return this.pais;
    }
    
        /**Getter
     * @return localizacion*/
    public String getLocalizacion(){
        return this.localizacion;
    }
    
        /**Getter
     * @return lineaDeAccion*/
    public String getLineaDeAccion(){
        return this.lineaDeAccion;
    }
    
        /**Getter
     * @return sublineaDeAccion*/
    public String getSublineaDeAccion(){
        return this.sublineaDeAccion;
    }
    
        /**Getter
     * @return fechaDeInicio*/
    public LocalDate getFechaDeInicio(){
        return this.fechaDeInicio;
    }
    
        /**Getter
     * @return fechaDeFinalizacion*/
    public LocalDate getFechaDeFinalizacion(){
        return this.fechaDeFinalizacion;
    }
    
        /**Getter
     * @return socioLocal*/
    public String getSocioLocal(){
        return this.socioLocal;
    }
    
        /**Getter
     * @return financiador*/
    public String getFinanciador(){
        return this.financiador;
    }
    
        /**Getter
     * @return financiacionAportada*/
    public float getFinanciacionAportada(){
        return this.financiacionAportada;
    }
    
     /**Getter
     * @return costeProyecto*/
    public float getCosteProyecto(){
        return this.costeProyecto;
    }
    
        /**Getter
     * @return codigoDeProyecto*/
    public int getCodigoDeProyecto(){
        return this.codigoDeProyecto;
    }
    
        /**Getter
     * @return accionesARealizar*/
    public String getAccionesARealizar(){
        return this.accionesARealizar;
    }
    
        /**Getter
     * @return personalAsignado*/
    public  ArrayList<Personal> getPersonalAsignado(){
        return this.personalAsignado;
    }
    
       /**Getter
     * @return cifOng*/
    public String getCifOng(){
        return this.cifOng;
    }
    
    
    
      /**Setter
     * @param pais, para añadir/modificar el pais de Proyecto*/
    public void setPais(String pais){
        this.pais = pais; 
    }  
    
     /**Setter
     * @param localizacion, para añadir/modificar la localización de Proyecto*/
    public void setLocalizacion(String localizacion){
        this.localizacion = localizacion; 
    } 
    
     /**Setter
     * @param lineaDeAccion, para añadir/modificar la lineaDeAccion de Proyecto*/
    public void setLineaDeAccion(String lineaDeAccion){
        this.lineaDeAccion = lineaDeAccion; 
    } 
    
     /**Setter
     * @param sublineaDeAccion, para añadir/modificar la sublineaDeAccion de Proyecto*/
    public void setSublineaDeAccion(String sublineaDeAccion){
        this.sublineaDeAccion = sublineaDeAccion; 
    } 
    
     /**Setter
     * @param fechaDeInicio, para añadir/modificar la fechaDeInicio de Proyecto*/
    public void setFechaDeInicio(LocalDate fechaDeInicio){
        this.fechaDeInicio = fechaDeInicio; 
    } 
    
     /**Setter
     * @param fechaDeFinalizacion, para añadir/modificar la FechaDeFinalizacion de Proyecto*/
    public void setFechaDeFinalizacion(LocalDate fechaDeFinalizacion){
        this.fechaDeFinalizacion = fechaDeFinalizacion; 
    } 
    
     /**Setter
     * @param socioLocal, para añadir/modificar el socioLocal de Proyecto*/
    public void setSocioLocal(String socioLocal){
        this.socioLocal = socioLocal; 
    } 
    
     /**Setter
     * @param financiador, para añadir/modificar el financiador de Proyecto*/
    public void setFinanciador(String financiador){
        this.financiador = financiador; 
    } 
    
     /**Setter
     * @param financiacionAportada, para añadir/modificar la financiacionAportada de Proyecto*/
    public void setFinanciacionAportada(float financiacionAportada){
        this.financiacionAportada = financiacionAportada; 
    } 
    
     /**Setter
     * @param costeProyecto, para añadir/modificar el costeProyecto de Proyecto*/
    public void setCosteProyecto(float costeProyecto){
        this.costeProyecto = costeProyecto; 
    } 
    
     /**Setter
     * @param codigoDeProyecto, para añadir/modificar el codigoDeProyecto de Proyecto*/
    public void setCodigoDeProyecto(int codigoDeProyecto){
        this.codigoDeProyecto = codigoDeProyecto; 
    } 
    
     /**Setter
     * @param accionesARealizar, para añadir/modificar las accionesARealizar de Proyecto*/
    public void setAccionesARealizar(String accionesARealizar){
        this.accionesARealizar = accionesARealizar; 
    } 
    
     /**Setter
     * @param cifOng, para añadir/modificar cifOng de Proyecto*/
    public void setCifOng(String cifOng){
        this.cifOng = cifOng; 
    } 
    
    /**Funcion para comprobar proyectos sin asignar
     * @return boolean*/
    
    public boolean isAssigned(){
        
        boolean isAssigned = true; 
        ArrayList<Personal> busyProjects = new ArrayList<Personal>(); 
        busyProjects = this.getPersonalAsignado();
             
         if (busyProjects == null){
            isAssigned = false; 
        }      
         
         else if (busyProjects.isEmpty()){
            isAssigned = false; 
         }
          
        return isAssigned;
            
    } 
    
        public static void inicializarAutoincrement(int num){
        codigoDeProyectoCount = new AtomicInteger(num++);
    }
  
}
