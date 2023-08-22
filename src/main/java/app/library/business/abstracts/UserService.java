package app.library.business.abstracts;

import app.library.business.response.UserResponse;
import app.library.entities.concretes.UserEntity;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public DataResult<List<UserResponse>> findAllUsers();
    public DataResult<UserResponse> findUserById(Long id);
    public Result addUser(UserEntity userEntity);
    public Result deleteById(Long id);
    public Result updateUser(UserEntity userEntity);
}
