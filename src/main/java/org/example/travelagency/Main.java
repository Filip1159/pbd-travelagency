package org.example.travelagency;

import org.example.travelagency.model.Program;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, URISyntaxException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        var connection = new MySQLConnection();
        connection.deleteSchema();
        connection.createSchema();
        connection.insertRandom(Program.class, 10);
    }
}
