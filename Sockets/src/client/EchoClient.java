package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient
{
  public void start() throws IOException
  {
    Socket socket = new Socket("localhost", 3333);

    ClientSocketHandler handler = new ClientSocketHandler(socket, this);
    Thread thread = new Thread(handler);
    thread.setDaemon(true);
    thread.start();
    Scanner in = new Scanner(System.in);

    while (true)
    {
      System.out.print("Input >");
      String arg = in.nextLine();
      handler.sendMessage(arg);

      if (arg.equalsIgnoreCase("exit"))
      {
        socket.close();
        break;
      }
    }
  }

  public void messageReceived(String message)
  {
    System.out.println(message);
  }
}
