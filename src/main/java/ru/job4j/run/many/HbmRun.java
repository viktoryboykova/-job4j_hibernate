package ru.job4j.run.many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.model.many.CarBrand;
import ru.job4j.model.many.CarModel;

public class HbmRun {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            CarModel one = CarModel.of("Audi A3");
            session.save(one);
            CarModel two = CarModel.of("Audi A5");
            session.save(two);
            CarModel three = CarModel.of("Audi Q3");
            session.save(three);
            CarModel four = CarModel.of("Audi Q8");
            session.save(four);
            CarModel five = CarModel.of("Audi R8");
            session.save(five);

            CarBrand audi = CarBrand.of("Audi");
            audi.addCarModel(session.load(CarModel.class, 1));
            audi.addCarModel(session.load(CarModel.class, 2));
            audi.addCarModel(session.load(CarModel.class, 3));
            audi.addCarModel(session.load(CarModel.class, 4));
            audi.addCarModel(session.load(CarModel.class, 5));

            session.save(audi);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
