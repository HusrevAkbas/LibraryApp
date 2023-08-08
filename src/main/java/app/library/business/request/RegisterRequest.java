package app.library.business.request;

import app.library.entities.abstracts.UserRole;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}
