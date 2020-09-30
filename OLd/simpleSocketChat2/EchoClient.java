package simpleSocketChat2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 3333);

    ObjectOutputStream outToServer= new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    Scanner in = new Scanner(System.in);

    while (true)
    {
      System.out.print("Input >");
      String arg = in.nextLine();
      outToServer.writeObject(new Message(arg));
      if(arg.equalsIgnoreCase("exit")){
        socket.close();
        break;
      }
      Message result = (Message) inFromServer.readObject();
      System.out.println(result.getMessage());
    }

  }
}
