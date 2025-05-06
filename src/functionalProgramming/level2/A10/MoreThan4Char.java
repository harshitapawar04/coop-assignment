//Given a list of names, return a list of names longer than 4 characters.
package functionalProgramming.level2.A10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoreThan4Char {
    public static void main(String[] args) {
        String[] fruits= {"Apple","Bite", "Avocado","Bot", "apricot", "Almond", "Cat"};

        List<String>newList= Arrays.stream(fruits)
                .filter(fruit->fruit.length()>4)
                .collect(Collectors.toList());

        System.out.println(newList);
    }
}
