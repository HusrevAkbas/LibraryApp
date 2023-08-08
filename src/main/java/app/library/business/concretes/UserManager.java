package app.library.business.concretes;

import app.library.business.abstracts.UserService;
import app.library.dataAccess.abstracts.UserRepository;
import app.library.entities.concretes.UserEntity;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.results.SuccessDataResult;
import app.library.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public DataResult<List<UserEntity>> findAllUsers() {
        return new SuccessDataResult<>(this.userRepository.findAll(),"All users listed");
    }

    @Override
    public DataResult<UserEntity> findUserById(Long id) {
        return new SuccessDataResult<>(this.userRepository.findById(id).get(),"UserEntity found");
    }

    @Override
    public Result addUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
        return new SuccessResult("UserEntity added");
    }

    @Override
    public Result deleteById(Long id) {
        this.userRepository.deleteById(id);
        return new SuccessResult("UserEntity deleted");
    }

    @Override
    public Result updateUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
        return new SuccessResult("UserEntity updated");
    }
}
