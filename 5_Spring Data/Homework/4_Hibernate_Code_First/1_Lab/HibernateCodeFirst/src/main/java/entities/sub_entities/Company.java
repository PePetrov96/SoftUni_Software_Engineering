package entities.sub_entities;

import entities.Plane;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Plane> planes = new ArrayList<>();

    public Company() {}

    public Company(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void addPlane(Plane plane) {
        this.planes.add(plane);
        plane.setCompany(this);
    }

    public void removePlane(Plane plane) {
        this.planes.remove(plane);
        plane.setCompany(null);
    }
}