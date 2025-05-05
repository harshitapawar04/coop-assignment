//Create a Runnable lambda that prints “Hello Functional Java”.

package functionalProgramming.level1.A7;

public class LamdaRunnable {

    public static void main(String[] args) {
        Runnable runnable =()-> System.out.println("Hello Functional Java");

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
