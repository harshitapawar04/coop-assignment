package functionalProgramming.level1.A2;

import java.util.function.Function;

public class StringLengthApply {
    public static void main(String[] args) {
        Function<String, Integer> lengthOfString= s->s.length();

        String s= "Harshita";
        System.out.println("lenth of the given stirng" +s+" -> " + lengthOfString.apply(s));
    }
}
