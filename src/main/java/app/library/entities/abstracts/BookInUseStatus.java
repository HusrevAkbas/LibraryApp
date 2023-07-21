package app.library.entities.abstracts;

public enum BookInUseStatus {
    USER_DEMANDED_TO_TAKE,
    OWNER_ACCEPTED_TO_GIVE,
    USER_TOOK_BOOK,
    USER_DEMANDED_TO_RETURN,
    OWNER_ACCEPTED_RETURN,
    BOOK_RETURNED_TO_OWNER
}
