package exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "income", columnDefinition = "DECIMAL(19,2)")
    private BigDecimal income;

    @Column(name = "address")
    private String address;

    @Column(name = "employee_count")
    private Integer employeeCount;

    @Column(name = "shop_area")
    private Integer shopArea;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;
}
