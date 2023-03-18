/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilisi.hibernate.biblio.model.dao.emprunt;


import ilisi.hibernate.biblio.model.dao.adherant.DAOAdherant;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import ilisi.hibernate.biblio.model.bo.Emprunt;
import ilisi.hibernate.biblio.model.dao.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author S USER
 */
public class DAOEmprunt {
    public boolean create( Emprunt Em) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
         //   session.clear();
            tx = session.beginTransaction();
            session.save(Em);
            tx.commit();

            return true;
        } catch (HibernateException e) {
            tx.rollback();
            System.out.println(e);
            return false;

        }
    }
 public boolean delete( Emprunt Em) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
         //   session.clear();
            tx = session.beginTransaction();
            session.delete(Em);
            tx.commit();

            return true;
        } catch (HibernateException e) {
            tx.rollback();
            System.out.println(e);
            return false;

        }
    }
    public boolean update(Emprunt em) {
         Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.update(em);
          
            tx.commit();
       
            return true;
        } catch (HibernateException e) {
            tx.rollback();
            return false;

        }
    }

    public Collection<Emprunt> retreive() {
        List<Emprunt> ads = new  Vector<Emprunt>();
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getsessionFactory().getCurrentSession();
           tx=session.beginTransaction();       
            Query query = session.createQuery("select e from Emprunt e where e.retourne=0");
            for(final Object o : query.list()) ads.add((Emprunt)o);
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            System.out.println("error loading emprunts: "+e);
        }  
        return (Vector<Emprunt>)ads;  
    }
   //TODO needs to be changed 
    public Emprunt findById(String idem) {
        Transaction tx = null;
        DAOAdherant daoA=new DAOAdherant();
      //  DAOExemplaire daoE=new DAOExemplaire();
        Emprunt em;
       // System.out.println(date);
       // Date d=new SimpleDateFormat("yyyy-MM-dd").parse(date);
                 try
         { 
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            em = (Emprunt) session.get(Emprunt.class, idem);
            tx.commit();
            return em;
         }
         catch(HibernateException e)
         {
            tx.rollback();
            return null;
         }
    }
    
}
