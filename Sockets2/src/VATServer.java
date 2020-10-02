import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class VATServer
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    ServerSocket serverSocket = new ServerSocket(3333);

    while (true){
      Socket socket = serverSocket.accept();
      System.out.println("Connected to: VAT Server");

      ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream()) ;
      ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
      double summ = (double) inFromClient.readObject();
      System.out.println("Summ of: " + summ +" received");

      double vat = summ*0.25;


      outToClient.writeUnshared(vat);
    }
  }
}
