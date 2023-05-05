package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation {
    private long id;
    private String locationName;
    private Set<Sale> sales = new HashSet<>();

    public StoreLocation() {
    }

    public StoreLocation(String locationName) {
        setLocationName(locationName);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    @OneToMany(mappedBy = "storeLocation")
    public Set<Sale> getSales() {
        return sales;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    private void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
