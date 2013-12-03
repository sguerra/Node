/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import hibernate.dto.HibernateUtil;
import hibernate.model.Habilidades;
import hibernate.model.Usuario;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author NE56R07M
 */
public class BuscarHabilidad {
    
    public String buscarHabi(String hab){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Usuario u =(Usuario) session.get(Usuario.class, hab);
    Habilidades h = (Habilidades) session.get(Habilidades.class, hab);
    return "habilidad"+h.getNombre();

            }
}
    
