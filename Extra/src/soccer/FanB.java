package soccer;

import java.beans.PropertyChangeEvent;

public class FanB
{


  public FanB(PropretyChangeSubject  subject)
  {
    subject.addListener("TeamA", this::reactToA);
    subject.addListener("TeamB", this::reactToB);
    subject.addListener("0 Score", this::reactTo0);
  }

  public void reactToA(PropertyChangeEvent event){
    System.out.println("Fan B: Why, fucking why");
  }
  public void reactToB(PropertyChangeEvent event){
    System.out.println("Fan B: Ye, smash them like so.  We sent them "  + event.getNewValue() +" goals");
  }
  public void reactTo0(PropertyChangeEvent event){
    System.out.println("Fan B: Will take them next time");
  }


}
