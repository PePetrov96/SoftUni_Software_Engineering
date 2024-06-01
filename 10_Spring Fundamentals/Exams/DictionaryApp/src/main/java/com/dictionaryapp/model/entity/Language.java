package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.entity.enums.LanguageName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "language")
@Getter @Setter @NoArgsConstructor
public class Language extends BaseEntity {
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private LanguageName languageName;

    @Column(name = "description")
    private String description;

    @PrePersist
    public void setDescription() {
        this.description = this.languageName.getDescription();
    }

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private List<Word> words = new ArrayList<>();
}
