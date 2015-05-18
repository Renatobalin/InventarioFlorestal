/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.swinghibernate.config;

import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author renato
 */
public class HibernateUtil {

    private static SessionFactory session;

    static {

        Object[] opcoes = {"Postgres","Mysql"};
        Object res = showInputDialog(null, "Escolha o banco de dados", "Selecione o banco de dados", JOptionPane.PLAIN_MESSAGE, null, opcoes, "");

        if (res == "Mysql") {
            try {
                Configuration configMysql = (new Configuration()).configure("br/com/swinghibernate/config/hibernateMysql.cfg.xml");
                org.hibernate.service.ServiceRegistry serviceRegistrMysql = (new ServiceRegistryBuilder()).applySettings(configMysql.getProperties()).buildServiceRegistry();
                session = configMysql.buildSessionFactory(serviceRegistrMysql);
            } catch (HibernateException ex) {
                throw new ExceptionInInitializerError(ex);
            }
        } else {
            try {
                Configuration configPostgres = (new Configuration()).configure("br/com/swinghibernate/config/hibernatePostgres.cfg.xml");
                org.hibernate.service.ServiceRegistry serviceRegistryPostgres = (new ServiceRegistryBuilder()).applySettings(configPostgres.getProperties()).buildServiceRegistry();
                session = configPostgres.buildSessionFactory(serviceRegistryPostgres);
            } catch (HibernateException ex) {
                throw new ExceptionInInitializerError(ex);
            }
        } 
    }

    /**
     *
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return session;
    }

    private HibernateUtil() {
    }
    private static final Logger LOG = Logger.getLogger(HibernateUtil.class.getName());
}
