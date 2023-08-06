package app.library.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(updatable = false)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String author;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private UserEntity userEntity;
    @NotNull
    private String publisher;
    private int publishDate;
    private String publishPlace;
    @NotNull
    private int pageCount;
    private boolean available;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
    private String isbn10;
    private String isbn13;
    private String assetNumber;
    private String imageUrl;
    private int quantity;
}
