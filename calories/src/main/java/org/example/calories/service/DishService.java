package org.example.calories.service;


import lombok.RequiredArgsConstructor;
import org.example.calories.model.Dish;
import org.example.calories.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

}
