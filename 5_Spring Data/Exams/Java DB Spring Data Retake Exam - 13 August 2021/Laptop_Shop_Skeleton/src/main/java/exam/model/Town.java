package exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity{
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "population")
    private Integer population;

    @Column(name = "travel_guide", columnDefinition = "TEXT")
    private String travelGuide;
}
