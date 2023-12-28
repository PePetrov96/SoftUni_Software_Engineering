package springdatalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatalab.models.entities.Shop;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {

    Shop findByName(String name);

}
