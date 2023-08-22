package app.library.api.controllers;

import app.library.business.abstracts.UserService;
import app.library.business.response.UserResponse;
import app.library.entities.concretes.UserEntity;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/all")
    public DataResult<List<UserResponse>> getAllUsers(){
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

    // USE AUTHENTICATION CONTROLLER TO ADD NEW USER (/api/auth/register)
//    @PostMapping("/add")
//    public Result addUser(@RequestBody UserEntity userEntity){
//        return this.userService.addUser(userEntity);
//    }
    @PutMapping("/update")
    public Result updateUser(@RequestBody UserEntity userEntity){
        return this.userService.updateUser(userEntity);
    }
}
