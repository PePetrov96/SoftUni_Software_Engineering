package springdatalab.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "description",  columnDefinition = "TEXT")
    private String description;

    @Column(name = "best_before")
    private LocalDate bestBefore;

    @ManyToOne
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Shop> shops = new HashSet<>();
}
