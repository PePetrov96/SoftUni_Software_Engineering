package com.dictionaryapp.model.entity.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum LanguageName {
    GERMAN("A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe."),
    SPANISH("A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure."),
    FRENCH("A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature."),
    ITALIAN("A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.");

    private final String description;

    LanguageName(String description) {
        this.description = description;
    }
}
