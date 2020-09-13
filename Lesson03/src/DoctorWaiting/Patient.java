package DoctorWaiting;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener
{
  private int ticketNumber;

  public Patient(int ticketNumber)
  {
    this.ticketNumber = ticketNumber;
    System.out.println("Patient " + ticketNumber + " enters the room.");
  }

  @Override public void propertyChange(PropertyChangeEvent event)
  {

    Integer newValue = (Integer) event.getNewValue();

    if (ticketNumber >= newValue)
    {
      System.out.println("Patient " + ticketNumber + " looks up");
      if (ticketNumber == newValue)
      {
        System.out.println("Patient " + ticketNumber + " goes to doctors room");
      }
      else
      {
        System.out.println("Patient " + ticketNumber + " goes back to looking at phone");
      }
    }

  }
}
