package src.training2RelationshipsBetweenEntities;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Dao<T> {

    Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
    Transaction transaction = session.getTransaction();

    public void save(T element) {
        transaction.begin();
        try {
            session.save(element);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
