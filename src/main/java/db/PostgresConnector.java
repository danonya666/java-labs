package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnector {

    public Connection connectToPostgres() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/itmo?user=macbook&password=devpass";
        Connection conn = DriverManager.getConnection(url);

        return conn;
    }


}
