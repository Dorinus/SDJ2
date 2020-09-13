package Homework;

public class TimeThread implements Runnable
{
  Time time;

  public TimeThread(Time time)
  {
    this.time = time;
  }

  @Override public void run()
  {
    while (true)
    {
      System.out.println(time);
      try
      {
        Thread.sleep(10000L);
      }
      catch (InterruptedException ex)
      {
      }
      time.tick(10);

    }
  }
}
