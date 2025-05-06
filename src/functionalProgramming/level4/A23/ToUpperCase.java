package functionalProgramming.level4.A23;

import java.util.List;
import java.util.function.Function;

public class ToUpperCase {


    public static void main(String[] args) {
        Function<String , String> toUpper = str->str.toUpperCase();

        Function<String, String> addExclamation = str->str+"!";

        //Function<String, String> composed= toUpper.andThen(addExclamation);
        Function<String, String> composed= toUpper.compose(addExclamation);
        System.out.println(composed.apply("hello"));


    }
}
