package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static org.example.travelagency.util.RandomUtils.*;

@Data
@AllArgsConstructor
public class Program {
    private String title;
    private Integer days_nr;
    private String transport_type;
    private Short is_abroad;
    private Short is_for_children;
    private String description;

    public static Program random() {
        var p = new Program(
                randomString(10, 30),
                randomInt(7, 14),
                randomTransportType(),
                randomShort(0, 1),
                randomShort(0, 1),
                randomString(400, 2000)
        );
        System.out.println(p);
        return p;
    }
}
