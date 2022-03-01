package ru.job4j.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class HqlRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

//            Candidate candidate1 = new Candidate("Egor", 3, 250000);
//            Candidate candidate2 = new Candidate("Vika", 1, 100000);
//            Candidate candidate3 = new Candidate("Max", 7, 300000);
//
//            session.save(candidate1);
//            session.save(candidate2);
//            session.save(candidate3);

//            Query query = session.createQuery("from Candidate");
//            for (Object st : query.list()) {
//                System.out.println(st);
//            }

//            Query query = session.createQuery("from Candidate s where s.id = 2");
//            System.out.println(query.uniqueResult());

//            Query query = session.createQuery("from Candidate c where c.id = :fId");
//            query.setParameter("fId", 1);
//            System.out.println(query.uniqueResult());

//            Query query = session.createQuery("from Candidate c where c.name = :fName");
//            query.setParameter("fName", "Vika");
//            System.out.println(query.uniqueResult());

//            session.createQuery("update Candidate c set c.experience = :newExperience, c.salary = :newSalary where c.id = :fId")
//                    .setParameter("newExperience", 5)
//                    .setParameter("newSalary", 200000)
//                    .setParameter("fId", 3)
//                    .executeUpdate();
//            Query query = session.createQuery("from Candidate s where s.id = 3");
//            System.out.println(query.uniqueResult());

            session.createQuery("delete from Candidate where id = :fId")
                    .setParameter("fId", 3)
                    .executeUpdate();
            Query query = session.createQuery("from Candidate ");
            for (Object st : query.list()) {
                System.out.println(st);
            }

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
