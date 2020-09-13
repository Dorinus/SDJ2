package trafficlight;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements PropertyChangeListener
{

  private int id =1;
  private String previousLight;

  public Car()
  {
  }

  private void lightChanged(String light)
  {

    if ("GREEN".equals(light))
    {
      System.out.println("Car " + id + " drives");
    }
    else if ("YELLOW".equals(light))
    {
      if ("RED".equals(previousLight))
      {
        System.out.println("Car " + id + " turns engine on");
      }
      else
      {
        System.out.println("Car " + id + " slows down");
      }
    }
    else if ("RED".equals(light))
    {
      System.out.println("Car " + id + " stops");
    }
    previousLight = light;
  }

  @Override public void propertyChange(PropertyChangeEvent propertyChangeEvent)
  {
    String oldValue = (String) propertyChangeEvent.getOldValue();
    String newValue = (String) propertyChangeEvent.getNewValue();

    lightChanged(newValue);
  }
}

