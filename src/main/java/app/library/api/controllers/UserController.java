package app.library.api.controllers;

import app.library.business.abstracts.UserService;
import app.library.entities.concretes.UserEntity;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/all")
    public DataResult<List<UserEntity>> getAllUsers(){
        return this.userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public DataResult<UserEntity> getUserById(@PathVariable("id") Long id){
        return this.userService.findUserById(id);
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteUserById(@PathVariable("id") Long id){
        return this.userService.deleteById(id);
    }
    @PostMapping("/add")
    public Result addUser(@RequestBody UserEntity userEntity){
        return this.userService.addUser(userEntity);
    }
    @PutMapping("/update")
    public Result updateUser(@RequestBody UserEntity userEntity){
        return this.userService.updateUser(userEntity);
    }
}
