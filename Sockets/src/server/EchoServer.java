package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{


  public void start() throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(3333);
    System.out.println("Server started");
    ConnectionPool pool = new ConnectionPool();

    while (true){
      Socket socket = serverSocket.accept(); // listesns to a connection to be made to this socket and accepts it;
      System.out.println("Connection Established");
      ServerSocketHandler handler = new ServerSocketHandler(socket, pool);
      pool.addHandler(handler);
      new Thread(handler).start();  // added handler

    }
  }
}
