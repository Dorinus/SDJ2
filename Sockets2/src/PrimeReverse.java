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

    while (true){
      Socket socket = serverSocket.accept();

      ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
      System.out.println("Connected to: PrimeReverse Server");


      int number = (int) inFromClient.readObject();
      boolean flag = false;
      for(int i = 2; i <= number/2; ++i)
      {
        if(number % i == 0)
        {
          flag = true;
          break;
        }
      }

      int reversed = 0;

      while(number != 0) {
        int digit = number % 10;
        reversed = reversed * 10 + digit;
        number /= 10;
      }

      ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
      outToClient.writeUnshared(flag);
      outToClient.writeUnshared(reversed);


    }
  }
}
