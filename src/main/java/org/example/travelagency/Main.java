package org.example.travelagency;

import org.example.travelagency.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, URISyntaxException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        fillDB();
//        performanceTrial();
    }

    public static void fillDB() throws SQLException, IOException, URISyntaxException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        var mySql = new MySQLConnection();
        mySql.deleteSchema();
        mySql.createSchema();
        var ITEMS = 100000;
        var generator = new RandomGenerator(mySql);
        System.out.println(1);
        generator.insertRandom(Program.class, 10);
        System.out.println(2);
        generator.insertRandom(Tour.class, 100);
        System.out.println(3);
        generator.insertRandom(Institution.class, 30);
        System.out.println(4);
        generator.insertRandom(Employee.class, ITEMS);
        System.out.println(5);
        generator.insertRandom(Photo.class, ITEMS);
        System.out.println(6);
        generator.insertRandom(Attraction.class, ITEMS);
        System.out.println(7);
        generator.insertRandom(Delegation.class, ITEMS);
        System.out.println(8);
        generator.insertRandom(Language.class, 5);
        System.out.println(9);
        generator.insertRandom(KnowledgeOfLanguages.class, 100);
        System.out.println(10);
        generator.insertRandom(Customer.class, ITEMS);
        System.out.println(11);
        generator.insertRandom(Booking.class, ITEMS);
        System.out.println(12);
        generator.insertRandom(Participant.class, ITEMS);
        System.out.println(13);
        generator.insertRandom(Payment.class, ITEMS);
        System.out.println(14);
        generator.insertRandom(Review.class, ITEMS);
        System.out.println(15);
        generator.insertRandom(Enrollment.class, ITEMS);
        mySql.disconnect();
    }

    public static void performanceTrial() throws IOException {
        var ITEMS = 10000;
        var builder = new StringBuilder("INSERT INTO program VALUES\n");
        for (int i = 0; i < ITEMS; i++) {
            var p = Program.random();
            builder.append(
                    String.format(
                            "(default, '%s', '%s', '%s', '%s', '%s', '%s')%s\n",
                            p.getTitle(),
                            p.getDays_nr(),
                            p.getTransport_type(),
                            p.getIs_abroad(),
                            p.getIs_for_children(),
                            p.getDescription(),
                            i == ITEMS - 1 ? ";" : ","
                    )
            );
        }
        FileWriter myWriter = new FileWriter("performanceTestQuery.sql");
        myWriter.write(builder.toString());
        myWriter.close();
    }
}
