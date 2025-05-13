package exceptionHandling.A9;

import java.sql.SQLException;

public class AppService {
    AppRepository repository = new AppRepository();

    public void processRequest() {
        try {
            repository.getDataFromDatabase();
        } catch (SQLException e) {
            // Wrap SQLException in a ServiceLayerException and throw
            throw new ServiceLayerException("Failed in service layer while accessing data.", e);
        }
    }
}
