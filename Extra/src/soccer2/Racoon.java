package soccer2;

import java.beans.PropertyChangeEvent;

public class Racoon
{
  private String name;

  public Racoon(String name, DayAndNightSubject subject)
  {
    this.name = name;
    subject.addListener(this::dayChanged);
  }

  public void dayChanged(PropertyChangeEvent event){
    boolean isDay = (boolean) event.getNewValue();

    if (!isDay)
    {
      System.out.println("Racoon " + name + " wakes up and goes to eat");
    } else {
      System.out.println("Racoon " + name + " goes to sleep");
    }
  }
}
