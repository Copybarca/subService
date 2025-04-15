package org.example.calories.repository;


import org.example.calories.model.Dish;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;
public interface DishRepository extends CrudRepository<Dish,Integer> {
    Dish save(Dish dish);
    Optional<Dish> findById(int id);
    List<Dish> findAllBy();
}
