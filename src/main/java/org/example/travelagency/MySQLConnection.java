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
        connection = DriverManager.getConnection("jdbc:mysql://root:root@localhost:3306/travelagency?allowMultiQueries=true&useUnicode=true");
    }

    public void createSchema() throws SQLException, IOException, URISyntaxException {
        executeUpdate(Main.class.getClassLoader().getResource("inserts.sql"));
    }

    public void deleteSchema() throws SQLException, IOException, URISyntaxException {
        executeUpdate(Main.class.getClassLoader().getResource("drops.sql"));
    }

    public void executeUpdate(URL filename) throws IOException, SQLException, URISyntaxException {
        var insertQuery = readSqlFileContent(filename);
        var statement = connection.prepareStatement(insertQuery);
        statement.executeUpdate();
    }

    public void insert(Object[] objects) throws IllegalAccessException, SQLException {
        System.out.println("start insert");
        var tableName = objects[0].getClass().getSimpleName();
        var declaredFields = objects[0].getClass().getDeclaredFields();
        for (var field : declaredFields) field.setAccessible(true);
        var columnsCount = declaredFields.length;
        var queryString = String.format("insert into %s values (default", tableName) + ", ?".repeat(columnsCount) + ")";
        var statement = connection.prepareStatement(queryString);
        System.out.println("prep statement");
        for (var o : objects) {
            for (int i = 0; i < columnsCount; i++)
                statement.setObject(i + 1, declaredFields[i].get(o));
            statement.addBatch();
        }
        System.out.println("start executing");
        statement.executeLargeBatch();
        System.out.println("end insert");
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
