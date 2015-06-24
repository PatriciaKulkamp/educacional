

package edu.manager;

import edu.to.Nota;
import edu.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class NotaManager {

    public List<Nota> listar(){
	 List<Nota> list = new ArrayList<Nota>();
	 Session session = HibernateUtil.openSession();
	 Transaction tran = null;	
	 try {
		 tran = session.getTransaction();
		 tran.begin();
		 list = session.createQuery("from Nota").list(); 
                 tran.commit();
	 } catch (Exception e) {
		 e.printStackTrace();
	 } finally {
                 session.flush();
		 session.close();
	 }
	 return list;
    }

    public boolean registrar(Nota not){
	 Session session = HibernateUtil.openSession();	
	 Transaction tran = null;	
	 try {
		 tran = session.getTransaction();
		 tran.begin();                 
		 session.saveOrUpdate(not);		
		 tran.commit();                 
	 } catch(Exception e) {
		 if (tran!=null) {
                    tran.rollback();
		 }
                 e.printStackTrace();
	 } finally {
                session.flush();
		session.close();
	 }	
	 return true;
    }    
    
    public Nota buscarPorId(int id) {
        Nota not = null;
        Transaction tran = null;
        Session session = HibernateUtil.openSession();
        try {
            tran = session.beginTransaction();
            String queryString = "from Nota where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            not = (Nota) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return not;
    }
   
    public boolean eliminar(int id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Nota not = (Nota) session.load(Nota.class, new Integer(id));
            session.delete(not);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return true;
    }    

    public String registrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
