package org.example.calories.controller;


import org.example.calories.model.Subscribe;
import org.example.calories.model.User;
import org.example.calories.service.SubscribeService;
import org.example.calories.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;
    private final SubscribeService subscribeService;
    @Autowired
    public UserController(UserService userService, SubscribeService subscribeService) {
        this.userService = userService;
        this.subscribeService = subscribeService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        try {
            userService.updateUser(updatedUser, id);
        } catch (ChangeSetPersister.NotFoundException e) {
            ResponseEntity.notFound();
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserByID(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping("")
    public String addNewUser() {
        return "users/addUser";
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        userService.createUser(newUser);
        return ResponseEntity.status(201).body(newUser);
    }
    @GetMapping("/{id}/subscriptions")
    public String getSubscription( Model model, @PathVariable int id) {

        model.addAttribute("userSubList",userService.getUserByID(id).get().getSubscribeList());
        return "users/subscriptions";
    }
    @PostMapping("/{id}/subscriptions")
    public ResponseEntity<Subscribe> createSubscription(@PathVariable int id, @RequestBody Subscribe newSubscription) {
        subscribeService.addSubscribe(id,newSubscription);
        return ResponseEntity.status(201).build();
    }
    @DeleteMapping("/{id}/subscriptions/{sub_id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable int id, @PathVariable int sub_id) {
        subscribeService.deleteSubscription(sub_id);
        return ResponseEntity.noContent().build();
    }

}
