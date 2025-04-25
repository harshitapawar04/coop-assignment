package Assignment4;
class Shape{
    public void draw(){
        System.out.print("Drawing a shape");
    }
}
class Circle extends Shape{
    @Override
    public void draw() {
        System.out.print("Drawing a Circle");
    }
}
class Square extends Shape{
    @Override
    public void draw() {
        System.out.print("Drawing a Square");
    }
}
class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.print("Drawing a Triangle");
    }
}
public class DrawingShape{
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0]= new Circle();
        shapes[1]= new Square();
        shapes[2]= new Triangle();

        for(Shape shape :shapes){
            shape.draw();
            System.out.println();
        }
    }

}



