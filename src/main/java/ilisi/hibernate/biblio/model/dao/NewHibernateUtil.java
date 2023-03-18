 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Hibernate/HibernateUtil.java to edit this template
 */
package ilisi.hibernate.biblio.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class NewHibernateUtil {

   public static SessionFactory sessionFactory;

	public static SessionFactory getsessionFactory()
	{
		if(sessionFactory==null)
		{
			try { 
				 Configuration config = new Configuration();	
					config.configure(); 
					sessionFactory = config.buildSessionFactory(); 
				System.out.println("good");
			}
			catch(HibernateException e){System.out.println(e.getMessage());sessionFactory=null;}
		}
		
		return sessionFactory;
	}

}

// Create the SessionFactory from standard (hibernate.cfg.xml) 
// config file.
//  sessionFactory = new AnnotationConfiguration().configure("ma/fstm/ilisi/hrcorp/model/dao/hibernate.cfg.xml").buildSessionFactory();

