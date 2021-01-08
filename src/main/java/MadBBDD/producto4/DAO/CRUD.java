/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.DAO;

import java.io.IOException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Sandra
 * @param <T>
 * @param <U>
 * @param <K>
 * @param <V>
 */
public interface CRUD<T,U,K,V> { /*T = clase que guardamos en el sistema, U = otra clase que guardamos en el sistema y K = tipo de datos de la clave primaria, V = tipo de dato modificable en BBDD*/
    void insertar(U a);
    void modificar(V a, V b, K c);
    void eliminar(K a); 
    U obtenerTodos(U a) throws JAXBException, IOException; 
}   