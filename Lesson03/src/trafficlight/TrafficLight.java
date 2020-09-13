package trafficlight;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight implements PropretyChangeSubject
{

  private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
  private int lightIndex = 2;
  private String currentLight;

  private PropertyChangeSupport support;

  public TrafficLight()
  {
    currentLight = lights[lightIndex];
    support = new PropertyChangeSupport(this);
  }

  public void start() throws InterruptedException
  {
    String previous = "";
    for (int i = 0; i < 10; i++)
    {
      Thread.sleep(1000);
      lightIndex = (++lightIndex) % 4;
      previous = currentLight;
      currentLight = lights[lightIndex];
      System.out.println("\nLight is " + currentLight);

//      support.firePropertyChange("LightChanged", previous, currentLight);
      support.firePropertyChange(currentLight,previous,currentLight);

    }

  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    if (eventName == null || "".equals(eventName))
    {
      support.addPropertyChangeListener(listener);
    }
    else
    {
      support.addPropertyChangeListener(eventName, listener);
    }
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    if (eventName == null || "".equals(eventName))
    {
      support.removePropertyChangeListener(listener);
    }
    else
    {
      support.removePropertyChangeListener(eventName, listener);
    }
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
