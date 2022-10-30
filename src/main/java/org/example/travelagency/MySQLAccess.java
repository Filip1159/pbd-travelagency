package org.example.travelagency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MySQLAccess {
    private final Connection connection;
    private ResultSet resultSet = null;

    public MySQLAccess() throws SQLException {
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

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        System.out.println("The columns in the table are: ");
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++)
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);
        }
    }
}
