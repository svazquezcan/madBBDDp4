/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.DAO;

import MadBBDD.producto4.SQL.SQLDelegacionDAO;
import MadBBDD.producto4.SQL.SQLONGDAO;
import MadBBDD.producto4.SQL.SQLPersonalDAO;
import MadBBDD.producto4.SQL.SQLProyectoDAO;
import MadBBDD.producto4.XML.XmlContratadoDAO;
import MadBBDD.producto4.Factory.DAOFactoryImpl;
import MadBBDD.producto4.XML.XmlDelegacionDAO;
import MadBBDD.producto4.XML.XmlONGDAO;
import MadBBDD.producto4.XML.XmlPersonalDAO;
import MadBBDD.producto4.XML.XmlProyectoDAO;
import MadBBDD.producto4.XML.XmlVoluntarioDAO;
import MadBBDD.producto4.XML.XmlVoluntarioInternacionalDAO;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Sandra
 */
   public abstract class DAOFactory {

	public abstract XmlPersonalDAO getPersonalDAO() throws JAXBException;
	public abstract XmlProyectoDAO getProyectosDAO() throws JAXBException;
	public abstract XmlDelegacionDAO getDelegacionesDAO() throws JAXBException;
        public abstract XmlVoluntarioDAO getVoluntariosDAO() throws JAXBException;
        public abstract XmlVoluntarioInternacionalDAO getVoluntariosInternacionalesDAO() throws JAXBException;
        public abstract XmlContratadoDAO getContratadosDAO() throws JAXBException;
        public abstract XmlONGDAO getONGsDAO() throws JAXBException;
        
        public abstract SQLPersonalDAO getPersonalDAOSQL() throws SQLException; 
        public abstract SQLProyectoDAO getProyectosDAOSQL() throws SQLException; 
        public abstract SQLDelegacionDAO getDelegacionesDAOSQL() throws SQLException;
        public abstract SQLONGDAO getONGsDAOSQL() throws SQLException;

	public static DAOFactory getDAOFactory() {
            return new DAOFactoryImpl();
	}

} 
