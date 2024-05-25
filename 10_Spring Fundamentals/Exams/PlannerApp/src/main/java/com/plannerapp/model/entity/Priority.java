package com.plannerapp.model.entity;

import com.plannerapp.model.entity.enums.PriorityName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "priority")
@Getter @Setter @NoArgsConstructor
public class Priority extends BaseEntity {
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private PriorityName name;

    @Column(name = "description")
    private String description;

    @PrePersist
    public void setDescription() {
        this.description = this.name.getDescription();
    }

    @OneToMany(mappedBy = "priority", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
}
