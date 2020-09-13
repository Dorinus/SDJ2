package DoctorWaiting;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements Subject1, Runnable
{
  private int counter;
  private PropertyChangeSupport support;

  public WaitingRoom()
  {
    this.counter = 0;
    this.support = new PropertyChangeSupport(this);
  }

  @Override public void addListener(PropertyChangeListener propertyChangeListener)
  {
    support.addPropertyChangeListener(propertyChangeListener);
  }

  @Override public void removeListener(PropertyChangeListener propertyChangeListener)
  {
    support.removePropertyChangeListener(propertyChangeListener);
  }

  @Override public void run()
  {

    support.firePropertyChange("Counter++", counter-1, counter);

    while (true)
    {
      System.out.println("Diiing!");
      System.out.println(counter);

      try
      {
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {

      }

      counter++;
    }

  }
}
