package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static org.example.travelagency.util.RandomGenerator.randomLang;
import static org.example.travelagency.util.RandomGenerator.randomLevel;

@Data
@AllArgsConstructor
public class Language {
    private String language;
    private String level;

    public static Language random() {
        return new Language(
                randomLang(),
                randomLevel()
        );
    }
}
