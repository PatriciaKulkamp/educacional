

package edu.manager;
import edu.to.Matricula;
import edu.to.Pessoa;
import edu.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class MatriculaManager {

    public List<Matricula> listar(){
	 List<Matricula> list = new ArrayList<Matricula>();
	 Session session = HibernateUtil.openSession();
	 Transaction tran = null;	
	 try {
		 tran = session.getTransaction();
		 tran.begin();
		 list = session.createQuery("from Matricula").list(); 
                 tran.commit();
	 } catch (Exception e) {
		 e.printStackTrace();
	 } finally {
                 session.flush();
		 session.close();
	 }
	 return list;
    }

    public boolean registrar(Matricula mat){
	 Session session = HibernateUtil.openSession();	
	 Transaction tran = null;	
	 try {
		 tran = session.getTransaction();
		 tran.begin();                 
		 session.saveOrUpdate(mat);		
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
    
    public Matricula buscarPorId(int id) {
        Matricula mat = null;
        Transaction tran = null;
        Session session = HibernateUtil.openSession();
        try {
            tran = session.beginTransaction();
            String queryString = "from Matricula where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            mat = (Matricula) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return mat;
    }
   
    public boolean eliminar(int id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Matricula mat = (Matricula) session.load(Matricula.class, new Integer(id));
            session.delete(mat);
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
