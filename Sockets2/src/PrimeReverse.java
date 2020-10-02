import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PrimeReverse
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    ServerSocket serverSocket = new ServerSocket(3000);

    while (true)
    {
      Socket socket = serverSocket.accept();

      ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
      System.out.println("Connected to: PrimeReverse Server");

      Object data = inFromClient.readObject();

      if (data instanceof Integer)
      {
        int number = (int) data;
        boolean flag = true;
        for (int i = 2; i <= number / 2; ++i)
        {
          if (number % i == 0)
          {
            flag = false;
            break;
          }
        }
        outToClient.writeUnshared(flag);

      }
      else if (data instanceof String)
      {
        String text = (String) data;
        String reversed = new StringBuilder(text).reverse().toString();

        outToClient.writeUnshared(reversed);
      }
    }
  }
}
