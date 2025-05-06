package multiThreading.assignment3;

public class PrintEvenOdd {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread  even =new Thread(new EvenThread(printer));
        Thread odd =new Thread(new OddThread( printer));
        odd.start();
        even.start();
    }
}
