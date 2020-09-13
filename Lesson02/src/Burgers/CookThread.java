package Burgers;

import java.util.Random;

public class CookThread implements Runnable
{

  private Burgers burgers;
  private static final Random random = new Random();

  public CookThread(Burgers burgers)
  {
    this.burgers = burgers;
  }

  public void run()
  {
    while (burgers.getBurgersNow() < burgers.getMaxNrOfBurgers())
    {
      try
      {
        Thread.sleep(random.nextInt(8000));
      }
      catch (InterruptedException e)
      {
      }
      burgers.make();
      System.out.println("Cook made a burger! Nr of burgers: " + burgers.getBurgersNow());
      if (burgers.getBurgersNow() == burgers.getMaxNrOfBurgers())
      {
        System.out.println("Our storage of burgers is full!");
      }
    }

  }
}
