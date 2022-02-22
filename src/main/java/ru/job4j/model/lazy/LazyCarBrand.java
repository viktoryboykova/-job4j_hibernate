package ru.job4j.model.lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lazy_car_brand")
public class LazyCarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "lazyCarBrand")
    private List<LazyCarModel> lazyCarModels = new ArrayList<>();

    public static LazyCarBrand of(String name) {
        LazyCarBrand carBrand = new LazyCarBrand();
        carBrand.name = name;
        return carBrand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LazyCarModel> getCarModels() {
        return lazyCarModels;
    }

    public void setCarModels(List<LazyCarModel> carModels) {
        this.lazyCarModels = carModels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LazyCarBrand carBrand = (LazyCarBrand) o;
        return id == carBrand.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CarBrand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
