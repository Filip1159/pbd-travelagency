package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;

import static org.example.travelagency.util.RandomUtils.*;

@Data
@AllArgsConstructor
@DependsOn(Booking.class)
public class Participant {
    private String document_nr;
    private String surname;
    private String first_name;
    private String second_name;
    private String sex;
    private String email;
    private Long fk_booking_id;

    public static Participant random(Long fk_booking_id) {
        return new Participant(
                randomString(10, 13),
                randomString(5, 15),
                randomString(5, 15),
                randomString(5, 15),
                randomShort(0, 1) == 0 ? "K" : "M",
                randomEmail(),
                fk_booking_id
        );
    }
}
