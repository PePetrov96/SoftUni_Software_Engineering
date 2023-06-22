package exam.repository;

import exam.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    boolean existsByMacAddress(String macAddress);
    //cpu speed in descending order
    //ram in descending order
    //storage in descending order
    //MAC Address ascending order
    List<Laptop> findAllByIdGreaterThanOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc(Long id);
}
