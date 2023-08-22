package app.library.business.response;

import app.library.entities.abstracts.UserRole;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String imageUrl;
    private UserRole role;
}
