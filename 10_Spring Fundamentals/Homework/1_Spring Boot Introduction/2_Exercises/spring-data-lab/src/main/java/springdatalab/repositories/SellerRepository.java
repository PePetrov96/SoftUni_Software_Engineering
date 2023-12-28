package springdatalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatalab.models.entities.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {

    Seller findByFirstNameAndLastName(String firstName, String lastName);
}
