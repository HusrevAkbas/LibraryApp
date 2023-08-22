package app.library.business.response;

import app.library.entities.concretes.Category;
import lombok.Data;

@Data
public class BookResponse {
    private Long id;
    private String name;
    private String author;
    private UserResponse user;
    private String publisher;
    private int publishDate;
    private String publishPlace;
    private int pageCount;
    private boolean available;
    private Category category;
    private String isbn10;
    private String isbn13;
    private String assetNumber;
    private String imageUrl;
    private int quantity;
}
