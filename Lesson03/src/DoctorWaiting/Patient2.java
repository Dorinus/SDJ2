package DoctorWaiting;

import java.beans.PropertyChangeEvent;

public class Patient2
{
  private int ticketNumber;

  public Patient2(int ticketNumber, Subject1 subject)
  {

    System.out.println("Patient " + ticketNumber + " enters the room.");
    this.ticketNumber = ticketNumber;
    subject.addListener(this::check);

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
