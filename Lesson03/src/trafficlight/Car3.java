package trafficlight;

import java.beans.PropertyChangeEvent;

public class Car3
{

  public Car3(PropretyChangeSubject subject)
  {
//    PropertyChangeListener listener = new PropertyChangeListener()
//    {
//      @Override public void propertyChange(PropertyChangeEvent propertyChangeEvent)
//      {
//        reacttochange(propertyChangeEvent);
//      }
//
//    };

//    PropertyChangeListener listener = propertyChangeEvent -> reacttochange(propertyChangeEvent);
//    subject.addListener(listener);


//    subject.addListener(propertyChangeEvent -> reacttochange(propertyChangeEvent));

    subject.addListener(this::reacttochange);
  }

  public void reacttochange(PropertyChangeEvent propertyChangeEvent)
  {
    String oldValue = (String) propertyChangeEvent.getOldValue();
    String newValue = (String) propertyChangeEvent.getNewValue();

    if ("GREEN".equals(newValue))
    {
      System.out.println("Car 3 " + " drives");
    }
    else if ("YELLOW".equals(newValue))
    {
      if ("RED".equals(oldValue))
      {
        System.out.println("Car 3 " + " turns engine on");
      }
      else
      {
        System.out.println("Car 3 " + " slows down");
      }
    }
    else if ("RED".equals(newValue))
    {
      System.out.println("Car 3 " + " stops");
    }
    oldValue = newValue;
  }
}
