package multiThreading.assignment3;

public class Printer {
    private int number= 1;
    private final int MAX=100;
    private boolean isOddTurn = true;

    public synchronized void printOdd() throws InterruptedException {
        while(number<MAX){
            while(!isOddTurn){
                wait();
            }
            System.out.println(number +" ");
            number++;
            isOddTurn=false;
            notify();
        }
    }
    public synchronized void printEven() throws InterruptedException {
        while(number<MAX){
            while(isOddTurn){
                wait();
            }
            System.out.println(number +" ");
            number++;
            isOddTurn=true;
            notify();
        }
    }
}
