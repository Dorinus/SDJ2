package server;

import java.io.IOException;

public class RunServer
{

  public static void main(String[] args) throws IOException
  {
    EchoServer echoServer = new EchoServer();
    echoServer.start();
  }
}
