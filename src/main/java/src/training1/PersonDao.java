package src.training1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDao {

    public Person get(Long id) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

//    public void save() {
//        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
//        Transaction transaction = session.getTransaction();
//        transaction.begin();
//        try {
//            session.save(new Person( "Jan", "Kowalski",AgeIdPerson.OLD_4, LocalDate.of(1945,11,01)));
//            session.save(new Person( "Jan", "Kowalski",AgeIdPerson.CHILD_1, LocalDate.of(2019,01,22)));
//            session.save(new Person( "Ala", "Kowalski",AgeIdPerson.BABY_0, LocalDate.of(2020,05,25)));
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//            e.printStackTrace();
//        }
//        session.close();
//    }

    public void save(Person person) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void update(Long id, Person newPerson) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            Person person = session.get(Person.class, id);
            person.setName(newPerson.getName());
            person.setSurname(newPerson.getSurname());
            person.setAgeIdPerson(newPerson.getAgeIdPerson());
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void delete(Long id) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            Person person = session.get(Person.class, id);
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }
}
