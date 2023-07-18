package app.library.business.abstracts;

import app.library.entities.concretes.User;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;

import java.util.List;

public interface UserService {
    public DataResult<List<User>> findAllUsers();
    public DataResult<User> findUserById(Long id);
    public Result addUser(User user);
    public Result deleteById(Long id);
    public Result updateUser(User user);
}
