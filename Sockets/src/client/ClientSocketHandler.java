package client;

import shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientSocketHandler implements Runnable
{
  private EchoClient client;
  private Socket socket;
  private ObjectInputStream inFromServer;
  private ObjectOutputStream outToServer;

  public ClientSocketHandler(Socket socket, EchoClient client)
  {
    this.socket = socket;
//    this.client = client;
    try
    {
      outToServer = new ObjectOutputStream(socket.getOutputStream());
      inFromServer = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    try
    {
      while (true)
      {
        Message message = (Message) inFromServer.readObject();
        client.messageReceived(message.getMessage());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }

  public void sendMessage(String msg)
  {
    try
    {
      outToServer.writeObject(new Message(msg));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
