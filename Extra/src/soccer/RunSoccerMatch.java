package soccer;

public class RunSoccerMatch
{
  public static void main(String[] args)
  {
    SoccerMatch soccerMatch = new SoccerMatch();
    Thread thread = new Thread(soccerMatch);

    FanA fanA= new FanA(soccerMatch);
    FanB fanB = new FanB(soccerMatch);

    thread.start();

  }

}
