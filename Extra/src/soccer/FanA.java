package soccer;

import java.beans.PropertyChangeEvent;

public class FanA
{


  public FanA(PropretyChangeSubject  subject)
  {
    subject.addListener("TeamA", this::reactToA);
    subject.addListener("TeamB", this::reactToB);
    subject.addListener("0 Score", this::reactTo0);
  }

  public void reactToA(PropertyChangeEvent event){
    System.out.println("Fan A: Uraaa. We sent them " + event.getNewValue() +" goals" );
  }
  public void reactToB(PropertyChangeEvent event){
    System.out.println("Fan A: Fuuuu");
  }
  public void reactTo0(PropertyChangeEvent event){
    System.out.println("Fan A: Ahhhh");
  }


}
