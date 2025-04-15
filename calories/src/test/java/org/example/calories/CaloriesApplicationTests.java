package org.example.calories;


import org.example.calories.model.Target;
import org.example.calories.model.User;
import org.example.calories.service.DishService;
import org.example.calories.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CaloriesApplicationTests {

    @Autowired
    DishService dishService;
    @Autowired
    UserService userService;
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
    @Test
    void saveTest() {
        User user = new User();
        user.setAge(22);
        user.setHeight(178);
        user.setWeight(64);
        user.setTarget(Target.WEIGHT_UP);
        user.setEmail("test@test.com");
        user.setName("Art");
        userService.createUser(user);
        var result = dishService.findById(1);
        Assertions.assertNotNull(result);
    }

}
