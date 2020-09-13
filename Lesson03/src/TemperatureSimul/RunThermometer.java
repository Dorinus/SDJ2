package TemperatureSimul;

public class RunThermometer
{
  public static void main(String[] args)
  {
    Thread thermometer = new Thread ( new Thermometer1("t1", 15,1));
    Thread thermometer2 = new Thread(new Thermometer1("t2", 15,7));
    thermometer.start();
    thermometer2.start();
  }
}
