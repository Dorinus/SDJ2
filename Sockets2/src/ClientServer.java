import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientServer
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("You want to: "
        + "\n1. Calculate VAT"
        + "\n2. Prime and Reverse Number");

    int choise = scanner.nextInt();
    int socketNumber = 0;
    if(choise == 1){
      socketNumber = 3333;
      System.out.print("Enter summ: ");
    } else if( choise ==2){
      System.out.print("Enter a number: ");
      socketNumber =3000;
    }


    try
    {
      Socket socket = new Socket("localhost",socketNumber);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      double number = scanner.nextDouble();
      outToServer.writeUnshared(number);

      if(choise == 1){


        double vat = (Double) inFromServer.readObject();
        System.out.println("VAT for summ of " + number + " is " + vat+".");

      } else if( choise ==2){



        boolean flag = (Boolean) inFromServer.readObject();
        int reversed = (Integer) inFromServer.readObject();
        System.out.println(number + " is a prime number: " +flag+
            "\n"+number+" in reverse is: " + reversed);
      }


    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }
}
