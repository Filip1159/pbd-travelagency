package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KnowledgeOfLanguages {
    private Long fk_employee_id;
    private Long fk_language_id;

    public static KnowledgeOfLanguages random() {
        return new KnowledgeOfLanguages(
                0L,
                0L
        );
    }
}
