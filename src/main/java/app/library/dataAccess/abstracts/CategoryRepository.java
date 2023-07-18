package app.library.dataAccess.abstracts;

import app.library.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
