package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static org.example.travelagency.util.RandomGenerator.randomString;
import static org.example.travelagency.util.RandomGenerator.randomTel;

@Data
@AllArgsConstructor
public class Institution {
    private String name;
    private String type;
    private String description;
    private String hours;
    private String address;
    private String tel;

    public static Institution random() {
        return new Institution(
                randomString(10, 30),
                randomString(10, 30),
                randomString(150, 2000),
                randomString(20, 50),
                randomString(20, 30),
                randomTel()
        );
    }
}
