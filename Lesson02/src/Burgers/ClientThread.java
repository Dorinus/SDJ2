package Burgers;

import java.util.Random;

public class ClientThread implements Runnable
{
  private Burgers burgers;
  private Random random = new Random();
  private int x;

  public ClientThread(Burgers burgers)
  {
    this.burgers = burgers;
  }

  @Override public void run()
  {
    while(true){
      try{
        Thread.sleep(random.nextInt(12000));
      }
      catch (InterruptedException e){
      }

      x = random.nextInt(3)+1;
      System.out.println("Customer wants "+ x + " burgers");


      if (burgers.getBurgersNow()<x){
        System.out.println("Customer waits for burgers to be prepared!");
      }


      if(burgers.getBurgersNow()>=x){
        burgers.sellBurger(x);
        System.out.println("Customer bought " + x + " burgers. There are " + burgers.getBurgersNow() +" left.");
      }


    }
  }
}
