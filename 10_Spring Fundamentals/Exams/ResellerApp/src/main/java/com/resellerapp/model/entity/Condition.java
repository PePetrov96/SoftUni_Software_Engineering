package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "condition_entity")
public class Condition extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "condition_name")
    private ConditionName conditionName;

    @Column(name = "description")
    private String description;

    public void setDescription() {
        this.description = this.conditionName.getDescription();
    }
}
