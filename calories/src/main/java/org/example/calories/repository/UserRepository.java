package org.example.calories.repository;

import org.example.calories.model.Dish;
import org.example.calories.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User,Integer> {
    User save(User user);
    Optional<User> findById(int id);
    List<Optional<User>> index();
}
