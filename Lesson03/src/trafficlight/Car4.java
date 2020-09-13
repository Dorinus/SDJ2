package trafficlight;

import java.beans.PropertyChangeEvent;

public class Car4
{
  public Car4(PropretyChangeSubject subject)
  {
    subject.addListener("GREEN", this::reactToGreen);
    subject.addListener("YELLOW", this::reactToYellow);
    subject.addListener("RED", this::reactToRed);

  }

  public void reactToRed(PropertyChangeEvent event)
  {
    System.out.println("Car 4 stops");
  }

  public void reactToYellow(PropertyChangeEvent event)
  {

      if ("RED".equals(event.getOldValue()))
      {
        System.out.println("Car 4 " + " turns engine on");
      }
      else
      {
        System.out.println("Car 4 " + " slows down");
      }
  }

  public void reactToGreen(PropertyChangeEvent event)
  {
    System.out.println("Car 4 starts moving");
  }
}
