package exceptionHandling.A7;

public class ResourceA implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing ResourceA");
        throw new Exception("Exception from ResourceA");
    }
}