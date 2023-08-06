package app.library.business.abstracts;

import app.library.entities.concretes.UserEntity;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;

import java.util.List;

public interface UserService {
    public DataResult<List<UserEntity>> findAllUsers();
    public DataResult<UserEntity> findUserById(Long id);
    public Result addUser(UserEntity userEntity);
    public Result deleteById(Long id);
    public Result updateUser(UserEntity userEntity);
}
