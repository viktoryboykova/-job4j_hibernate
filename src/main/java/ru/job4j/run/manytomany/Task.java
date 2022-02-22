package ru.job4j.run.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.model.manytomany.Author;

public class Task {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

//            Book one = Book.of("Педиатрия по Нельсону");
//            Book two = Book.of("Здоровье ребенка");
//            Book three = Book.of("Начало жизни вашего ребенка");
//
//            Author first = Author.of("Карен Маркданте");
//            first.getBooks().add(one);
//
//            Author second = Author.of("Роберт Клигман");
//            second.getBooks().add(one);
//
//            Author third = Author.of("Комаровский");
//            third.getBooks().add(two);
//            third.getBooks().add(three);
//
//            session.persist(first);
//            session.persist(second);
//            session.persist(third);

            Author author = session.get(Author.class, 1);
            session.remove(author);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
