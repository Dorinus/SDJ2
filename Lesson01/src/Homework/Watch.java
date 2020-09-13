package Homework;

public class Watch
{
  public static void main(String[] args)
  {
    Time time = new Time(0,0,0);


    Thread thread1 = new Thread(new TimeThread(time));
    Thread thread2 = new Thread(new SetTimeThread(time));

    thread1.start();
    thread2.start();

  }
}
