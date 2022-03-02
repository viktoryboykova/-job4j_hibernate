package ru.job4j.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmRun {
    public static void main(String[] args) {
        Student rsl = null;

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

//            Student one = Student.of("Alex", 21, "Moscow");
//            Student two = Student.of("Nikolay", 28, "Saint-Petersburg");
//            Student three = Student.of("Nikita", 25, "Kaliningrad");
//
//            session.save(one);
//            session.save(two);
//            session.save(three);

//            Query query = session.createQuery("from ru.job4j.hql.Student");
//            for (Object st : query.list()) {
//                System.out.println(st);
//            }
//
//            Query query2 = session.createQuery("from Student s where s.id = 1");
//            System.out.println(query2.uniqueResult());
//
//            Query query3 = session.createQuery("from Student s where s.id = :fId");
//            query3.setParameter("fId", 1);
//            System.out.println(query3.uniqueResult());
//
//            session.createQuery("update Student s set s.age = :newAge, s.city = :newCity where s.id = :fId")
//                    .setParameter("newAge", 22)
//                    .setParameter("newCity", "London")
//                    .setParameter("fId", 1)
//                    .executeUpdate();
//
//            session.createQuery("delete from Student where id = :fId")
//                    .setParameter("fId", 3)
//                    .executeUpdate();

//            FetchBook book1 = FetchBook.of("Двенадцать стульев", "АСТ");
//            FetchBook book2 = FetchBook.of("Одноэтажная америка", "Текст");
//            session.save(book1);
//            session.save(book2);
//            Account account = Account.of("root");
//            account.addBook(book1);
//            account.addBook(book2);
//            session.save(account);
//            Student student = Student.of("Иванов Иван", 20, "Москва", account);
//            session.save(student);

            rsl = session.createQuery(
                    "select distinct st from Student st "
                            + "join fetch st.account a "
                            + "join fetch a.books b "
                            + "where st.id = :sId", Student.class
            ).setParameter("sId", 4).uniqueResult();

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        System.out.println(rsl);
    }
}
