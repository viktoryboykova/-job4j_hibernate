package ru.job4j.model.lazy;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lazy_car_model")
public class LazyCarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private LazyCarBrand lazyCarBrand;

    public static LazyCarModel of(String name, LazyCarBrand carBrand) {
        LazyCarModel carModel = new LazyCarModel();
        carModel.name = name;
        carModel.lazyCarBrand = carBrand;
        return carModel;
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

    public LazyCarBrand getCarBrand() {
        return lazyCarBrand;
    }

    public void setCarBrand(LazyCarBrand carBrand) {
        this.lazyCarBrand = carBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LazyCarModel carModel = (LazyCarModel) o;
        return id == carModel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carBrand=" + lazyCarBrand +
                '}';
    }
}
