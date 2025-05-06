package functionalProgramming.level4.A25;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
}


public class FilterAdults {
    public static void main(String[] args) {
        List<Person> people= Arrays.asList(
                new Person("Alice", 17),
                new Person("Bob", 22),
                new Person("Charlie", 19),
                new Person("David", 15),
                new Person("Eve", 25)
        );

        List<String>adults= people.stream()
                .filter(person -> person.getAge()>18)
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(adults);
    }
}
