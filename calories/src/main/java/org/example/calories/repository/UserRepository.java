package org.example.calories.repository;

import org.example.calories.model.User;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    User save(User user);
    Optional<User> findById(int id);
    List<User> findAll();
    boolean existsById(Integer id);
    void deleteById(Integer id);
}
