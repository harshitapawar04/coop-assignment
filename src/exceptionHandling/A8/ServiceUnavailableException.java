package exceptionHandling.A8;

public class ServiceUnavailableException extends Exception{
    public ServiceUnavailableException(String message) {
        super(message);
    }
}