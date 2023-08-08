package app.library.business.response;

import lombok.Data;

@Data
public class LoginResponse {
    public String token;
    public String authorizationType ="Bearer ";
    public LoginResponse(String token) {
        this.token = token;
    }
}
