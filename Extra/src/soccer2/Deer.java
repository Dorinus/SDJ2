package soccer2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Deer implements PropertyChangeListener
{
  private String name;

  public Deer(String name)
  {
    this.name = name;
  }

  public void dayChanged(Boolean isDay){
    if (isDay)
    {
      System.out.println("Deer " + name + " wakes up and goes to eat");
    } else {
      System.out.println("Deer " + name + " goes to sleep");
    }
  }

  @Override public void propertyChange(PropertyChangeEvent event)
  {
    dayChanged((Boolean) event.getNewValue());
  }
}
