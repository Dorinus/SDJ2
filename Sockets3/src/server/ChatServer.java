package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{

  public void start()
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(3000);
      ConnectionPool pool = new ConnectionPool();

      System.out.println("Server starter..");

      while (true){
        Socket socket = serverSocket.accept();
        ChatServerHandler csh = new ChatServerHandler(socket, pool);
        pool.addConnection(csh);
        Thread t = new Thread(csh);
        t.start();

      }

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
