package exceptionHandling.A10;

public class BadControlFlow {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25};

        try {
            for (int num : numbers) {
                if (num == 15) {
                    // Using exception to break loop — BAD practice
                    throw new BreakLoopException();
                }
                System.out.println("Number: " + num);
            }
        } catch (BreakLoopException e) {
            System.out.println("Broke the loop using an exception (BAD PRACTICE)");
        }

        System.out.println("Program finished.");
    }
}
