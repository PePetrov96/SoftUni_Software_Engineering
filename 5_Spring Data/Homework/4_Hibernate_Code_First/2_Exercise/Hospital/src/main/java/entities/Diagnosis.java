package entities;

import javax.persistence.*;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "comments")
    private String comments;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitation_id", nullable = false, unique = true)
    private Visitation visitation;

    public Diagnosis() {}

    public Diagnosis(String name, String comments) {
        this.name = name;
        this.comments = comments;
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

    public String getComments() {
        return comments;
    }

    public Visitation getVisitation() {
        return visitation;
    }
}
