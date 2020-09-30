package client;

import java.io.IOException;

public class RunClient
{
  public static void main(String[] args) throws IOException
  {
    EchoClient echoClient = new EchoClient();
    echoClient.start();
  }
}
