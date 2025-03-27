package org.example.calories;

import org.example.calories.controller.DishController;
import org.example.calories.repository.DishRepository;
import org.example.calories.service.DishService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CaloriesApplicationTests {

    @Autowired
    DishService dishService;
    @Test
    void contextLoads() {
        var result = dishService.listAllDishes();
        Assertions.assertFalse(result.isEmpty());
    }
    @Test
    void contextLoads2() {
        var result = dishService.findById(1);
        Assertions.assertNotNull(result);
    }

}
