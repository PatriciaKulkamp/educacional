

package edu.manager;
import edu.to.Pessoa;
import edu.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PessoaManager {

    public List<Pessoa> listar(){
	 List<Pessoa> list = new ArrayList<Pessoa>();
	 Session session = HibernateUtil.openSession();
	 Transaction tran = null;	
	 try {
		 tran = session.getTransaction();
		 tran.begin();
		 list = session.createQuery("from Pessoa").list(); 
                 tran.commit();
	 } catch (Exception e) {
		 e.printStackTrace();
	 } finally {
                 session.flush();
		 session.close();
	 }
	 return list;
    }

    public boolean registrar(Pessoa pes){
	 Session session = HibernateUtil.openSession();	
	 Transaction tran = null;	
	 try {
		 tran = session.getTransaction();
		 tran.begin();                 
		 session.saveOrUpdate(pes);		
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
    
    public Pessoa buscarPorId(int id) {
        Pessoa pes = null;
        Transaction tran = null;
        Session session = HibernateUtil.openSession();
        try {
            tran = session.beginTransaction();
            String queryString = "from Pessoa where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            pes = (Pessoa) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return pes;
    }
   
    public boolean eliminar(int id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Pessoa pes = (Pessoa) session.load(Pessoa.class, new Integer(id));
            session.delete(pes);
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
