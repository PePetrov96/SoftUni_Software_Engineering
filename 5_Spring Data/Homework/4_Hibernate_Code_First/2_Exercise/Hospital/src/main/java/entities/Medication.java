package entities;

import javax.persistence.*;

@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitation_id", nullable = false)
    private Visitation visitation;

    public Medication() {
    }

    public Medication(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVisitation(Visitation visitation) {
        this.visitation = visitation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Visitation getVisitation() {
        return visitation;
    }
}