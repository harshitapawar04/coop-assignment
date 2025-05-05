package functionalProgramming.level1.A1;

import java.util.function.Predicate;

public class StartsWithATest {
    public static void main(String[] args) {
        Predicate<String>startswithA= (s)-> s.startsWith("A");
        String[] testStrings= {"Apple", "Banana", "Avocado", "apricot", "Almond"};

        for(String str : testStrings){
            if(startswithA.test(str))
                System.out.println(str +" starts with A");
            else
                System.out.println(str+ "does not starts with A");
        }
    }
}
