package springdatalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatalab.models.entities.Town;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, String> {

    Optional<Town> findByName(String name);
}
