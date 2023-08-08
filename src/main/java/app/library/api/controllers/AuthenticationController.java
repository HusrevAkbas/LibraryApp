package app.library.api.controllers;

import app.library.business.request.LoginRequest;
import app.library.business.request.RegisterRequest;
import app.library.entities.concretes.UserEntity;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.security.SpringAuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthenticationController {
    @Autowired
    SpringAuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<DataResult<UserEntity>> register (@RequestBody RegisterRequest request){
        return new  ResponseEntity<>(authenticationManager.register(request), HttpStatus.CREATED) ;
    }

    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody LoginRequest request){
        return new ResponseEntity<>(authenticationManager.login(request), HttpStatus.ACCEPTED) ;
    }
}
