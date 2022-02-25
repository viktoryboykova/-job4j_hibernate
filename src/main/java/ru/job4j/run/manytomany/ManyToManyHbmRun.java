package ru.job4j.run.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.model.manytomany.City;

public class ManyToManyHbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            City minsk = City.of("Минск");
            session.save(minsk);
            City moscow = City.of("Москва");
            session.save(moscow);
            City london = City.of("Лондон");
            session.save(london);
            City capetown = City.of("Кейптаун");
            session.save(capetown);
            City ottawa = City.of("Оттава");
            session.save(ottawa);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
