package org.example.calories.repository;


import org.example.calories.model.Dish;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
public interface DishRepository extends Repository<Dish,Integer> {
    Dish save(Dish dish);
    Optional<Dish> findById(int id);
    List<Dish> findAllBy();
}
