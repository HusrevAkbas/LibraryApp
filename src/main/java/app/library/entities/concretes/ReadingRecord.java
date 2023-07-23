package app.library.entities.concretes;

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
public class ReadingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @ManyToOne
    @JoinColumn( name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;
    private int lastReadPage;
    private boolean completed;
    @NotNull
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
