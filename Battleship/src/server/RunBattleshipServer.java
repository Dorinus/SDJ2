package server;

import server.dataaccess.InMemoryUsers;
import server.dataaccess.UserHome;
import server.model.GameModel;
import server.model.ModelManager;
import server.networking.BattleshipServer;

import java.io.IOException;

public class RunBattleshipServer
{
  public static void main(String[] args)
  {
    UserHome userHome = new InMemoryUsers();
    GameModel gameModel = new ModelManager(userHome);
    BattleshipServer battleshipServer = new BattleshipServer(gameModel);
    try
    {
      battleshipServer.startServer();
    }
    catch (IOException e)
    {
      System.out.println("Complete failure to launch");
    }



  }
}
