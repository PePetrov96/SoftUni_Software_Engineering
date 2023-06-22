package exam.model;

import exam.model.enums.WarrantyType;
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
@Table(name = "laptops")
public class Laptop extends BaseEntity{
    @Column(name = "mac_address", unique = true)
    private String macAddress;

    @Column(name = "cpu_speed")
    private Double cpuSpeed;

    @Column(name = "ram")
    private Integer ram;

    @Column(name = "storage")
    private Integer storage;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", columnDefinition = "DECIMAL(19,2)")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "warranty_type")
    private WarrantyType warrantyType;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
}
