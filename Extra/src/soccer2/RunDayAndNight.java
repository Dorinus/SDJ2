package soccer2;

public class RunDayAndNight
{
  public static void main(String[] args)
  {
    DayAndNight dayAndNight = new DayAndNight();
    Deer deer = new Deer("Afrose");
    Racoon racoon = new Racoon("Lambda", dayAndNight);


    dayAndNight.addListener(deer);
    dayAndNight.start();
  }
}
