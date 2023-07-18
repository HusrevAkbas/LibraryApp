package app.library.business.concretes;

import app.library.business.abstracts.UserService;
import app.library.dataAccess.abstracts.UserRepository;
import app.library.entities.concretes.User;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.results.SuccessDataResult;
import app.library.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    UserRepository userRepository;
    @Autowired
    UserManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<List<User>> findAllUsers() {
        return new SuccessDataResult<>(this.userRepository.findAll(),"All users listed");
    }

    @Override
    public DataResult<User> findUserById(Long id) {
        return new SuccessDataResult<>(this.userRepository.findById(id).get(),"User found");
    }

    @Override
    public Result addUser(User user) {
        this.userRepository.save(user);
        return new SuccessResult("User added");
    }

    @Override
    public Result deleteById(Long id) {
        this.userRepository.deleteById(id);
        return new SuccessResult("User deleted");
    }

    @Override
    public Result updateUser(User user) {
        this.userRepository.save(user);
        return new SuccessResult("User updated");
    }
}
