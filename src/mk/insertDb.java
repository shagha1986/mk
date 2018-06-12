/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk;

import entity.Tregister;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Shagayegh
 */
public class insertDb {

    static Session session = null;

    insertDb(Tregister r) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(r);
        t.commit();//transaction is committed  
        System.out.println("donecxcxcxcxcxcxc");
        session.close();
    }

}
