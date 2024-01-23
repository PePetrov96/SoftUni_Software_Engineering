package springdatalab.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity{
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "town")
    private Set<Shop> shops = new HashSet<>();
}
