package exceptionHandling.A10;

public class GoodControlFlow {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25};

        for (int num : numbers) {
            if (num == 15) {
                System.out.println(" Number 15 found, breaking loop properly.");
                break;
            }
            System.out.println("Number: " + num);
        }

        System.out.println("Program finished.");
    }
}
