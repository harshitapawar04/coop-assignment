package exceptionHandling.A9;

import java.sql.SQLException;

public class AppRepository {
    public void getDataFromDatabase() throws SQLException {

        throw new SQLException("Database connection failed.");
    }
}
