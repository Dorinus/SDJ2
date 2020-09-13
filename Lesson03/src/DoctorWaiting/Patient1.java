package DoctorWaiting;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient1
{
  private int ticketNumber;

  public Patient1(int ticketNumber, Subject1 subject)
  {

    System.out.println("Patient " + ticketNumber + " enters the room.");
    this.ticketNumber = ticketNumber;
    PropertyChangeListener listener = new PropertyChangeListener()
    {
      @Override public void propertyChange(PropertyChangeEvent evt)
      {
        check(evt);
      }
    };

    subject.addListener(listener);
  }



  public void check(PropertyChangeEvent event)
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
