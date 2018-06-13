package mk;

/**
 *
 * @author Shagayegh
 */
import entity.Tregister;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




public class fetchData {
       static Session session = null;

    private String Dusername, Dpass;

    fetchData() {
       session = HibernateUtil.getSessionFactory().openSession();
           
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("select e.username, e.password from Tregister as e");
        java.util.List ql = query.list();
     
       
//        session.save(r);
        t.commit();//transaction is committed  
        System.out.println("donecxcxcxcxcxcxc");
        session.close();

    }
}
