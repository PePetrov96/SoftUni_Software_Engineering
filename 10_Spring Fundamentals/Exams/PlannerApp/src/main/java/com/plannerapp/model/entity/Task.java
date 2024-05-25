package com.plannerapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@Getter @Setter @NoArgsConstructor
public class Task extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "dueDate")
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void assignUser(User user) {
        this.user = user;
        user.addTask(this);
    }

    public void resignUser() {
        this.user.removeTask(this);
        this.user = null;
    }
}
