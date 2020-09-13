package Homework;

import java.util.Scanner;

public class SetTimeThread implements Runnable
{
  Time time;

  public SetTimeThread(Time time)
  {
    this.time = time;
  }

  public void run(){
    int a=0;

    while (true){
      Scanner scanner= new Scanner(System.in);
        a= scanner.nextInt();
      time.setHours(a);
      a= scanner.nextInt();
      time.setMinutes(a);
      a= scanner.nextInt();
      time.setSeconds(a);

    }

  }
}
