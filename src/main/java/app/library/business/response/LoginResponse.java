package app.library.business.response;

import app.library.entities.concretes.UserEntity;
import lombok.Data;

@Data
public class LoginResponse {
    public String token;
    public String authorizationType ="Bearer ";
    public UserResponse user;
    public LoginResponse(String token, UserResponse user) {
        this.token = token;
        this.user = user;
    }
}
