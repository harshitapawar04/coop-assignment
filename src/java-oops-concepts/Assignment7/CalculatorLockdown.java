package Assignment7;

class BasicCalculator {
    public final int add(int a, int b) {
        return a + b;
    }
}

class SmartCalculator extends BasicCalculator {
    //  This will cause a compile-time error:
    /*
    @Override
    public int add(int a, int b) {
        return a + b + 1; // Trying to override a final method - not allowed!
    }
    */
    public int subtract(int a, int b) {
        return a - b;
    }
}

public class CalculatorLockdown{
    public static void main(String[] args) {
        SmartCalculator calc = new SmartCalculator();
        System.out.println("Addition: " + calc.add(15, 10));
        System.out.println("Subtraction: " + calc.subtract(25, 5));
    }
}
