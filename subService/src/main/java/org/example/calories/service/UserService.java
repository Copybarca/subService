package org.example.calories.service;

import org.example.calories.model.User;
import org.example.calories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserList(){
        return userRepository.findAll();}
    public Optional<User> getUserByID(int id){
        return userRepository.findById(id);
    }
    public void createUser(User user) {
        userRepository.save(user);
    }
    public void updateUser(User user, Integer id) throws ChangeSetPersister.NotFoundException {
        if(!userRepository.existsById(id)){
            throw new ChangeSetPersister.NotFoundException();
        }
        Optional<User> ou = userRepository.findById(id);
        if(ou.isPresent()){
            User userToUpdate = ou.get();
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setAge(user.getAge());
            userToUpdate.setAge(user.getAge());
            userRepository.save(userToUpdate);
        }
    }
    public void deleteUser(Integer id) throws ChangeSetPersister.NotFoundException {
        if(!userRepository.existsById(id)){
            throw new ChangeSetPersister.NotFoundException();
        }
        userRepository.deleteById(id);
    }
}
