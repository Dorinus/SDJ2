package trafficlight;

import java.beans.PropertyChangeEvent;

public class Pedestrian
{
  public Pedestrian(PropretyChangeSubject subject){
    subject.addListener("RED",this::reactRed);
    subject.addListener("YELLOW", this::reactYellow);
    subject.addListener("GREEN", this::reactGreen);
  }

  public void reactRed(PropertyChangeEvent event){
    System.out.println("Pedestrian stops in front of road crossing ");
  }

  public void reactYellow(PropertyChangeEvent event){
    if(event.getOldValue().equals("GREEN")){
      System.out.println("Pedestrian runs");
    } else{
      System.out.println("Pedestrin gets ready to move");
    }
  }

  public void reactGreen(PropertyChangeEvent event){
    System.out.println("Pedestrian starts crossing ");
  }
}
