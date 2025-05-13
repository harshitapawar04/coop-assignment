package exceptionHandling.A7;

public class ResourceB implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Closing ResourceB");
        throw new Exception("Exception from ResourceB");
    }
}