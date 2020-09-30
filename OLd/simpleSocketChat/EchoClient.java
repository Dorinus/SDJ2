package simpleSocketChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class EchoClient
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 3333);

    ObjectOutputStream outToServer= new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

    String arg = "hello again";
    System.out.println("Sending" + arg);
    outToServer.writeObject(new Message(arg));

    Message result = (Message) inFromServer.readObject();
    System.out.println(result.getMessage());

  }
}
