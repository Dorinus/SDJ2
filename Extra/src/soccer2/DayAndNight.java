package soccer2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DayAndNight implements DayAndNightSubject
{
  private PropertyChangeSupport support;
  private boolean isDay;

  public DayAndNight()
  {
    this.support = new PropertyChangeSupport(this);
    this.isDay = true;
  }


  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  public  void start(){

    int timer =0;
    while (timer<10){

      try
      {
        Thread.sleep(4000);
      } catch (InterruptedException e){

      }
      if(isDay){
        System.out.println("Time Passed now it is day");
      } else {
        System.out.println("Time Passed now it is night");
      }

      support.firePropertyChange("Time Passed", !isDay, isDay);

      isDay= !isDay;
      timer++;

    }
  }
}
