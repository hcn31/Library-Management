/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilisi.hibernate.biblio.model.dao.adherant;

import java.util.Collection;
import java.util.List;
import java.util.Vector;
import ilisi.hibernate.biblio.model.bo.Adherant;
import ilisi.hibernate.biblio.model.bo.Livre;
import ilisi.hibernate.biblio.model.dao.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOAdherant implements IDAOAdherant{

    @Override
    public boolean create(Adherant A) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
         //   session.clear();
            tx = session.beginTransaction();
            session.save(A);
            tx.commit();

            return true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e);
            return false;

        }
    }

    @Override
    public boolean update(Adherant ads) {
         Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(ads);
            tx.commit();
         //  session.clear();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;

        }
    }

    @Override
    public boolean delete(Adherant L) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.delete(L);
            tx.commit();
          // session.clear();

            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;

        }    }
    
    @Override
    public Collection<Adherant> retreive() {
        List<Adherant> ads = new  Vector<Adherant>();
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getsessionFactory().getCurrentSession();
           tx=session.beginTransaction();       
            Query query = session.createQuery("from Adherant");
            for(final Object o : query.list()) ads.add((Adherant)o);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            System.out.println("error loading");
        }  
        return (Vector<Adherant>)ads;  
    }

    public Adherant findByCin(String cin){
        Adherant ads =null;
        Transaction tx = null;
         try
         { 
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            ads = (Adherant) session.get(Adherant.class, cin);
            tx.commit();
            return ads;
         }
         catch(Exception e)
         {
            tx.rollback();
            return null;
         }
    }
}
