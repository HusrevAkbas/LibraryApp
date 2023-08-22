package app.library.business.concretes;

import app.library.business.abstracts.UserService;
import app.library.business.response.UserResponse;
import app.library.dataAccess.abstracts.UserRepository;
import app.library.entities.concretes.UserEntity;
import app.library.utilities.mappers.ModelMapperService;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.results.SuccessDataResult;
import app.library.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapperService modelMapperService;

    @Override
    public DataResult<List<UserResponse>> findAllUsers() {
        List<UserEntity> userEntities = this.userRepository.findAll();
        List<UserResponse> userResponses = userEntities.stream()
                .map(user -> this.modelMapperService.response().map(user, UserResponse.class)
        ).collect(Collectors.toList());

        return new SuccessDataResult<>(userResponses,"All users listed");
    }

    @Override
    public DataResult<UserResponse> findUserById(Long id) {
        UserEntity userEntity = this.userRepository.findById(id).orElseThrow();
        UserResponse user = modelMapperService.response().map(userEntity, UserResponse.class);
        return new SuccessDataResult<>(user,"User found with id: "+id);
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
