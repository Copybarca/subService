package org.example.calories.controller;


import org.example.calories.model.Target;
import org.example.calories.model.User;
import org.example.calories.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("usersList", users);
        return "users/usersList";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserByID(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/createUser")
    public String addNewUser() {
        return "users/addUser";
    }

    @PostMapping("/createUser")
    public String createUser(@RequestParam String name,
                                           @RequestParam String email,
                                           @RequestParam int age,
                                           @RequestParam int height,
                                           @RequestParam int weight,
                                           @RequestParam Target target,
                                           Model model) {
        User newUser = new User(name, email, age, height, weight, target);
        userService.createUser(newUser);
        return "redirect:users/usersList";
    }

}
