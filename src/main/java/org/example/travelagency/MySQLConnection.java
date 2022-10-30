package org.example.travelagency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private final Connection connection;

    public MySQLConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://root:root@localhost:3306/travelagency?allowMultiQueries=true");
    }

    public void createSchema(URL filename) throws IOException, SQLException, URISyntaxException {
        var insertQuery = readSqlFileContent(filename);
        var statement = connection.prepareStatement(insertQuery);
        statement.executeUpdate();
    }

    private String readSqlFileContent(URL path) throws IOException, URISyntaxException {
        var bufferedReader = new BufferedReader(new FileReader(new File(path.toURI())));
        var builder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }
}
