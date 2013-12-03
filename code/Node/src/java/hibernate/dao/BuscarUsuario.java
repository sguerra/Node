/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import hibernate.dto.HibernateUtil;
import hibernate.model.Habilidades;
import hibernate.model.Usuario;
import org.hibernate.Session;

/**
 *
 * @author NE56R07M
 */
public class BuscarUsuario {
    public String buscarUs(String usu){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Usuario u =(Usuario) session.get(Usuario.class, usu);
    
    return "habilidad"+u.getName();
    }
    
}
