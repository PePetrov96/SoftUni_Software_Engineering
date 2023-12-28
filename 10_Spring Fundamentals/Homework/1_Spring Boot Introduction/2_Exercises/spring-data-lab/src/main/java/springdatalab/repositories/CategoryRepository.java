package springdatalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatalab.models.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
    Category findByName(String name);
}
