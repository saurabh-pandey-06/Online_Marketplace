package storage;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseConnector {

    /**
     * Making connection with the database and
     * returning the Statement object to the caller         *
     *
     * @return
     */
    public Statement getStatement() {

        String hostname = "localhost:3306";
        String dbName = "pandey_db";
        String url = "jdbc:mysql://" + hostname + "/" + dbName;
        String username = "pandey";
        String password = "Spring Prasad@2017";
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            Statement stmt = null;

            try {
                return (Statement) conn.createStatement();

            } catch (SQLException e1) {
                System.err.println("Unable to create SQL statement!");
                e1.printStackTrace();
                return null;
            }
        } else
            return null;
    }
}
