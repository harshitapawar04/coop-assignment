package functionalProgramming.level1.A3;

import java.util.function.Consumer;

public class UpperCaseAccept {
    public static void main(String[] args) {
        Consumer<String> convertToUppercase = s-> System.out.println(s.toUpperCase());
        String s = "hello";
       convertToUppercase.accept(s);
    }
}
