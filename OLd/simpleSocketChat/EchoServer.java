package simpleSocketChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    ServerSocket serverSocket = new ServerSocket(3333);
    System.out.println("Server started");


    while (true){
      Socket socket = serverSocket.accept(); // listesns to a connection to be made to this socket and accepts it;
      System.out.println("Connection Established");

      ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

      Message readFromClient = (Message) inFromClient.readObject();
      System.out.println("Received: " + readFromClient.getMessage());

      String result = readFromClient.getMessage().toUpperCase();
      outToClient.writeObject(new Message(result));
    }
  }
}
