package Assignment2;

class Vehicle{
  protected int speed;
  protected int totalFuel;

  public Vehicle(int speed, int totalFuel){
      this.speed=speed;
      this.totalFuel=totalFuel;
  }
  public void showDetail(){
      System.out.println("Speed of the vehicle:"+ speed);
      System.out.println("Fuel:"+ totalFuel);
  }
}

class Car extends Vehicle{
    public Car(int speed, int totalFuel){
        super(speed, totalFuel);
    }
    public int calculateMileage(){
        return totalFuel*20;
    }
}
class Truck extends Vehicle{
    public Truck(int speed, int totalFuel){
        super(speed, totalFuel);
    }
    public int calculateMileage(){
        int distanceTravelled=200;
        return totalFuel*8;
    }
}

public class VehicleManagement{
    public static void main(String[] args) {
        Car car= new Car(60, 30);
        Truck truck = new Truck(40, 90);
        System.out.println("Detail of the car");
        car.showDetail();
        System.out.println("Mileage of Car: " + car.calculateMileage()+"km/hr");
        System.out.println();
        System.out.println("Detail of the car");
        car.showDetail();
        System.out.println("Mileage of Truck: " + truck.calculateMileage());
    }
}



