package com.userData.controller;
import com.userData.entity.User;
import com.userData.repo.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    public  UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }
    @PostMapping
    public User setUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        //custom exception
        return userRepository.findById(userId).orElse(null);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        Optional<User> user =  userRepository.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setFirstName(newUser.getFirstName());
            foundUser.setLastName(newUser.getLastName());
            foundUser.setEmail(newUser.getEmail());
            userRepository.save(foundUser);
            return foundUser;
        }
        else{
            return null;
        }
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
    }
}
