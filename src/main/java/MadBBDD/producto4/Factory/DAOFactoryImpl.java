/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto4.Factory;

import MadBBDD.producto4.DAO.DAOFactory;
import MadBBDD.producto4.SQL.SQLDelegacionDAO;
import MadBBDD.producto4.SQL.SQLONGDAO;
import MadBBDD.producto4.SQL.SQLPersonalDAO;
import MadBBDD.producto4.SQL.SQLProyectoDAO;
import MadBBDD.producto4.XML.XmlContratadoDAO;
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
public class DAOFactoryImpl extends DAOFactory {

    @Override
    public XmlPersonalDAO getPersonalDAO() throws JAXBException {
        return new XmlPersonalDAO();        
    }

    @Override
    public XmlProyectoDAO getProyectosDAO() throws JAXBException {
        return new XmlProyectoDAO(); 
    }
        

    @Override
    public XmlDelegacionDAO getDelegacionesDAO() throws JAXBException {
        return new XmlDelegacionDAO();
    }

    @Override
    public XmlVoluntarioDAO getVoluntariosDAO() throws JAXBException {
        return new XmlVoluntarioDAO(); 
    }

    @Override
    public XmlVoluntarioInternacionalDAO getVoluntariosInternacionalesDAO() throws JAXBException {
        return new XmlVoluntarioInternacionalDAO(); 
    }

    @Override
    public XmlContratadoDAO getContratadosDAO() throws JAXBException {
        return new XmlContratadoDAO();
    }
    
    @Override
    public XmlONGDAO getONGsDAO() throws JAXBException {
        return new XmlONGDAO();
    }

    @Override
    public SQLPersonalDAO getPersonalDAOSQL() throws SQLException {
        return new SQLPersonalDAO(); 
    }

    @Override
    public SQLProyectoDAO getProyectosDAOSQL() throws SQLException {
        return new SQLProyectoDAO(); 
    }

    @Override
    public SQLDelegacionDAO getDelegacionesDAOSQL() throws SQLException {
        return new SQLDelegacionDAO(); 
    }

    @Override
    public SQLONGDAO getONGsDAOSQL() throws SQLException {
        return new SQLONGDAO(); 
    }

}
