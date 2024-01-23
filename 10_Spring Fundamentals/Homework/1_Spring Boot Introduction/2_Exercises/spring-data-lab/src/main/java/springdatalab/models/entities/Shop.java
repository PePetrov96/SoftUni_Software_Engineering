package springdatalab.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToOne
    private Town town;

    @OneToMany(mappedBy = "shop", fetch = FetchType.EAGER)
    private Set<Seller> sellers = new HashSet<>();

    @ManyToMany(mappedBy = "shops", fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();
}
