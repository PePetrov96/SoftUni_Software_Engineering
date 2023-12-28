package springdatalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatalab.models.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByName(String name);
}
