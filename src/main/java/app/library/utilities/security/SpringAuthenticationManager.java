package app.library.utilities.security;

import app.library.business.request.LoginRequest;
import app.library.business.request.RegisterRequest;
import app.library.business.response.LoginResponse;
import app.library.dataAccess.abstracts.UserRepository;
import app.library.entities.abstracts.UserRole;
import app.library.entities.concretes.UserEntity;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SpringAuthenticationManager {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    public DataResult<UserEntity> register(RegisterRequest request){
        UserEntity user = new UserEntity(
                null, request.getUsername(), request.getEmail(), request.getPassword(), null, UserRole.USER
        );
        return new SuccessDataResult<>(userRepository.save(user), "user created") ;
    }

    public DataResult<LoginResponse> login(LoginRequest request){
        System.out.println(request.getUsername());
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),request.getPassword()
                )
        );
        System.out.println(auth.getName());
        String token = jwtUtil.generateToken(auth);
        return new SuccessDataResult<>(new LoginResponse(token),"login successful");
    }
}
