package org.example.travelagency;

import org.example.travelagency.model.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, URISyntaxException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        var mySql = new MySQLConnection();
        mySql.deleteSchema();
        mySql.createSchema();
        var generator = new RandomGenerator(mySql);
        System.out.println(1);
        generator.insertRandom(Program.class, 10);
        System.out.println(2);
        generator.insertRandom(Tour.class, 100);
        System.out.println(3);
        generator.insertRandom(Institution.class, 30);
        System.out.println(4);
        generator.insertRandom(Employee.class, 1000);
        System.out.println(5);
        generator.insertRandom(Photo.class, 1000);
        System.out.println(6);
        generator.insertRandom(Attraction.class, 1000);
        System.out.println(7);
        generator.insertRandom(Delegation.class, 1000);
        System.out.println(8);
        generator.insertRandom(Language.class, 5);
        System.out.println(9);
        generator.insertRandom(KnowledgeOfLanguages.class, 100);
        System.out.println(10);
        generator.insertRandom(Customer.class, 1000);
        System.out.println(11);
        generator.insertRandom(Booking.class, 1000);
        System.out.println(12);
        generator.insertRandom(Participant.class, 1000);
        System.out.println(13);
        generator.insertRandom(Payment.class, 1000);
        System.out.println(14);
        generator.insertRandom(Review.class, 1000);
        System.out.println(15);
        generator.insertRandom(Enrollment.class, 1000);
    }
}
