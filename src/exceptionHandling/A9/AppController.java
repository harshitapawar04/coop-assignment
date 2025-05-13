package exceptionHandling.A9;

public class AppController {
    public static void main(String[] args) {
        AppService service = new AppService();
        try {
            service.processRequest();
        } catch (ServiceLayerException e) {
            System.out.println("📋 Controller caught: " + e.getMessage());
            System.out.println("🔗 Root cause: " + e.getCause());
        }
    }
}
