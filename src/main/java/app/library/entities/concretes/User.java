package app.library.entities.concretes;

import app.library.entities.abstracts.UserRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(updatable = false)
    private Long id;
    @NotNull
    private String userName;
    @NotNull
    private String email;
    @NotNull
//    @Email
    private String password;
    private String imageUrl;
    private List<UserRoles> roles;
}
