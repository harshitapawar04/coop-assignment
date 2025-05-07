package functionalProgramming.level7.A39;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AgeGroupClassifier {
    public static Map<String, List<Person>> groupByAge (List<Person> people){
        return people.stream()
                .collect(Collectors.groupingBy(person -> {
                    int age= person.getAge();
                    if(age<20) return "<=20";
                    else if (age>20 && age<=40)  return "<40";
                    else return "+40";
                }));
    }
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 18),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("David", 45),
                new Person("Eve", 60)
        );

        Map<String, List<Person>> grouped= groupByAge(people);
        grouped.forEach((group, list)->{
            System.out.println(group +"->" + list);
        });
    }
}
