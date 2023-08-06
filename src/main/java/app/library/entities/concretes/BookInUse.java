package app.library.entities.concretes;
import app.library.entities.abstracts.BookInUseStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookInUse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @ManyToOne
    @JoinColumn( name = "user_id")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;
    private BookInUseStatus status;
    @NotNull
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
