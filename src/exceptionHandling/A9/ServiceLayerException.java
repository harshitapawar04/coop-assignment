package exceptionHandling.A9;

public class ServiceLayerException extends RuntimeException{
    public ServiceLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
