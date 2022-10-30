package org.example.travelagency;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, URISyntaxException {
        var access = new MySQLAccess();
        var file = Main.class.getClassLoader().getResource("inserts.sql");
        access.createSchema(file);
    }
}
