package app.library.business.abstracts;

import app.library.business.request.LoginRequest;
import app.library.business.request.RegisterRequest;
import app.library.business.response.LoginResponse;
import app.library.entities.concretes.UserEntity;
import app.library.utilities.exceptions.UsernameAlreadyExist;
import app.library.utilities.results.DataResult;

public interface AppAuthenticationService {
    public DataResult<UserEntity> register(RegisterRequest request) throws UsernameAlreadyExist;
    public DataResult<LoginResponse> login(LoginRequest request);
}
