package trafficlight;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car2
{

  public Car2(PropretyChangeSubject subject)
  {
    PropertyChangeListener listener = new PropertyChangeListener()
    {
      @Override public void propertyChange(PropertyChangeEvent propertyChangeEvent)
      {
        reacttochange(propertyChangeEvent);
      }

    };
    subject.addListener(listener);;
  }

  public void reacttochange(PropertyChangeEvent propertyChangeEvent)
  {
    String oldValue = (String) propertyChangeEvent.getOldValue();
    String newValue = (String) propertyChangeEvent.getNewValue();

    if ("GREEN".equals(newValue))
    {
      System.out.println("Car 2 " + " drives");
    }
    else if ("YELLOW".equals(newValue))
    {
      if ("RED".equals(oldValue))
      {
        System.out.println("Car 2 " + " turns engine on");
      }
      else
      {
        System.out.println("Car 2 " + " slows down");
      }
    }
    else if ("RED".equals(newValue))
    {
      System.out.println("Car 2 " + " stops");
    }
    oldValue = newValue;
  }
}
