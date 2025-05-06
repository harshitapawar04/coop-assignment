package functionalProgramming.level5.A29;

@FunctionalInterface
interface TriFunction<T, U, V, R>{
    R apply(T t, U u, V v);
}
public class CreateFunInterface {
    public static void main(String[] args) {
        TriFunction<String , String ,String, String> concat= (a, b, c)->a+b+c;

        String result= concat.apply("Hello, ", "functional ", "interface!");
        System.out.println("Result : " + result);
    }
}
