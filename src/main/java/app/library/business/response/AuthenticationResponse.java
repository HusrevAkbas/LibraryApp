package app.library.business.response;

import lombok.Data;

@Data
public class AuthenticationResponse {
    public AuthenticationResponse(String token) {
        this.token = token;
    }
    public String token;
    public String authorizationType ="Bearer ";
}
