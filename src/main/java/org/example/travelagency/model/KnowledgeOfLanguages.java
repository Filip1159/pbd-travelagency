package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;

@Data
@AllArgsConstructor
@DependsOn({Employee.class, Language.class})
public class KnowledgeOfLanguages {
    private Long fk_employee_id;
    private Long fk_language_id;

    public static KnowledgeOfLanguages random(Long fk_employee_id, Long fk_language_id) {
        return new KnowledgeOfLanguages(
                fk_employee_id,
                fk_language_id
        );
    }
}
