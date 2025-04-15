package org.example.calories.service;


import lombok.RequiredArgsConstructor;
import org.example.calories.model.Dish;
import org.example.calories.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {

    DishRepository dishRepository;
    @Autowired
    public DishService(DishRepository dishRepository) {

        this.dishRepository = dishRepository;
    }

    public List<Dish> listAllDishes(){
        return  dishRepository.findAllBy();
    };
    public Dish findById(int id){
        return  dishRepository.findById(id).get();
    };
    public void createDish(Dish dish) {
        dishRepository.save(dish);
    }
    public void updateDish(Dish dish, Integer id) throws ChangeSetPersister.NotFoundException {
        if(!dishRepository.existsById(id)){
            throw new ChangeSetPersister.NotFoundException();
        }
        Optional<Dish> ou = dishRepository.findById(id);
        if(ou.isPresent()){
            Dish dishToUpdate = ou.get();
            dishToUpdate.setFats(dish.getFats());
            dishToUpdate.setCarbohydrates(dish.getCarbohydrates());
            dishToUpdate.setLabel(dish.getLabel());
            dishToUpdate.setProteins(dish.getProteins());
            dishToUpdate.setCalories_per_position(dish.getCalories_per_position());
            dishRepository.save(dish);
        }
    }
    public void deleteDish(Integer id) throws ChangeSetPersister.NotFoundException {
        if(!dishRepository.existsById(id)){
            throw new ChangeSetPersister.NotFoundException();
        }
        dishRepository.deleteById(id);
    }

}
