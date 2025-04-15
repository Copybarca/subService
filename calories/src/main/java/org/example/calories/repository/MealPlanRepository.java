package org.example.calories.repository;

import org.example.calories.model.MealPlan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MealPlanRepository extends CrudRepository<MealPlan,Integer> {


    @Override
    <S extends MealPlan> S save(S entity);

    @Override
    Optional<MealPlan> findById(Integer integer);

    @Override
    void deleteById(Integer integer);
}
