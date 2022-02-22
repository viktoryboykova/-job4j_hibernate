package ru.job4j.run.lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.model.lazy.LazyCarBrand;
import ru.job4j.model.lazy.LazyCarModel;

import java.util.List;

public class LazyTask {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            LazyCarBrand audi = LazyCarBrand.of("Audi");
            session.save(audi);

            LazyCarModel one = LazyCarModel.of("Audi A3", audi);
            session.save(one);
            LazyCarModel two = LazyCarModel.of("Audi A5", audi);
            session.save(two);
            LazyCarModel three = LazyCarModel.of("Audi Q3", audi);
            session.save(three);
            LazyCarModel four = LazyCarModel.of("Audi Q8", audi);
            session.save(four);
            LazyCarModel five = LazyCarModel.of("Audi R8", audi);
            session.save(five);
            List<LazyCarBrand> list;
            list = session.createQuery("from LazyCarBrand ").list();
            for (LazyCarBrand lazyCarBrand : list) {
                for (LazyCarModel lazyCarModel : lazyCarBrand.getCarModels()) {
                    System.out.println(lazyCarModel);
                }
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
