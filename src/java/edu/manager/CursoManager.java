/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.manager;

import edu.to.Curso;
import edu.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pati
 */
public class CursoManager {
    public List<Curso> listar(){
	 List<Curso> list = new ArrayList<Curso>();
	 Session session = HibernateUtil.openSession();
	 Transaction tran = null;	
	 try {
		 tran = session.getTransaction();
		 tran.begin();
		 list = session.createQuery("from Curso").list(); 
                 tran.commit();
	 } catch (Exception e) {
		 e.printStackTrace();
	 } finally {
                 session.flush();
		 session.close();
	 }
	 return list;
    }

    public boolean registrar(Curso cur){
	 Session session = HibernateUtil.openSession();	
	 Transaction tran = null;	
	 try {
		 tran = session.getTransaction();
		 tran.begin();                 
		 session.saveOrUpdate(cur);		
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
    
    public Curso buscarPorId(int id) {
        Curso cur = null;
        Transaction tran = null;
        Session session = HibernateUtil.openSession();
        try {
            tran = session.beginTransaction();
            String queryString = "from Curso where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            cur = (Curso) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return cur;
    }
   
    public boolean eliminar(int id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Curso cur = (Curso) session.load(Curso.class, new Integer(id));
            session.delete(cur);
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
