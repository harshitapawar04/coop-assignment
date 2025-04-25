package Assignment9;

class Animal{
    public void makeSound(){
        System.out.println("Make sound: ");
    }
}
class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Cat");
        super.makeSound();
        System.out.println("Meow Meow");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Dog");
        super.makeSound();
        System.out.println("Bhaw Bhaw");
    }
}

public class AnimalSound {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat=new Cat();
        Dog dog= new Dog();
        cat.makeSound();
        System.out.println();
        dog.makeSound();
    }
}
