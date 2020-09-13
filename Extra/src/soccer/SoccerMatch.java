package soccer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropretyChangeSubject, Runnable
{

  private PropertyChangeSupport support;
  private int teamA, teamB;
  private Random random;

  public SoccerMatch()
  {
    this.support = new PropertyChangeSupport(this);
    this.teamA = 0;
    this.teamB = 0;
    this.random = new Random();
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
     support.removePropertyChangeListener(listener);
  }

  @Override public void addListener(String name, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removeListener(String name, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void run()
  {

    System.out.println("Match Starts");
    int timer = 0;
    int randomNumber = 0;
    while (timer< 90){
      System.out.println("--------------------------------");

      randomNumber = random.nextInt(10);

      if(randomNumber == 0){
        teamA++;
        System.out.println("Team A scores, it's score now is: " + teamA);
        support.firePropertyChange("TeamA", (teamA-1), teamA);

      } else if(randomNumber== 1){
        teamB++;
        System.out.println("Team B scores, it's score now is: " + teamB);
        support.firePropertyChange("TeamB", (teamB-1), teamB);

      } else if(randomNumber>1) { //why
        System.out.println("This minute no goal");
        support.firePropertyChange("0 Score",teamA, teamB);
      }
      timer++;
    }


  }
}
