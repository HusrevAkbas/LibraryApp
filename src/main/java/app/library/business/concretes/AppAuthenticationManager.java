package app.library.business.concretes;

import app.library.business.abstracts.AppAuthenticationService;
import app.library.business.request.LoginRequest;
import app.library.business.request.RegisterRequest;
import app.library.business.response.LoginResponse;
import app.library.entities.concretes.UserEntity;
import app.library.utilities.exceptions.UsernameAlreadyExist;
import app.library.utilities.results.DataResult;
import app.library.utilities.security.SpringAuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppAuthenticationManager implements AppAuthenticationService {

    @Autowired
    private SpringAuthenticationManager springAuthenticationManager;

    public DataResult<UserEntity> register(RegisterRequest request) throws UsernameAlreadyExist {
        return springAuthenticationManager.register(request);
    }
    public DataResult<LoginResponse> login(LoginRequest request){
        return springAuthenticationManager.login(request);
    }

}
