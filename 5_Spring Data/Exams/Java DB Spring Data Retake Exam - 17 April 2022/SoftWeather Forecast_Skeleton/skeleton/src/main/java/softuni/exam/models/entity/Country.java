package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;

    @Column(name = "currency", nullable = false)
    private String currency;
}
