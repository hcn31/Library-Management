package ilisi.hibernate.biblio.model.dao.livre;

import java.util.List;
import java.util.Vector;
import ilisi.hibernate.biblio.model.bo.Exemplaire;
import ilisi.hibernate.biblio.model.bo.Livre;
import ilisi.hibernate.biblio.model.dao.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DAOLivre implements IDAOLivre {

    @Override
    public boolean create(Livre D) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(D);
            tx.commit();

            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;

        }

    }
    @Override
     public Vector<Livre> retreive() {
        
        List<Livre> livre = new  Vector<Livre>();
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getsessionFactory().getCurrentSession();
           tx=session.beginTransaction();       
            Query query = session.createQuery("from Livre");
            for(final Object o : query.list()) livre.add((Livre)o);
            for(Livre l:livre){
                for(Object o:l.getExemplaires()){
                    Exemplaire e= (Exemplaire )o;
                System.out.println(e.getIdexp());
                }
     }
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            System.out.println("error loading: "+e);
        }  
        
        return (Vector<Livre>)livre;  
               
    }

    @Override
    public boolean update(Livre L) {
         Transaction tx = null;
         String isbn=L.getIsbn(),titre=L.getTitre();
        try {
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            L=(Livre) session.load(Livre.class, isbn);
            L.setTitre(titre);
            tx.commit();

            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;

        }
    }
@Override
    public boolean delete(Livre L) {
         Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.delete(L);
            tx.commit();

            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;

        }
    }

    public Livre findByIsbn(String isbn){
        Livre livre =null;
        Transaction tx = null;
         try
         { 
            Session session = NewHibernateUtil.getsessionFactory().getCurrentSession();
            tx = session.beginTransaction();
         
            livre = (Livre) session.get(Livre.class, isbn);
            tx.commit();
            return livre;
         }
         catch(Exception e)
         {
            tx.rollback();
            return null;
         }
    }

}
