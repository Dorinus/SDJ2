import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientServer
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    Scanner scanner = new Scanner(System.in);
    while (true)
    {
      System.out.println("You want to: "
          + "\n1. Calculate VAT"
          + "\n2. Show if it is Prime"
          + "\n3. Reverse String");

      int choise = scanner.nextInt();
      int socketNumber = 0;
      if(choise == 1){
        socketNumber = 3333;
        System.out.print("Enter summ: ");
      } else if( choise ==2){
        System.out.print("Enter a number: ");
        socketNumber =3000;
      } else if(choise ==3){
        System.out.print("Enter a String: ");
        socketNumber =3000;
      }

      try
      {
        Socket socket = new Socket("localhost", socketNumber);
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());



        if (choise == 1)
        {
          double number = scanner.nextDouble();
          outToServer.writeUnshared(number);

          double vat = (Double) inFromServer.readObject();
          System.out.println("VAT for summ of " + number + " is " + vat + ".");

        }
        else if (choise == 2)
        {
          int number = (int) scanner.nextInt();
          outToServer.writeUnshared(number);

          boolean flag = (Boolean) inFromServer.readObject();
          System.out.println(number + " is a prime number: " + flag);
        }
        else if (choise == 3)
        {
          scanner.nextLine();
          String text = (String) scanner.nextLine();

          outToServer.writeUnshared(text);

          String reversed = (String) inFromServer.readObject();
          System.out.println(text + " in reverse is: " + reversed);
        }
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }
    }

  }
}
