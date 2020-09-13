package trafficlight;

public class RunTrafficLight
{
  public static void main(String[] args) throws InterruptedException
  {
    TrafficLight trafficLight = new TrafficLight();
    Car car  =new Car();
    Car2 car2 =new Car2(trafficLight);
    Car3 car3 = new Car3(trafficLight);
    Car4 car4= new Car4(trafficLight  );
    Pedestrian pedestrian= new Pedestrian(trafficLight);

    trafficLight.addListener(car);
    trafficLight.start();
  }



}
